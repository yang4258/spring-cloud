package com.yang.userservice.controller;

import com.yang.userservice.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @since 2020/9/24
 */
@RestController
public class UserController {

    @RequestMapping("/user/findByUserName")
    public User findByUserName(String userName) {
        System.out.println("service: " + userName);
        User user = new User();
        user.setName(userName);
        user.setAge("20");
        return user;
    }

}
