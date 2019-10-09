package com.rainsunset.auth.service.component;

import com.rainsunset.auth.common.enums.LoginTypeEnum;
import com.rainsunset.auth.dal.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
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

    /**
     * Veri login name user info.
     *
     * @param loginType the login type
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    public UserInfo veriLoginName(String loginType, String loginName, String loginKey) {
        UserInfo userInfo = new UserInfo();
        if (LoginTypeEnum.PHONE_PWD.getCode().equals(loginType)) {
            userInfo = veriPhonePwdLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.EMAIL_PWD.getCode().equals(loginType)) {
            userInfo = veriEmailPwdLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.CARD_PWD.getCode().equals(loginType)) {
            userInfo = veriCardPwdLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.PHONE_CODE.getCode().equals(loginType)) {
            userInfo = veriPhoneCodeLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.EMAIL_CODE.getCode().equals(loginType)) {
            userInfo = veriEmailCodeLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.WCHAT.getCode().equals(loginType)) {
            userInfo = veriWchatLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.WEIBO.getCode().equals(loginType)) {
            userInfo = veriWeiboLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.QQ.getCode().equals(loginType)) {
            userInfo = veriQqLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.GITHUB.getCode().equals(loginType)) {
            userInfo = veriGithubLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.GOOGLE.getCode().equals(loginType)) {
            userInfo = veriGoogleLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.FACEBOOK.getCode().equals(loginType)) {
            userInfo = veriFacebookLogin(loginName,loginKey);
            return userInfo;
        }
        if (LoginTypeEnum.TWITTER.getCode().equals(loginType)) {
            userInfo = veriTwitterLogin(loginName,loginKey);
            return userInfo;
        }
        return null;
    }

    /**
     * Veri phone pwd login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriPhonePwdLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri email pwd login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriEmailPwdLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri card pwd login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriCardPwdLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri phone code login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriPhoneCodeLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri email code login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriEmailCodeLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri wchat login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriWchatLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri weibo login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriWeiboLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri qq login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriQqLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri github login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriGithubLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri google login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriGoogleLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri facebook login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriFacebookLogin(String loginName, String loginKey) {
        return null;
    }

    /**
     * Veri twitter login user info.
     *
     * @param loginName the login name
     * @param loginKey  the login key
     * @return the user info
     * @author : ligangwei / 2019-10-8 8:56:25
     */
    private UserInfo veriTwitterLogin(String loginName, String loginKey) {
        return null;
    }

}
