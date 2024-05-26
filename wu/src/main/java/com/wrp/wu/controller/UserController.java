package com.wrp.wu.controller;

import com.wrp.wu.common.result.R;
import com.wrp.wu.common.result.RUtils;
import com.wrp.wu.controller.support.LoginPhoneUser;
import com.wrp.wu.controller.support.LoginUser;
import com.wrp.wu.controller.support.RegisterUser;
import com.wrp.wu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wrp
 * @date 2024年05月26日 9:15
 * @description
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R loginByUsernameAndPassword(@RequestBody LoginUser loginUser) {
        return RUtils.success();
    }


    @PostMapping("/login/phone")
    public R loginByPhoneAndCode(@RequestBody LoginPhoneUser loginPhoneUser) {
        return RUtils.success();
    }

    @PostMapping("register")
    public R register(@RequestBody RegisterUser registerUser) {
        return RUtils.success();
    }

    @PostMapping("logout")
    public R logout() {
        return RUtils.success();
    }
}
