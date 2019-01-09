package com.hendisantika.excelpoi.config;

import com.hendisantika.excelpoi.entity.Karyawan;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : excel-poi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/02/18
 * Time: 06.26
 * To change this template use File | Settings | File Templates.
 */

public class ExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) {
        // ambil data model yang dikirim oleh Spring Container
        long t1 = System.currentTimeMillis();
        // buat nama file
        response.setHeader("Content-Disposition", "attachment; filename=\"karyawan-list.xls\"");

        List<Karyawan> karyawans = (List<Karyawan>) model.get("karyawans");

        // buat sheet baru
        HSSFSheet sheet = workbook.createSheet("Karyawan List");
        sheet.setDefaultColumnWidth(30);

        // buat cell header
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // buat row untuk header
        HSSFRow header = sheet.createRow(0);

        header.createCell(0).setCellValue("Id");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Nama");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Alamat");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Bagian");
        header.getCell(3).setCellStyle(style);
        header.createCell(3).setCellValue("Bagian1");
        header.getCell(3).setCellStyle(style);
        header.createCell(3).setCellValue("Bagian2");
        header.getCell(3).setCellStyle(style);
        header.createCell(3).setCellValue("Bagian3");
        header.getCell(3).setCellStyle(style);
        header.createCell(3).setCellValue("Bagian4");
        header.getCell(3).setCellStyle(style);
        header.createCell(3).setCellValue("Bagian5");
        header.getCell(3).setCellStyle(style);
        header.createCell(3).setCellValue("Bagian6");
        header.getCell(3).setCellStyle(style);
        header.createCell(3).setCellValue("Bagian7");
        header.getCell(3).setCellStyle(style);


        int baris = 1;

        for (Karyawan karyawan : karyawans) {
            HSSFRow dataBaris = sheet.createRow(baris++);
            dataBaris.createCell(0).setCellValue(karyawan.getId());
            dataBaris.createCell(1).setCellValue(karyawan.getNama());
            dataBaris.createCell(2).setCellValue(karyawan.getAlamat());
            dataBaris.createCell(3).setCellValue(karyawan.getBagian());
            dataBaris.createCell(4).setCellValue(karyawan.getBagian1());
            dataBaris.createCell(5).setCellValue(karyawan.getBagian1());
            dataBaris.createCell(6).setCellValue(karyawan.getBagian1());
            dataBaris.createCell(7).setCellValue(karyawan.getBagian1());
            dataBaris.createCell(8).setCellValue(karyawan.getBagian1());
            dataBaris.createCell(9).setCellValue(karyawan.getBagian1());
            dataBaris.createCell(10).setCellValue(karyawan.getBagian1());
        }

        System.out.println("导出数量 "+karyawans.size()+"总共花费" + (System.currentTimeMillis() - t1));
    }

}