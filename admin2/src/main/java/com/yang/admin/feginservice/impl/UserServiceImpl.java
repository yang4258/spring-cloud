package com.yang.admin.feginservice.impl;

import com.yang.admin.entity.User;
import com.yang.admin.feginservice.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {


    @Override
    public User findByUserName(String userName) {
        User user = new User();
        return user;
    }
}
