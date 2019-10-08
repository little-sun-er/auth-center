package com.rainsunset.auth.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 性别枚举
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-27
 */
@Getter
@AllArgsConstructor
public enum SexEnum {
    // 0:女;1:男;
    GIRL(0,"女"),
    BOY(1,"男"),
    ;
    private Integer code;

    private String message;

    /**
     * Get msg by code string.
     *
     * @param code the code
     * @return the string
     * @author : ligangwei / 2019-9-27 9:43:11
     */
    public static String getMsgByCode(Integer code) {
        if (null == code) {
            return "";
        }
        for (SexEnum enums : SexEnum.values()) {
            if (enums.getCode().equals(code)) {
                return enums.getMessage();
            }
        }
        return code + "未定义";
    }
}
