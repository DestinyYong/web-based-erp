package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Wharehouse;

import java.util.List;

public interface WharehouseService {
    void addProductIntoWharehouse(Wharehouse wharehouse);
    void updateWharehouse(Wharehouse wharehouse);
    List<Wharehouse> listWhareHouse(int page);
}
