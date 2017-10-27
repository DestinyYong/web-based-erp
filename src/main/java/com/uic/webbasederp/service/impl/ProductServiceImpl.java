package com.uic.webbasederp.service.impl;

import com.aliyun.oss.OSSClient;
import com.uic.webbasederp.domain.po.Product;
import com.uic.webbasederp.domain.vo.ProductVo;
import com.uic.webbasederp.mapper.ProductMapper;
import com.uic.webbasederp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    public String savePicture(String base64Image, String fileType) throws Exception{
        String fileName;
        String imageUrl;

        String[] base64String = base64Image.split(",");

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] imageBytes = decoder.decodeBuffer(base64String[1]);
//        for(int i=0;i<imageBytes.length;++i)
//            {
//                if(imageBytes[i]<0)
//                {//调整异常数据
//                    imageBytes[i]+=256;
//                }
//            }

        //byte[] imageBytes = new BASE64Decoder().decodeBuffer(base64Image);
        InputStream inputStream = new ByteArrayInputStream(imageBytes);

        Random random = new Random();

        String accessKeyID = "LTAIYgFNydhNOR85";
        String accessKeySecret = "XXsoLoyuVLl6JtTHQE6MGOU9u8GG8h";
        String ossEndpoint = "oss-cn-shenzhen.aliyuncs.com";
        String bucket = "worker-bee";
        try{
            OSSClient ossClient = new OSSClient(ossEndpoint, accessKeyID, accessKeySecret);
            fileName = random.nextInt(10000) + System.currentTimeMillis() + "." +fileType;
            ossClient.putObject(bucket,fileName,inputStream);
            ossClient.shutdown();
            imageUrl = "http://" + bucket + "." + ossEndpoint + "/" + fileName;
        }catch (Exception e){
            System.out.println("OSS has some problems");
            throw e;
        }
        return imageUrl;
    }

    @Override
    public void insertProduct(ProductVo productVo) throws Exception{
        Product product = new Product();
        product.setCost(productVo.getCost());
        product.setMinStorageNumber(productVo.getMinStorageNumber());
        product.setProductHeight(productVo.getProductHeight());
        product.setProductLength(productVo.getProductLength());
        product.setProductWidth(productVo.getProductWidth());
        product.setPrice(productVo.getPrice());
        product.setProductId(productVo.getProductId());
        product.setSizeOfBox(productVo.getSizeOfBox());
        product.setState(productVo.getState());
        product.setProductName(productVo.getProductName());
        product.setType(productVo.getType());
        product.setPictureAddress(savePicture(productVo.getBase64Image(),productVo.getFileType()));

        productMapper.saveProduct(product);
    }
}
