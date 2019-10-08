package com.rainsunset.auth.service.aop;

import com.google.common.base.Throwables;
import com.rainsunset.auth.common.constant.Constants;
import com.rainsunset.auth.common.enums.ServiceErrorInfoEnum;
import com.rainsunset.common.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @version : 1.0
 * @description: 日志 、异常统一处理
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019 -09-27
 */
@Slf4j
@Aspect
@Component
public class AppAspect {
    private static final String ERROR_MSG = "call [{}] [{}] [{}ms] [{}] [{}] RESPONSE:Result{} Cause:{}";
    @Autowired
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    @Around("execution(public * com.rainsunset.auth.service.impl.*.*(..))")
    public ResponseResult serviceAccess(ProceedingJoinPoint joinPoint) {
        // 计时
        long startTime = System.currentTimeMillis();

        ResponseResult response = null;
        // 获得类名
        String clazzName = joinPoint.getTarget().getClass().getSimpleName();
        // 获得方法名
        String methodName = joinPoint.getSignature().getName();
        // 获得参数列表
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            // 初始化日志ID
            initMDC(args);
            Object argObject = args[0];
            log.info("call [{}] [{}] PARAMETER:[{}]", clazzName, methodName, argObject);
            try {
                // 参数校验
                validate(argObject);
                // 业务执行
                response = (ResponseResult) joinPoint.proceed();
                log.info("call [{}] [{}] [{}ms] [{}] [{}] RESPONSE:Result{}", clazzName, methodName,
                        getTime(startTime), "Success", response.getErrorCode(), response);
            } catch (GlobalErrorInfoException e) {
                response = RestResultGenerator.genResult(e);
                log.info(ERROR_MSG, clazzName, methodName, getTime(startTime), "Success",
                        response.getErrorCode(), response, e);
            } catch (DataAccessException e) {
                response = RestResultGenerator.genErrorResult(ServiceErrorInfoEnum.AUTH_500001);
                log.error(ERROR_MSG, clazzName, methodName, getTime(startTime), "Failure",
                        response.getErrorCode(), response, Throwables.getStackTraceAsString(e));
            } catch (Throwable throwable) {
                response = RestResultGenerator.genErrorResult(GlobalErrorInfoEnum.SYSTEM_ERROR);
                log.error(ERROR_MSG, clazzName, methodName, getTime(startTime), "Failure",
                        response.getErrorCode(), response, Throwables.getStackTraceAsString(throwable));
            }
        }
        return response;
    }

    /**
     * 初始化日志ID
     *
     * @param args 入参
     */
    private String initMDC(Object[] args) {
        if (args.length > 0) {
            Object argObject = args[0];
            if (argObject instanceof BaseRequest) {
                String traceLogId = ((BaseRequest) argObject).getTraceLogId();
                if (StringUtils.isEmpty(traceLogId)) {
                    Integer random = (int)(100 * Math.random());
                    StringBuilder stringBuilder = new StringBuilder("auth_");
                    stringBuilder.append(System.currentTimeMillis()).append("_").append(random);
                    traceLogId = stringBuilder.toString();
                }
                MDC.put(Constants.TRACE_LOG_ID, traceLogId);
                return traceLogId;
            }
        }
        return null;
    }

    /**
     * 参数校验
     *
     * @param object 校验对象
     * @throws GlobalErrorInfoException
     */
    private <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = localValidatorFactoryBean.validate(
                object, groups);
        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            ConstraintViolation constraintViolation = constraintViolations.iterator().next();
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_415000, constraintViolation.getMessage());
        }
    }

    /**
     * 获取耗时
     *
     * @param startTime 开始时间
     * @return 耗时(单位毫秒)
     */
    private long getTime(long startTime) {
        return System.currentTimeMillis() - startTime;
    }

}