package com.hendisantika.excelpoi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liuyan on 2019/1/10.
 */
@Configuration
public class Config {

    @Bean
    public RestTemplate init() {
        return new RestTemplate();
    }
}
