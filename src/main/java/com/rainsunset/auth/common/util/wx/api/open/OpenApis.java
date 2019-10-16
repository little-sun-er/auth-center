package com.rainsunset.auth.common.util.wx.api.open;

/**
 * @description: 微信开放平台Api
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-14
 */
public class OpenApis {

    // 移动应用/网站应用 - 授权后通过code获取access_token(GET)
    public static final String API_GET_USER_OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
    public static final String P_GET_USER_OAUTH2_ACCESS_TOKEN_APPID = "appid";
    public static final String P_GET_USER_OAUTH2_ACCESS_TOKEN_SECRET = "secret";
    public static final String P_GET_USER_OAUTH2_ACCESS_TOKEN_CODE = "code";
    public static final String P_GET_USER_OAUTH2_ACCESS_TOKEN_GRANT_TYPE = "grant_type";

    // 获取微信用户个人信息(GTE)
    public static final String API_GET_USERINFO = "https://api.weixin.qq.com/sns/userinfo";
    public static final String P_GET_USERINFO_ACCESS_TOKEN = "access_token";
    public static final String P_GET_USERINFO_OPENID = "openid";

}
