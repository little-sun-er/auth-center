package com.rainsunset.auth.common.constant;

import com.rainsunset.common.util.DigestAlgorithmUtil;
import com.rainsunset.common.util.StringUtil;

/**
 * @description: 公共系统变量
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-27
 */
public class Constants {
    /** 日志 */
    public static final String TRACE_LOG_ID = "TRACE_LOG_ID";

    /** 截取uid作为密码盐 - 起始下标(包含) */
    private static final Integer PWD_SALT_UID_START = 5;

    /** 截取uid作为密码盐 - 长度 */
    private static final Integer PWD_SALT_UID_LENGTH = 8;

    /** 利用uid生成加盐密码 **/
    public static String generatePwd(String loginKey, String uid) {
        String pwdSalt = uid.substring(Constants.PWD_SALT_UID_START, Constants.PWD_SALT_UID_START + Constants.PWD_SALT_UID_LENGTH);
        return DigestAlgorithmUtil.getSHA256(StringUtil.conlitionStr(loginKey, pwdSalt));
    }

    /** Token Redis key Header */
    public static final String REDIS_TOKEN_HEADER = "LOGIN_TOKEN";

}
