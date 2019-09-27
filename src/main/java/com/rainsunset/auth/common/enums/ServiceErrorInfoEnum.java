package com.rainsunset.auth.common.enums;

import com.rainsunset.common.bean.ErrorInfoInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @description: auth-center服务相关业务异常枚举
 * @author: 李刚伟
 * @company CMBI
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

    // 参数异常
    AUTH_415000("AUTH_415000","请求参数非法"),


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
