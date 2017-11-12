package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.vo.ReportVo;
import com.uic.webbasederp.service.ReportService;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    @Override
    public void createExcel(List<ReportVo> reportVos) throws Exception{
        FileOutputStream fileOut = null;
        HSSFWorkbook wb = new HSSFWorkbook();
        for(ReportVo reportVo : reportVos){
            String base64Img = reportVo.getImage();
            String[] base64String = base64Img.split(",");


            BASE64Decoder decoder = new BASE64Decoder();
            byte[] imageBytes = decoder.decodeBuffer(base64String[1]);
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            byteArrayOut.write(imageBytes);


            HSSFSheet sheet1 = wb.createSheet(reportVo.getTitle());
            HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();

            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 2, 2, (short) 8, 16);
            //插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

        }
        fileOut = new FileOutputStream("I:\\excel.xls");
        // 输出文件
        wb.write(fileOut);
    }
}
