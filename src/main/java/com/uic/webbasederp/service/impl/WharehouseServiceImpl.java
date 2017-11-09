package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Wharehouse;
import com.uic.webbasederp.domain.vo.WharehouseDetailVo;
import com.uic.webbasederp.mapper.ProductMapper;
import com.uic.webbasederp.mapper.WharehouseMapper;
import com.uic.webbasederp.service.WharehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WharehouseServiceImpl implements WharehouseService{
    @Autowired
    private WharehouseMapper wharehouseMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addProductIntoWharehouse(Wharehouse wharehouse) {
        wharehouseMapper.addProductIntoWharehouse(wharehouse);
    }

    @Override
    public void updateWharehouse(Wharehouse wharehouse) {
        wharehouseMapper.updateWharehouse(wharehouse);
    }

    @Override
    public List<WharehouseDetailVo> listWhareHouse() {
        List<Wharehouse> wharehouses = wharehouseMapper.listWhareHouse();
        List<WharehouseDetailVo> wharehouseDetailVos = new ArrayList<>();
        for(Wharehouse wharehouse : wharehouses){
            WharehouseDetailVo wharehouseDetailVo = new WharehouseDetailVo();
            wharehouseDetailVo.setId(wharehouse.getId());
            wharehouseDetailVo.setProductId(wharehouse.getProductId());
            wharehouseDetailVo.setProductName(productMapper.getProductById(wharehouse.getProductId()).getProductName());
            wharehouseDetailVo.setOrderNumber(wharehouse.getOrderNumber());
            wharehouseDetailVo.setAvailableNumber(wharehouse.getAvailableNumber());
            wharehouseDetailVo.setMinStoreNumber(wharehouse.getMinStoreNumber());
            wharehouseDetailVos.add(wharehouseDetailVo);
        }
        return wharehouseDetailVos;
    }
}
