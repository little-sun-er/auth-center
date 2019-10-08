package com.rainsunset.auth.service;

import com.rainsunset.auth.service.request.*;
import com.rainsunset.common.bean.ResponseResult;

/**
 * @description: 用户登录相关服务接口
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-26
 */
public interface LoginService {

    /**
     * 登录
     *
     * 登录名密码登录: PHONE_PWD:手机号密码;EMAIL_PWD:邮箱密码;CARD_PWD:身份证号密码;
     * 验证登录(注册):PHONE_CODE:手机号验证码;EMAIL_CODE:邮箱验证码;
     * 第三方授权登录(注册): WCHAT:微信;WEIBO:微博;QQ:QQ;GITHUB:Github;GOOGLE:Google;FACEBOOK:Facebook;TWITTER:Twitter;
     * @param loginReqDTO
     * @return
     */
    public ResponseResult<LoginResDTO> login(LoginResDTO loginReqDTO);

    /**
     * 用户特征识别
     *
     * 特征识别登录(注册): FINGERPRINT:指纹识别;FACE:面部识别;CARD:身份证识别;
     * 设备授权登录: TRUSTED_DEVICE:信任设备;
     * @param veriFeatureReqDTO
     * @return
     */
    public ResponseResult<Boolean> veriFeature(VeriFeatureReqDTO veriFeatureReqDTO);

    /**
     * 验证token
     *
     * @param veriTokenReqDTO
     * @return
     */
    public ResponseResult<LoginResDTO> veriToken(VeriTokenReqDTO veriTokenReqDTO);

    /**
     * 发送手机验证码
     *
     * @param sendPhoneCodeReqDTO
     * @return
     */
    public ResponseResult<Boolean> sendPhoneCode(SendPhoneCodeReqDTO sendPhoneCodeReqDTO);

    /**
     * 发送邮箱验证码
     *
     * @param sendEmailCodeReqDTO
     * @return
     */
    public ResponseResult<Boolean> sendEmailCode(SendEmailCodeReqDTO sendEmailCodeReqDTO);

    /**
     * 初始化密码
     *
     * 组管理员初始化成员密码并通知成员
     * @param initPwdReqDTO
     * @return
     */
    public ResponseResult<Boolean> initPwd(InitPwdReqDTO initPwdReqDTO);

    /**
     * 修改密码
     *
     * 旧密码验证修改/手机号验证码验证修改/邮箱验证码验证修改
     * @param changePwdReqDTO
     * @return
     */
    public ResponseResult<Boolean> changePwd(ChangePwdReqDTO changePwdReqDTO);
}
