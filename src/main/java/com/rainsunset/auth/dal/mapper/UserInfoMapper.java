package com.rainsunset.auth.dal.mapper;

import com.rainsunset.auth.dal.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Description: 用户信息表(登录信息基础信息) Mapper
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019-09-26 11:16:59
 * @Version : 1.0-SNAPSHOT
 */
@Repository
public interface UserInfoMapper {

    /**
     * 依据条件查找 用户信息表(登录信息基础信息) 列表
     *
     * @param pwd
     * @param securityGestures
     * @param expiryTime
     * @param areaCode
     * @param phone
     * @param email
     * @param cardId
     * @param wchatId
     * @param weiboId
     * @param qqId
     * @param githubId
     * @param googleId
     * @param facebookId
     * @param twitterId
     * @param fingerprintId
     * @param faceId
     * @param trustedDeviceId
     * @param accountStatus
     * @param unlockTime
     * @param safeStatus
     * @param nickName
     * @param avatar
     * @param realName
     * @param sex
     * @param birthday
     * @param createdAt
     * @param createdBy
     * @param updatedAt
     * @param updatedBy
     * @param validStatus
     * @return
     */
    public List<UserInfo> selectUserInfoList(
		    @Param("pwd") String pwd, @Param("securityGestures") String securityGestures,
		    @Param("expiryTime") Date expiryTime, @Param("areaCode") String areaCode,
		    @Param("phone") String phone, @Param("email") String email,
		    @Param("cardId") String cardId, @Param("wchatId") String wchatId,
		    @Param("weiboId") String weiboId, @Param("qqId") String qqId,
		    @Param("githubId") String githubId, @Param("googleId") String googleId,
		    @Param("facebookId") String facebookId, @Param("twitterId") String twitterId,
		    @Param("fingerprintId") String fingerprintId, @Param("faceId") String faceId,
		    @Param("trustedDeviceId") String trustedDeviceId, @Param("accountStatus") String accountStatus,
		    @Param("unlockTime") Date unlockTime, @Param("safeStatus") String safeStatus,
		    @Param("nickName") String nickName, @Param("avatar") String avatar,
		    @Param("realName") String realName, @Param("sex") Integer sex,
		    @Param("birthday") Date birthday, @Param("createdAt") Date createdAt,
		    @Param("createdBy") String createdBy, @Param("updatedAt") Date updatedAt,
		    @Param("updatedBy") String updatedBy, @Param("validStatus") String validStatus
    );

    /**
     * 依据Id查找 用户信息表(登录信息基础信息) 详情
     *
     * @param uid
     * @return
     */
    public UserInfo getUserInfoDetail(@Param("uid") String uid);

    /**
     * 依据用户绑定手机号查找 用户信息表(登录信息基础信息) 详情
     *
     * @param phone
     * @return
     */
    public UserInfo getUserInfoByPhone(@Param("phone") String phone);

    /**
     * 依据用户绑定邮箱查找 用户信息表(登录信息基础信息) 详情
     *
     * @param email
     * @return
     */
    public UserInfo getUserInfoByEmail(@Param("email") String email);

    /**
     * 依据用户绑定身份证查找 用户信息表(登录信息基础信息) 详情
     * @param cardId
     * @return
     */
    public UserInfo getUserInfoByCardId(@Param("cardId") String cardId);

    /**
     * 依据用户绑定微信查找 用户信息表(登录信息基础信息) 详情
     * @param wchatId
     * @return
     */
    public UserInfo getUserInfoByWchatId(@Param("wchatId") String wchatId);

    /**
     * 依据用户绑定微博查找 用户信息表(登录信息基础信息) 详情
     * @param weiboId
     * @return
     */
    public UserInfo getUserInfoByWeiboId(@Param("weiboId") String weiboId);

    /**
     * 依据用户绑定QQ查找 用户信息表(登录信息基础信息) 详情
     * @param qqId
     * @return
     */
    public UserInfo getUserInfoByQqId(@Param("qqId") String qqId);

    /**
     * 依据用户绑定Github查找 用户信息表(登录信息基础信息) 详情
     * @param githubId
     * @return
     */
    public UserInfo getUserInfoByGithubId(@Param("githubId") String githubId);

    /**
     * 全量插入 用户信息表(登录信息基础信息)
     *
     * @param userInfo
     */
    public Integer fullInsertUserInfo(UserInfo userInfo);

    /**
     * 依据主键更新 用户信息表(登录信息基础信息)
     *
     * @param userInfo
     */
    public Integer updateUserInfo(UserInfo userInfo);

    /**
     * 依据主键删除 用户信息表(登录信息基础信息) 记录
     *
     * @param uids
     * @param updatedBy
     */
    public Integer deleteUserInfos(@Param("uids") String[] uids,
                                   @Param("updatedBy") String updatedBy);
}
