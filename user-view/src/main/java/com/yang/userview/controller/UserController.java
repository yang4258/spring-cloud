package com.yang.userview.controller;

import com.yang.userview.entity.User;
import com.yang.userview.feginservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @since 2020/9/24
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/findByUserName")
    public User findByUserName(String userName) {
        System.out.println(userName);
        return userService.findByUserName(userName);
    }

}
