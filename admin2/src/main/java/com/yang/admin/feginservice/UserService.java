package com.yang.admin.feginservice;

import com.yang.admin.config.FeignConfig;
import com.yang.admin.entity.User;
import com.yang.admin.feginservice.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yang
 * @since 2020/9/27
 */
@FeignClient(value = "user-service", configuration = FeignConfig.class, fallback = UserServiceImpl.class)
public interface UserService {

    @RequestMapping(value = "/user/findByUserName")
    User findByUserName(@RequestParam("userName") String userName);

}
