package com.rainsunset.auth.controller;

import com.rainsunset.auth.service.LoginService;
import com.rainsunset.auth.service.request.*;
import com.rainsunset.auth.service.response.LoginResDTO;
import com.rainsunset.common.bean.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用户鉴权API
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-08
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param loginReqDTO
     * @return
     */
    public ResponseResult<LoginResDTO> login(@RequestBody LoginReqDTO loginReqDTO) {
        ResponseResult<LoginResDTO> res = loginService.login(loginReqDTO);
        return res;
    }

    /**
     * 用户特征识别
     *
     * 特征识别登录(注册): FINGERPRINT:指纹识别;FACE:面部识别;CARD:身份证识别;
     * 设备授权登录: TRUSTED_DEVICE:信任设备;
     * @param veriFeatureReqDTO
     * @return
     */
    public ResponseResult<Boolean> veriFeature(@RequestBody VeriFeatureReqDTO veriFeatureReqDTO) {
        ResponseResult<Boolean> res = loginService.veriFeature(veriFeatureReqDTO);
        return res;
    }

    /**
     * 验证token
     *
     * @param veriTokenReqDTO
     * @return
     */
    public ResponseResult<LoginResDTO> veriToken(@RequestBody VeriTokenReqDTO veriTokenReqDTO) {
        ResponseResult<LoginResDTO> res = loginService.veriToken(veriTokenReqDTO);
        return res;
    }

    /**
     * 发送手机验证码
     *
     * @param sendPhoneCodeReqDTO
     * @return
     */
    public ResponseResult<Boolean> sendPhoneCode(@RequestBody SendPhoneCodeReqDTO sendPhoneCodeReqDTO) {
        ResponseResult<Boolean> res = loginService.sendPhoneCode(sendPhoneCodeReqDTO);
        return res;
    }

    /**
     * 发送邮箱验证码
     *
     * @param sendEmailCodeReqDTO
     * @return
     */
    public ResponseResult<Boolean> sendEmailCode(@RequestBody SendEmailCodeReqDTO sendEmailCodeReqDTO) {
        ResponseResult<Boolean> res = loginService.sendEmailCode(sendEmailCodeReqDTO);
        return res;
    }

    /**
     * 初始化密码
     *
     * @param initPwdReqDTO
     * @return
     */
    public ResponseResult<Boolean> initPwd(@RequestBody InitPwdReqDTO initPwdReqDTO) {
        ResponseResult<Boolean> res = loginService.initPwd(initPwdReqDTO);
        return res;
    }

    /**
     * 修改密码
     *
     * @param changePwdReqDTO
     * @return
     */
    public ResponseResult<Boolean> changePwd(@RequestBody ChangePwdReqDTO changePwdReqDTO) {
        ResponseResult<Boolean> res = loginService.changePwd(changePwdReqDTO);
        return res;
    }
}
