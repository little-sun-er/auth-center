package com.rainsunset.auth.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @description: 用户特征类型枚举
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-08
 */
@Getter
@AllArgsConstructor
public enum FeatureTypeEnum {
    // 特征识别登录(注册): FINGERPRINT:指纹识别;FACE:面部识别;CARD:身份证识别;
    // 设备授权登录: TRUSTED_DEVICE:信任设备;
    FINGERPRINT("FINGERPRINT","指纹识别"),
    FACE("FACE","面部识别"),
    CARD("CARD","身份证识别"),

    TRUSTED_DEVICE("TRUSTED_DEVICE","信任设备"),
    ;
    private String code;

    private String message;

    /**
     * Get msg by code string.
     *
     * @param code the code
     * @return the string
     * @author : ligangwei / 2019-10-8 4:13:40
     */
    public static String getMsgByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (FeatureTypeEnum enums : FeatureTypeEnum.values()) {
            if (enums.getCode().equals(code)) {
                return enums.getMessage();
            }
        }
        return code + "未定义";
    }
}
