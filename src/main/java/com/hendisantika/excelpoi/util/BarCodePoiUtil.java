package com.hendisantika.excelpoi.util;

import com.hendisantika.excelpoi.entity.BarCodeForm;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Created by liuyan on 2019/1/9.
 */
public class BarCodePoiUtil {
    public static void setExcelContent(List<BarCodeForm> list, String[] tableHeader, Row row, Sheet sh, Cell cell) {
        // 创建表头
        row = sh.createRow(0);
        for (int b = 0; b < tableHeader.length; b++) {
            cell = row.createCell(b);
            cell.setCellValue(tableHeader[b]);
        }
        // 创建表内容
        for (int a = 0; a < list.size(); a++) {

            row = sh.createRow(a + 1);
            for (int b = 0; b < tableHeader.length; b++) {
                cell = row.createCell(b);
                switch (b) {
                    case 0:// 条形码编号
                        cell.setCellValue(list.get(a).getItemNo() != null ? list.get(a).getItemNo() : "");
                        break;
                    case 1:// 商品名称
                        cell.setCellValue(list.get(a).getItemName() != null ? list.get(a).getItemName() : "");
                        break;
                    case 2:// 备注
                        cell.setCellValue(list.get(a).getPym() != null ? list.get(a).getPym() : "");
                        break;
                    case 3:// 容量/体积
                        cell.setCellValue(list.get(a).getItemSize() != null ? list.get(a).getItemSize() : "");
                        break;
                    case 4:// 单位
                        cell.setCellValue(list.get(a).getUnitNo() != null ? list.get(a).getUnitNo() : "");
                        break;
                    case 5:// 产地
                        cell.setCellValue(list.get(a).getProductArea() != null ? list.get(a).getProductArea() : "");
                        break;
                    case 6:// 创建时间
                        cell.setCellValue(list.get(a).getCreateTime() != null ? list.get(a).getCreateTime().toString() : "");
                        break;
                    case 7:// 创建人
                        cell.setCellValue(list.get(a).getCreateByName() != null ? list.get(a).getCreateByName().toString() : "");
                        break;
                    case 8:// 修改时间
                        cell.setCellValue(list.get(a).getUpdateTime() != null ? list.get(a).getUpdateTime().toString() : "");
                        break;
                    case 9:// 修改人
                        cell.setCellValue(list.get(a).getUpdateByName() != null ? list.get(a).getUpdateByName().toString() : "");
                        break;
                    default:
                        cell.setCellValue("");
                }
            }
        }

    }
}
