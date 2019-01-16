package com.hendisantika.excelpoi.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyan on 2019/1/16.
 */
@RestController
public class TestController {

    @RequestMapping("/test/{int}")
    public int index(@PathVariable("int") int inrt) {
        return inrt;
    }

}
