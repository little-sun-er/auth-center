package com.rainsunset.auth.dal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 用户信息表(登录信息基础信息) Model
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019-09-26 11:16:59
 * @Version : 1.0-SNAPSHOT
 */
@Data
@ApiModel(description = "用户信息表(登录信息基础信息)")
public class UserInfo {

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "安全手势")
    private String securityGestures;

    @ApiModelProperty(value = "有效期")
    private Date expiryTime;

    @ApiModelProperty(value = "手机区号")
    private String areaCode;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "身份证号")
    private String cardId;

    @ApiModelProperty(value = "微信Id")
    private String wchatId;

    @ApiModelProperty(value = "微博id")
    private String weiboId;

    @ApiModelProperty(value = "QQId")
    private String qqId;

    @ApiModelProperty(value = "GithubId")
    private String githubId;

    @ApiModelProperty(value = "GoogleId")
    private String googleId;

    @ApiModelProperty(value = "FacebookId")
    private String facebookId;

    @ApiModelProperty(value = "TwitterId")
    private String twitterId;

    @ApiModelProperty(value = "指纹id")
    private String fingerprintId;

    @ApiModelProperty(value = "FaceId")
    private String faceId;

    @ApiModelProperty(value = "信任设备id")
    private String trustedDeviceId;

    @ApiModelProperty(value = "账户状态")
    private String accountStatus;

    @ApiModelProperty(value = "账户解锁时间")
    private Date unlockTime;

    @ApiModelProperty(value = "账户安全状态")
    private String safeStatus;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "创建时间")
    private Date createdAt;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "更新时间")
    private Date updatedAt;

    @ApiModelProperty(value = "更新人")
    private String updatedBy;

    @ApiModelProperty(value = "有效状态(VALID:有效;INVALID:无效)")
    private String validStatus;

}



