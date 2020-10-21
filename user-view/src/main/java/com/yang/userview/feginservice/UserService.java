package com.yang.userview.feginservice;

import com.yang.userview.config.FeignConfig;
import com.yang.userview.entity.User;
import com.yang.userview.feginservice.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yang
 * @since 2020/9/27
 */
@FeignClient(value = "user-service", configuration = FeignConfig.class, fallback = UserServiceImpl.class)
@Primary
public interface UserService {

    @RequestMapping(value = "/findByUserName")
    User findByUserName(@RequestParam("userName") String userName);

}
