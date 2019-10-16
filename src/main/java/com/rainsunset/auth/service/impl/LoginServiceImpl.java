package com.rainsunset.auth.service.impl;

import com.google.gson.reflect.TypeToken;
import com.rainsunset.auth.common.constant.Constants;
import com.rainsunset.auth.common.enums.AccountStatusEnum;
import com.rainsunset.auth.common.enums.ServiceErrorInfoEnum;
import com.rainsunset.auth.config.RedisUtil;
import com.rainsunset.auth.dal.model.UserInfo;
import com.rainsunset.auth.service.LoginService;
import com.rainsunset.auth.service.bo.DecodeTokenBO;
import com.rainsunset.auth.service.bo.EncodeTokenBO;
import com.rainsunset.auth.service.bo.LoginVeriBO;
import com.rainsunset.auth.service.component.LoginFactory;
import com.rainsunset.auth.service.request.*;
import com.rainsunset.auth.service.response.LoginResDTO;
import com.rainsunset.common.bean.GlobalErrorInfoException;
import com.rainsunset.common.bean.ResponseResult;
import com.rainsunset.common.bean.RestResultGenerator;
import com.rainsunset.common.util.Base64Util;
import com.rainsunset.common.util.GsonUtil;
import com.rainsunset.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @description: 用户登录相关服务接口 实现
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-08
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginFactory loginFactory;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${business.token.redis-expire-second}")
    private long tokenRedisExpireSecond;

    @Value("${business.token.max-expire-second}")
    private long tokenMaxExpireSecond;

    @Override
    public ResponseResult<LoginResDTO> login(LoginReqDTO loginReqDTO) {
        String loginType = loginReqDTO.getLoginType();
        String loginName = loginReqDTO.getLoginName();
        String loginKey = loginReqDTO.getLoginKey();
        // 校验登录名 登录Key
        LoginVeriBO loginVeriBO = loginFactory.veriLoginName(loginType, loginName, loginKey);
        UserInfo userInfo = loginVeriBO.getUserInfo();
        boolean pass = loginVeriBO.isPass();
        // TODO 异步-存储登录记录及登录结果
        // TODO 异步-检查用户当前户口安全状态
        if (null == userInfo) {
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_412000);
        }
        String accountStatus = userInfo.getAccountStatus();
        String uid = userInfo.getUid();
        // 账户状态 - 暂时锁定
        if (AccountStatusEnum.PART_LOCK.getCode().equals(accountStatus)) {
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_412001);
        }
        // 账户状态 - 锁死
        if (AccountStatusEnum.LOCK_OUT.getCode().equals(accountStatus)) {
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_412002);
        }
        // 密码验证不通过
        if (!loginVeriBO.isPass()) {
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_412000);
        }
        // 账户状态 - 过期失效
        if (AccountStatusEnum.OVER_TIME.getCode().equals(accountStatus)) {
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_412003);
        }
        // 账户状态 - 已注销
        if (AccountStatusEnum.WIRTE_OFF.getCode().equals(accountStatus)) {
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_412004);
        }
        // 登陆成功则失效相同系统类型的Token
        String systemType = loginReqDTO.getSystemType();
        String userSystenTypeRedisKeyFooter = generateUserSystenTypeRedisKeyFooter(uid, systemType);
        redisUtil.removePattern(StringUtil.conlitionStr(userSystenTypeRedisKeyFooter, "*"));
        LoginResDTO loginResDTO;
        if (AccountStatusEnum.PWD_INIT.getCode().equals(accountStatus)) {
            // 密码为初始化状态的用户不生成token
            loginResDTO = userInfo2loginResDTO(userInfo, "");
        } else {
            EncodeTokenBO encodeTokenBO = encodeToken(uid, systemType);
            loginResDTO = userInfo2loginResDTO(userInfo, encodeTokenBO.getToken());
            // 新Token放入Redis
            String redisKey = encodeTokenBO.getRedisKey();
            redisUtil.set(redisKey, GsonUtil.toJsonFilterNullField(loginResDTO));
            redisUtil.expire(redisKey,tokenRedisExpireSecond);
        }
        return RestResultGenerator.genResult(loginResDTO);
    }

    @Override
    public ResponseResult<Boolean> veriFeature(VeriFeatureReqDTO veriFeatureReqDTO) {
        return null;
    }

    @Override
    public ResponseResult<LoginResDTO> veriToken(VeriTokenReqDTO veriTokenReqDTO) {
        String token = veriTokenReqDTO.getToken();
        DecodeTokenBO decodeTokenBO = decodeToken(token);
        if (null == decodeTokenBO) {
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_412005);
        }
        String redisKey = decodeTokenBO.getRedisKey();
        String userInfoJsonStr = redisUtil.get(redisKey);
        if (StringUtils.isEmpty(userInfoJsonStr)) {
            throw new GlobalErrorInfoException(ServiceErrorInfoEnum.AUTH_412006);
        }
        long time = decodeTokenBO.getLoginTime().getTime();
        // token未超过最大有效时长则更新token失效时间
        if (tokenMaxExpireSecond > (System.currentTimeMillis() - time)) {
            redisUtil.expire(redisKey, tokenRedisExpireSecond);
        }
        LoginResDTO loginResDTO = GsonUtil.fromJson(userInfoJsonStr, new TypeToken<LoginResDTO>() {
        }.getType());
        return RestResultGenerator.genResult(loginResDTO);
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

    /**
     * UserInfo -> LoginResDTO
     *
     * @param userInfo the user info
     * @param token    the token
     * @return the login res dto
     * @author : ligangwei / 2019-10-10 9:52:14
     */
    private LoginResDTO userInfo2loginResDTO(UserInfo userInfo, String token) {
        return new LoginResDTO(token, userInfo.getUid(), userInfo.getExpiryTime(),
                userInfo.getAreaCode(), userInfo.getPhone(), userInfo.getEmail(),
                userInfo.getCardId(), userInfo.getWchatId(), userInfo.getWeiboId(),
                userInfo.getQqId(), userInfo.getGithubId(), userInfo.getGoogleId(),
                userInfo.getFacebookId(), userInfo.getTwitterId(), userInfo.getAccountStatus(),
                userInfo.getSafeStatus(), userInfo.getNickName(), userInfo.getAvatar(),
                userInfo.getRealName(), userInfo.getSex(), userInfo.getBirthday());
    }

    /**
     * 生成token
     *
     * @param uid        the uid
     * @param systemType the system type
     * @return the string
     * @author : ligangwei / 2019-10-10 10:02:18
     */
    private EncodeTokenBO encodeToken(String uid, String systemType) {
        String currentMillen = String.valueOf(System.currentTimeMillis());
        String serSystenTypeRedisKeyFooter = generateUserSystenTypeRedisKeyFooter(uid, systemType);
        String redisKey = StringUtil.conlitionStr(serSystenTypeRedisKeyFooter, "_", currentMillen);
        String token = Base64Util.encode(redisKey);
        String randomStr = String.valueOf((char) (Math.random() * 26 + 'a'));
        token = StringUtil.conlitionStr(randomStr, token);
        return new EncodeTokenBO(redisKey, token);
    }

    /**
     * 生成用户及登陆平台对应的redis key 的前部分
     *
     * @param uid        the uid
     * @param systemType the system type
     * @return string
     * @author : ligangwei / 2019-10-10 11:20:45
     */
    private String generateUserSystenTypeRedisKeyFooter(String uid, String systemType) {
        String userRedisKeyFooter = generateUserRedisKeyFooter(uid);
        return StringUtil.conlitionStr(userRedisKeyFooter, "_", systemType);
    }

    /**
     * 生成用户对应的redis key 的前部分
     *
     * @param uid the uid
     * @return the string
     * @author : ligangwei / 2019-10-10 11:20:48
     */
    private String generateUserRedisKeyFooter(String uid) {
        return StringUtil.conlitionStr(Constants.REDIS_TOKEN_HEADER, "_", uid);
    }


    /**
     * 解析Token信息
     *
     * @param token the token
     * @return the decode token bo
     * @author : ligangwei / 2019-10-10 11:36:03
     */
    private DecodeTokenBO decodeToken(String token) {
        token = token.substring(1);
        String redisKey = Base64Util.decode(token);
        String[] keyInfo = redisKey.split("_");
        // token不合法
        if (keyInfo.length < 4 || null == StringUtil.str2Long(keyInfo[3])) {
            return null;
        }
        Long loginTimeMillen = StringUtil.str2Long(keyInfo[3]);
        Date loginTime = new Date(loginTimeMillen);
        String uid = keyInfo[1];
        String systemType = keyInfo[2];
        return new DecodeTokenBO(redisKey, uid, systemType, loginTime);
    }

}
