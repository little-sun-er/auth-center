package com.rainsunset.auth.service.request;

import com.rainsunset.common.bean.BaseRequest;
import lombok.Data;
import lombok.ToString;

/**
 * @description: 发送邮箱验证码请求体
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-09-27
 */
@Data
@ToString(callSuper = true)
public class SendEmailCodeReqDTO extends BaseRequest {
}
