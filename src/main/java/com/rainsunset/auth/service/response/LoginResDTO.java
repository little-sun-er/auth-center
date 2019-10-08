package com.rainsunset.auth.service.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @description: 登录返回体
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-27
 */
public class LoginResDTO {
    @ApiModelProperty(value = "用户Token")
    private String Token;

    @ApiModelProperty(value = "用户id")
    private String uid;

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

}
