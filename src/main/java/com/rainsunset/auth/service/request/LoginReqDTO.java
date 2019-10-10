package com.rainsunset.auth.service.request;

import com.rainsunset.common.bean.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @description: 登录请求体
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-27
 */
@Data
@ToString(callSuper = true)
public class LoginReqDTO extends BaseRequest {

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

}
