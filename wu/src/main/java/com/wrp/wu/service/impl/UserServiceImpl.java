package com.wrp.wu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrp.wu.entity.User;
import com.wrp.wu.mapper.UserMapper;
import com.wrp.wu.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wrp
 * @date 2024年05月26日 9:14
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
}
