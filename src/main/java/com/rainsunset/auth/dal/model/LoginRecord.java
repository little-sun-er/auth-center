package com.rainsunset.auth.dal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 登录记录表 Model
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019-09-26 11:16:58
 * @Version : 1.0-SNAPSHOT
 */
@Data
@ApiModel(description = "登录记录表")
public class LoginRecord {

    @ApiModelProperty(value = "登录记录表主键")
    private Integer id;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "登录口令")
    private String loginKey;

    @ApiModelProperty(value = "登录类型")
    private String loginType;

    @ApiModelProperty(value = "系统类型")
    private String systemType;

    @ApiModelProperty(value = "系统版本")
    private String systemVersion;

    @ApiModelProperty(value = "验证结果")
    private String accountStatus;

    @ApiModelProperty(value = "账户安全状态")
    private String safeStatus;

    @ApiModelProperty(value = "请求IP")
    private String ip;

    @ApiModelProperty(value = "SIM卡串号")
    private String imsi;

    @ApiModelProperty(value = "手机串号")
    private String imei;

    @ApiModelProperty(value = "经纬度信息")
    private String locInfo;

    @ApiModelProperty(value = "设备标识")
    private String deviceId;

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



