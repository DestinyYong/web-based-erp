package com.uic.webbasederp.service.impl;

import com.aliyun.oss.OSSClient;
import com.uic.webbasederp.domain.po.Product;
import com.uic.webbasederp.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public String savePicture(MultipartFile multipartFile) throws Exception{
        String fileName;
        String imageUrl;

        String originalFilename = multipartFile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();

        String accessKeyID = "LTAIYgFNydhNOR85";
        String accessKeySecret = "XXsoLoyuVLl6JtTHQE6MGOU9u8GG8h";
        String ossEndpoint = "oss-cn-shenzhen.aliyuncs.com";
        String bucket = "worker-bee";
        try{
            OSSClient ossClient = new OSSClient(ossEndpoint, accessKeyID, accessKeySecret);
            fileName = random.nextInt(10000) + System.currentTimeMillis() + substring;
            ossClient.putObject(bucket,fileName,multipartFile.getInputStream());
            ossClient.shutdown();
            imageUrl = "http://" + bucket + "." + ossEndpoint + "/" + fileName;
        }catch (Exception e){
            System.out.println("OSS has some problems");
            throw e;
        }
        return imageUrl;
    }

    @Override
    public void insertProduct(Product product) {

    }
}
