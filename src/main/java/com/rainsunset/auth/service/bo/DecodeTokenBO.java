package com.rainsunset.auth.service.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @description: 解析Token包含信息
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-10
 */
@Data
@AllArgsConstructor
public class DecodeTokenBO {
    /** token对应redisKey */
    private String redisKey;

    /** uid */
    private String uid;

    /** 系统类型 */
    private String systemType;

    /** 登录时间 */
    private Date loginTime;
}
