package com.yang.orderview.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    // 重试间隔100毫秒 最大重试时间1秒， 重试次数5次
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L), 5);
    }


}
