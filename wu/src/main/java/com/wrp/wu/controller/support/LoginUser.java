package com.wrp.wu.controller.support;

import lombok.Data;

/**
 * @author wrp
 * @date 2024年05月26日 9:16
 * @description
 */
@Data
public class LoginUser {
    private String username;
    private String password;
    // 验证码id
    private String uuid;
    // 验证码
    private String code;
}
