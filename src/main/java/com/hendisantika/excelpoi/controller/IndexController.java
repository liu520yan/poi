package com.hendisantika.excelpoi.controller;

import com.hendisantika.excelpoi.entity.Karyawan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

        List<Karyawan> karyawans = new ArrayList<Karyawan>();
        karyawans.add(new Karyawan("01", "Saifi Ahmada", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("02", "Iyar Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("03", "Utar Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("04", "Wandi Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("05", "Yadi Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("06", "Dimas Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("07", "Firman Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("08", "Rizka Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("09", "Arya Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("10", "Dion Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("11", "Philip Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("12", "Ema Sudibyo", "Banjarmain", "AiTi"));
        karyawans.add(new Karyawan("13", "Uzumaki Naruto", "Konohagakure", "AiTi"));

        // excelView dengan data list karyawans akan diterima oleh resolver exvelView
        return new ModelAndView("excelView", "karyawans", karyawans);
    }

}
