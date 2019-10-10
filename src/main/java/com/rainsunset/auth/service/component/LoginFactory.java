package com.rainsunset.auth.service.component;

import com.rainsunset.auth.common.constant.Constants;
import com.rainsunset.auth.common.enums.LoginTypeEnum;
import com.rainsunset.auth.dal.mapper.UserInfoMapper;
import com.rainsunset.auth.dal.model.UserInfo;
import com.rainsunset.auth.service.bo.LoginVeriBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version : 1.0
 * @description: 登陆验证工厂
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019 -10-08
 */
@Slf4j
@Component
public class LoginFactory {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 登录校验
     *
     * @param loginType the login type
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    public LoginVeriBO veriLoginName(String loginType, String loginName, String loginKey) {
        if (LoginTypeEnum.PHONE_PWD.getCode().equals(loginType)) {
            return veriPhonePwdLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.EMAIL_PWD.getCode().equals(loginType)) {
            return veriEmailPwdLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.CARD_PWD.getCode().equals(loginType)) {
            return veriCardPwdLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.PHONE_CODE.getCode().equals(loginType)) {
            return veriPhoneCodeLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.EMAIL_CODE.getCode().equals(loginType)) {
            return veriEmailCodeLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.WCHAT.getCode().equals(loginType)) {
            return veriWchatLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.WEIBO.getCode().equals(loginType)) {
            return veriWeiboLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.QQ.getCode().equals(loginType)) {
            return veriQqLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.GITHUB.getCode().equals(loginType)) {
            return veriGithubLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.GOOGLE.getCode().equals(loginType)) {
            return veriGoogleLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.FACEBOOK.getCode().equals(loginType)) {
            return veriFacebookLogin(loginName,loginKey);
        }
        if (LoginTypeEnum.TWITTER.getCode().equals(loginType)) {
            return veriTwitterLogin(loginName,loginKey);
        }
        return new LoginVeriBO(null, false);
    }

    /**
     * 手机号密码登录校验
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriPhonePwdLogin(String loginName, String loginKey) {
        UserInfo userInfo = userInfoMapper.getUserInfoByPhone(loginName);
        return veriPwd(userInfo, loginKey);
    }

    /**
     * 邮箱密码登录校验
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriEmailPwdLogin(String loginName, String loginKey) {
        UserInfo userInfo = userInfoMapper.getUserInfoByEmail(loginName);
        return veriPwd(userInfo, loginKey);
    }

    /**
     * 身份证号密码登录校验
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriCardPwdLogin(String loginName, String loginKey) {
        UserInfo userInfo = userInfoMapper.getUserInfoByCardId(loginName);
        return veriPwd(userInfo, loginKey);
    }

    /**
     * 校验登陆密码
     *
     * @param userInfo the user info
     * @param loginKey the login key
     * @return the login veri bo
     * @author : ligangwei / 2019-10-10 9:13:33
     */
    private LoginVeriBO veriPwd(UserInfo userInfo,String loginKey) {
        if (null == userInfo) {
            return new LoginVeriBO(null, false);
        }
        String pwdVeri = Constants.generatePwd(loginKey, userInfo.getUid());
        if (pwdVeri.equals(userInfo.getPwd())) {
            return new LoginVeriBO(userInfo, true);
        } else {
            return new LoginVeriBO(userInfo, false);
        }
    }

    /**
     * 手机号验证码登录校验
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriPhoneCodeLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

    /**
     * 邮箱验证码登录校验
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriEmailCodeLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

    /**
     * 微信授权登录
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriWchatLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

    /**
     * 微博授权登录
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriWeiboLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

    /**
     * QQ授权登录
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriQqLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

    /**
     * Github授权登录
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriGithubLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

    /**
     * Veri google login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriGoogleLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

    /**
     * Veri facebook login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriFacebookLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

    /**
     * Veri twitter login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private LoginVeriBO veriTwitterLogin(String loginName, String loginKey) {
        return new LoginVeriBO(null, false);
    }

}
