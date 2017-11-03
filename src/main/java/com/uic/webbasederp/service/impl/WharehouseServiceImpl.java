package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Wharehouse;
import com.uic.webbasederp.mapper.WharehouseMapper;
import com.uic.webbasederp.service.WharehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WharehouseServiceImpl implements WharehouseService{
    @Autowired
    private WharehouseMapper wharehouseMapper;

    @Override
    public void addProductIntoWharehouse(Wharehouse wharehouse) {
        wharehouseMapper.addProductIntoWharehouse(wharehouse);
    }

    @Override
    public void updateWharehouse(Wharehouse wharehouse) {
        wharehouseMapper.updateWharehouse(wharehouse);
    }

    @Override
    public List<Wharehouse> listWhareHouse(int page) {
        return wharehouseMapper.listWhareHouse((page-1)*15);
    }
}
