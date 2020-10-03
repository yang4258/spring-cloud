package com.yang.admin.controller;

import com.yang.admin.entity.User;
import com.yang.admin.feginservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @RequestMapping("/asd/asd")
    public User findByUserName(String userName) {
        System.out.println(userName);
        return userService.findByUserName(userName);
    }

}
