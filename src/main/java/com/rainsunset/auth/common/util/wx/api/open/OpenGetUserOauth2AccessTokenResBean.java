package com.rainsunset.auth.common.util.wx.api.open;

import lombok.Data;

/**
 * @description: 移动应用/网站应用 - 授权后通过code获取access_token 返回体
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-14
 */
@Data
public class OpenGetUserOauth2AccessTokenResBean {

    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 7200
     * refresh_token : REFRESH_TOKEN
     * openid : OPENID
     * scope : SCOPE
     * unionid : o6_bmasdasdsad6_2sgVt7hMZOPfL
     * errcode :
     * errmsg :
     */

    /** 接口调用凭证 */
    private String access_token;

    /** access_token接口调用凭证超时时间，单位（秒）*/
    private Integer expires_in;

    /** 用户刷新access_token */
    private String refresh_token;

    /** 授权用户唯一标识 */
    private String openid;

    /** 用户授权的作用域，使用逗号（,）分隔 */
    private String scope;

    /** 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段 */
    private String unionid;

    /** 错误码 */
    private Integer errcode = 0;

    /** 错误信息 */
    private String errmsg = "";
}
