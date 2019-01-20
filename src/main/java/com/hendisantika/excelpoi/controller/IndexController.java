package com.hendisantika.excelpoi.controller;

import com.hendisantika.excelpoi.entity.BarCodeForm;
import com.hendisantika.excelpoi.entity.Karyawan;
import com.hendisantika.excelpoi.util.BarCodePoiUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

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
@Slf4j
public class IndexController {

    private ThreadPoolExecutor service = new ThreadPoolExecutor(10, 20, 2L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/dataKaryawan", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {

        List<Karyawan> karyawans = new LinkedList<>();
        for (int i = 0; i < 6000; i++) {
            karyawans.add(new Karyawan("01", "Saifi Ahmada", "Banjarmain", "AiTi", "世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界", "世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界", "世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界", "世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界", "世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界", "世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界", "世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界世界"));
        }

        // excelView dengan data list karyawans akan diterima oleh resolver exvelView

        ModelAndView modelAndView = new ModelAndView("excelView", "karyawans", karyawans);
        return modelAndView;
    }


    @RequestMapping(value = "/count/{count}", method = RequestMethod.GET)
    public void exportSelectResult(HttpServletResponse response, @PathVariable(value = "count") int count) throws ExecutionException, InterruptedException {


        long startTime = System.currentTimeMillis();
        List<BarCodeForm> barCodeForms = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            barCodeForms.add(new BarCodeForm("sdsdwewe", "sdsdwewe", "sdsdwewe", "sdsdwewe", "sdsdwewe", "sdsdwewe", "sdsdwewe", "sdsdwewe", "sdsdwewe", "sdsdwewe"));
        }


        Vector<BarCodeForm> lists = new Vector<>();

        for (BarCodeForm form : barCodeForms) {
            service.submit(
                    () -> {
                        String forObject = "1";
                        form.setCreateByName(forObject);
                        lists.add(form);
                    }
            );
        }

        while (service.getActiveCount() != 0 || service.getQueue().size() != 0) {
            System.out.println("还有多少条数据没有搞定：" + service.getQueue().size());
            TimeUnit.SECONDS.sleep(1);
        }

        // 定义每5w条记录放在一个sheet
        int everySheet = 500000;
        int cycle = (int) Math.ceil(count / everySheet);

        String[] tableHeader = {"条形码编号", "商品名称", "备注", "容量/体积", "单位", "产地", "创建时间", "创建人", "修改时间", "修改人"};
        // 构造一个空的工作簿并指定行访问窗口。
        SXSSFWorkbook wb = new SXSSFWorkbook(1);
        Sheet sh = null;
        Row row = null;
        Cell cell = null;
        for (int i = 0; i <= cycle; i++) {
            List list;
            if (count - i * everySheet <= everySheet) {
                System.out.println("1   起：" + i * everySheet + "         终" + (count - 1));
                list = lists.subList(i * everySheet, count - 1);
                sh = wb.createSheet(String.valueOf(i + 1));
                BarCodePoiUtil.setExcelContent(list, tableHeader, row, sh, cell);
                break;
            } else {
                System.out.println("2     起：" + i * everySheet + "         终" + (i * everySheet + everySheet));
                list = lists.subList(i * everySheet, i * everySheet + everySheet);
                sh = wb.createSheet(String.valueOf(i + 1));
                BarCodePoiUtil.setExcelContent(list, tableHeader, row, sh, cell);
            }

        }

        BufferedOutputStream out = null;
        String filename = "BarCodeDatas.xlsx";
        try {
            // 设置文件名
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            out = new BufferedOutputStream(response.getOutputStream());
            wb.write(out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            new RuntimeException("导出:条形码查询后的列表失败");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                // 处理在磁盘上备份此工作簿的临时文件
                wb.dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("【 " + this.getClass().getName() + " 】【  " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  】 导出:条形码" + count + "条，用时:" + (endTime - startTime) / 1000 + " s");
    }


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8081/user", String.class);
        System.out.println(forObject);

    }


    public void shotdown() {
        service.shutdownNow();
    }
}
