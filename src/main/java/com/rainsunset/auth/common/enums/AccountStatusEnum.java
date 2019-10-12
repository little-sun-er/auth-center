package com.rainsunset.auth.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @description: 账户状态枚举
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-27
 */
@Getter
@AllArgsConstructor
public enum AccountStatusEnum {
    // 账户状态(LOGIN_FAIL:登陆失败;PWD_INIT:密码初始化;UAUAL:正常;PART_LOCK:暂时锁定;LOCK_OUT:锁死;OVER_TIME:过期失效;WIRTE_OFF:注销;)
    LOGIN_FAIL("LOGIN_FAIL", "登陆失败"),
    PWD_INIT("PWD_INIT", "密码初始化"),
    UAUAL("UAUAL", "正常"),
    PART_LOCK("PART_LOCK", "暂时锁定"),
    LOCK_OUT("LOCK_OUT", "锁死"),
    OVER_TIME("OVER_TIME", "过期失效"),
    WIRTE_OFF("WIRTE_OFF", "注销"),
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
        for (AccountStatusEnum enums : AccountStatusEnum.values()) {
            if (enums.getCode().equals(code)) {
                return enums.getMessage();
            }
        }
        return code + "未定义";
    }
}
