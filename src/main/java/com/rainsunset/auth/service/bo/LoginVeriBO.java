package com.rainsunset.auth.service.bo;

import com.rainsunset.auth.dal.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 登陆验证BO
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019-10-09
 */
@Data
@AllArgsConstructor
public class LoginVeriBO {

    /** 用户信息 */
    private UserInfo userInfo;

    /** 是否验证通过 */
    private boolean pass;
}
