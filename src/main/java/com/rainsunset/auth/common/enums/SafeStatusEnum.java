package com.rainsunset.auth.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @description: 账户安全状态枚举
 * @author: 李刚伟
 * @company CMBI
 * @date: 2019-09-27
 */
@Getter
@AllArgsConstructor
public enum SafeStatusEnum {
    // NORMAL:正常;LOW_RISK:低风险;HIGH_RISK:高风险;DANGER:危险;
    NORMAL("NORMAL","正常"),
    LOW_RISK("LOW_RISK","低风险"),
    HIGH_RISK("HIGH_RISK","高风险"),
    DANGER("DANGER","危险"),
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
        for (SafeStatusEnum enums : SafeStatusEnum.values()) {
            if (enums.getCode().equals(code)) {
                return enums.getMessage();
            }
        }
        return code + "未定义";
    }
}
