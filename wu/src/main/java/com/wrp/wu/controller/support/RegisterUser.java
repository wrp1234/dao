package com.wrp.wu.controller.support;

import com.wrp.wu.enums.SexEnum;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author wrp
 * @date 2024年05月26日 9:21
 * @description
 */
@Data
public class RegisterUser {
    private String username;
    private String password;
    private String nickName;
    private String phone;
    private String email;
    private String qq;
    private String openid;
    private String photo;
    private SexEnum sex;
    private LocalDate birthday;
    private String address;
}
