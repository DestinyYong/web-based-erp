package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.vo.ReportRequestVo;
import com.uic.webbasederp.domain.vo.ReportVo;
import com.uic.webbasederp.service.ReportService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    @Override
    public void createExcel(HttpServletRequest request, HttpServletResponse response, ReportRequestVo reportRequestVo) throws Exception{
        List<ReportVo> reportVos = reportRequestVo.getReportVos();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font=wb.createFont();
        font.setFontHeightInPoints((short)20);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
        for(ReportVo reportVo : reportVos){
            CellRangeAddress cra=new CellRangeAddress(0, 1, 2, 13);
            String base64Img = reportVo.getImage();
            String[] base64String = base64Img.split(",");


            BASE64Decoder decoder = new BASE64Decoder();
            byte[] imageBytes = decoder.decodeBuffer(base64String[1]);
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            byteArrayOut.write(imageBytes);


            HSSFSheet sheet1 = wb.createSheet(reportVo.getTitle());
            Row row = sheet1.createRow(0);

            Cell cell_1 = row.createCell(2);
            cell_1.setCellValue(reportVo.getDateAndTitle());
            cell_1.setCellStyle(style);
            sheet1.addMergedRegion(cra);
            HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();

            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 2, 3, (short) 14, 38);
            //插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

        }
        // 输出文件


        String fileName = reportRequestVo.getFileName()+".xls";
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName).getBytes(), "iso-8859-1"));
        wb.write(response.getOutputStream());
    }
}
