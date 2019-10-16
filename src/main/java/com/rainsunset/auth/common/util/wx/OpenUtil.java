package com.rainsunset.auth.common.util.wx;

import com.google.gson.reflect.TypeToken;
import com.rainsunset.auth.common.util.wx.api.open.OpenApis;
import com.rainsunset.auth.common.util.wx.api.open.OpenGetUserOauth2AccessTokenResBean;
import com.rainsunset.auth.common.util.wx.api.open.OpenGetUserinfoResBean;
import com.rainsunset.common.util.GsonUtil;
import com.rainsunset.common.util.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;

/**
 * @description: 微信开放平台工具类
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-14
 */
@Slf4j
public class OpenUtil {

    /**
     * 用户授权后通过code获取access_token
     *
     * @param appid  the appid
     * @param secret the secret
     * @param code   the code
     * @return the open get user oauth 2 access token res bean
     * @author : ligangwei / 2019-10-14 12:02:28
     */
    public static OpenGetUserOauth2AccessTokenResBean getUserOauth2AccessToken(String appid, String secret, String code) {
        OpenGetUserOauth2AccessTokenResBean oauth2AccessTokenResBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(OpenApis.P_GET_USER_OAUTH2_ACCESS_TOKEN_APPID, appid);
        params.put(OpenApis.P_GET_USER_OAUTH2_ACCESS_TOKEN_SECRET, secret);
        params.put(OpenApis.P_GET_USER_OAUTH2_ACCESS_TOKEN_CODE, code);
        params.put(OpenApis.P_GET_USER_OAUTH2_ACCESS_TOKEN_GRANT_TYPE, "authorization_code");
        try {
            String response = HttpUtil.httpGetString(OpenApis.API_GET_USER_OAUTH2_ACCESS_TOKEN, null,params);
            log.info(">>> 用户授权后通过code获取access_token[params:{},response:{}]", params, response);
            oauth2AccessTokenResBean = GsonUtil.fromJson(response, new TypeToken<OpenGetUserOauth2AccessTokenResBean>() {
            }.getType());
        } catch (Exception e) {
            log.error(">>> 用户授权后通过code获取access_token异常-http请求异常[Exception:{}]", e);
        }
        return oauth2AccessTokenResBean;
    }

    /**
     * 获取微信用户个人信息
     *
     * @param access_token the access token
     * @param openid      the openid
     * @return the open get userinfo res bean
     * @author : ligangwei / 2019-10-16 11:32:17
     */
    public static OpenGetUserinfoResBean getUserinfo(String access_token, String openid) {
        OpenGetUserinfoResBean openGetUserinfoResBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(OpenApis.P_GET_USERINFO_ACCESS_TOKEN, access_token);
        params.put(OpenApis.P_GET_USERINFO_OPENID, openid);
        try {
            String response = HttpUtil.httpGetString(OpenApis.API_GET_USERINFO, null,params);
            log.info(">>> 获取微信用户个人信息[params:{},response:{}]", params, response);
            openGetUserinfoResBean = GsonUtil.fromJson(response, new TypeToken<OpenGetUserinfoResBean>() {
            }.getType());
        } catch (IOException e) {
            log.error(">>> 获取微信用户个人信息异常-http请求异常[Exception:{}]", e);
        }
        return openGetUserinfoResBean;

    }

}
