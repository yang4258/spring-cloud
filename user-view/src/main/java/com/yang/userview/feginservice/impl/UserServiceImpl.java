package com.yang.userview.feginservice.impl;

import com.yang.userview.entity.User;
import com.yang.userview.feginservice.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {


    @Override
    public User findByUserName(String userName) {
        User user = new User();
        return user;
    }
}
