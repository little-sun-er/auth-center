package com.rainsunset.auth.service.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 生成Token对象
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-10
 */
@Data
@AllArgsConstructor
public class EncodeTokenBO {

    /** redis 持有Key */
    private String redisKey;

    /** 前端持有token */
    private String token;

}
