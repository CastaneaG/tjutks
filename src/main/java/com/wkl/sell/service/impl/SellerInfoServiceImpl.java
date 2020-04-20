package com.wkl.sell.service.impl;

import com.wkl.sell.dataobject.SellerInfo;
import com.wkl.sell.repository.SellerInfoRepository;
import com.wkl.sell.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {
    @Autowired
    private SellerInfoRepository repository;


    @Override
    public SellerInfo findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<SellerInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public SellerInfo findById(String sellerId) {
        return repository.findById(sellerId).orElse(null);
    }

    @Override
    public SellerInfo save(SellerInfo sellerInfo) {
        return repository.save(sellerInfo);
    }

    @Override
    public void delete(String sellerId) {
        if (repository.existsById(sellerId)){
            repository.deleteById(sellerId);}
    }
}
