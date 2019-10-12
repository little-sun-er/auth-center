package com.rainsunset.auth.service.request;

import com.rainsunset.common.bean.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @description: Token校验请求体
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-27
 */
@Data
@ToString(callSuper = true)
public class VeriTokenReqDTO extends BaseRequest {

    @ApiModelProperty(value = "用户Token")
    @NotBlank(message = "用户Token不能为空")
    private String Token;
}
