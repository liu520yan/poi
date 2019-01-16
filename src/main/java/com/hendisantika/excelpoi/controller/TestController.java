package com.hendisantika.excelpoi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyan on 2019/1/16.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String index() {
        return "2323232323";
    }

}
