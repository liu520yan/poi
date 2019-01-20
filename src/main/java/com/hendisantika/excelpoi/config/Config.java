package com.hendisantika.excelpoi.config;

import com.hendisantika.excelpoi.aop.LogAdapter;
import com.hendisantika.excelpoi.classloader.LogClassLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by liuyan on 2019/1/10.
 */
@Configuration
public class Config {

    @Bean
    public LogAdapter adpt() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        LogClassLoader classLoader = new LogClassLoader();
        Class<?> aClass = classLoader.loadClass("com.hendisantika.excelpoi.aop.LogAdapter");
        return (LogAdapter) aClass.newInstance();
    }

//    @Bean
//    public LogAdapter adpt() throws NoSuchFieldException, IllegalAccessException {
//        System.out.println(LogAdapter.ex);
//        Field field = LogAdapter.class.getField("ex");
//        //将字段的访问权限设为true：即去除private修饰符的影响
//        field.setAccessible(true);
//        /*去除final修饰符的影响，将字段设为可修改的*/
//        Field modifiersField = Field.class.getDeclaredField("modifiers");
//        modifiersField.setAccessible(true);
//        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
//        //把字段值设为200
//        field.set(null, "execution(public * com.hendisantika.excelpoi.cooo.*(..))");
//        System.out.println(LogAdapter.ex);
//
//        return null;
//    }
}
