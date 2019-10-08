package com.rainsunset.auth.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @description: 登录类型枚举
 * @author: 李刚伟
 * @company CMBI
 * @date: 2019-09-27
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {
    // 登录名密码登录: PHONE_PWD:手机号密码;EMAIL_PWD:邮箱密码;CARD_PWD:身份证号密码;
    // 验证登录(注册):PHONE_CODE:手机号验证码;EMAIL_CODE:邮箱验证码;
    // 第三方授权登录(注册): WCHAT:微信;WEIBO:微博;QQ:QQ;GITHUB:Github;GOOGLE:Google;FACEBOOK:Facebook;TWITTER:Twitter;
    PHONE_PWD("PHONE_PWD","手机号密码"),
    EMAIL_PWD("EMAIL_PWD","邮箱密码"),
    CARD_PWD("CARD_PWD","身份证号密码"),

    PHONE_CODE("PHONE_CODE","手机号验证码"),
    EMAIL_CODE("EMAIL_CODE","邮箱验证码"),

    WCHAT("WCHAT","微信"),
    WEIBO("WEIBO","微博"),
    QQ("QQ","QQ"),
    GITHUB("GITHUB","Github"),
    GOOGLE("GOOGLE","Google"),
    FACEBOOK("FACEBOOK","Facebook"),
    TWITTER("TWITTER","Twitter"),
    ;
    private String code;

    private String message;

    /**
     * Get msg by code string.
     *
     * @param code the code
     * @return the string
     * @author : ligangwei / 2019-9-27 9:43:11
     */
    public static String getMsgByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (LoginTypeEnum enums : LoginTypeEnum.values()) {
            if (enums.getCode().equals(code)) {
                return enums.getMessage();
            }
        }
        return code + "未定义";
    }
}
