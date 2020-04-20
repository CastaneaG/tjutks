package com.wkl.sell.service;

import com.wkl.sell.dataobject.SellerInfo;

import java.util.List;

public interface SellerInfoService {
    SellerInfo findByUsername(String username);
    List<SellerInfo> findAll();
    SellerInfo findById(String sellerId);
    SellerInfo save(SellerInfo sellerInfo);
    void delete(String sellerId);
}
