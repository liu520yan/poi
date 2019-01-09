package com.hendisantika.excelpoi.controller;

import com.hendisantika.excelpoi.entity.Karyawan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : excel-poi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/02/18
 * Time: 06.28
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/dataKaryawan", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {

        List<Karyawan> karyawans = new LinkedList<>();
        for (int i = 0; i < 60000; i++) {
            karyawans.add(new Karyawan("01", "Saifi Ahmada", "Banjarmain", "AiTi" ,"世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界","世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界","世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界","世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界","世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界","世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界","世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界"));
        }

        // excelView dengan data list karyawans akan diterima oleh resolver exvelView

        ModelAndView modelAndView = new ModelAndView("excelView", "karyawans", karyawans);


        return modelAndView;
    }

}
