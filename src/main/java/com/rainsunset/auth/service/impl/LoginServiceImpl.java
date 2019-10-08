package com.rainsunset.auth.service.impl;

import com.rainsunset.auth.service.LoginService;
import com.rainsunset.auth.service.request.*;
import com.rainsunset.auth.service.response.LoginResDTO;
import com.rainsunset.common.bean.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description: 用户登录相关服务接口 实现
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-08
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public ResponseResult<LoginResDTO> login(LoginReqDTO loginReqDTO) {
        // 失效相同系统类型的Token
        // 校验登录名 登录Key
        // 异步存储登录记录，结果
        // 返回登录结果
        return null;
    }

    @Override
    public ResponseResult<Boolean> veriFeature(VeriFeatureReqDTO veriFeatureReqDTO) {
        return null;
    }

    @Override
    public ResponseResult<LoginResDTO> veriToken(VeriTokenReqDTO veriTokenReqDTO) {
        return null;
    }

    @Override
    public ResponseResult<Boolean> sendPhoneCode(SendPhoneCodeReqDTO sendPhoneCodeReqDTO) {
        return null;
    }

    @Override
    public ResponseResult<Boolean> sendEmailCode(SendEmailCodeReqDTO sendEmailCodeReqDTO) {
        return null;
    }

    @Override
    public ResponseResult<Boolean> initPwd(InitPwdReqDTO initPwdReqDTO) {
        return null;
    }

    @Override
    public ResponseResult<Boolean> changePwd(ChangePwdReqDTO changePwdReqDTO) {
        return null;
    }
}
