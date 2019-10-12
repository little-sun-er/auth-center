package com.rainsunset.auth.common.enums;

import com.rainsunset.common.bean.ErrorInfoInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @description: auth-center服务相关业务异常枚举
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-27
 */
@Getter
@AllArgsConstructor
public enum ServiceErrorInfoEnum implements ErrorInfoInterface {
    /**
     * 200，成功
     * 201，已存在
     * 401，未授权
     * 403，禁止
     * 404，不存在
     * 405，状态异常
     * 412，前提条件失败
     * 415，格式错
     * 500，内部错误
     */

    // 412，前提条件失败
    // region 412000-412099 登陆失败
    AUTH_412000("AUTH_412000", "用户名或密码错误"),
    AUTH_412001("AUTH_412001", "账号暂时锁定"),
    AUTH_412002("AUTH_412002", "账号锁死"),
    AUTH_412003("AUTH_412003", "账号已过期"),
    AUTH_412004("AUTH_412004", "账号已注销"),
    // endregion

    // 参数异常
    AUTH_415000("AUTH_415000", "请求参数非法"),

    // 500 内部错误
    AUTH_500001("AUTH_500001", "数据库异常"),
    AUTH_500002("AUTH_500002", "资源繁忙"),
    AUTH_500003("AUTH_500003", "系统配置错误"),
    ;

    private String code;

    private String message;

    /**
     * 通过错误码code获取错误描述
     *
     * @param code
     * @return
     */
    public static String getMsgByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (ServiceErrorInfoEnum enums : ServiceErrorInfoEnum.values()) {
            if (enums.getCode().equals(code)) {
                return enums.getMessage();
            }
        }
        return code + "未定义";
    }

}
