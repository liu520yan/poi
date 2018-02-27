package com.hendisantika.excelpoi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

/**
 * Created by IntelliJ IDEA.
 * Project : excel-poi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/02/18
 * Time: 06.25
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ResourceBundleViewResolver viewResolver() {
        ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
        resolver.setOrder(1);
        resolver.setBasename("views");
        return resolver;
    }
}