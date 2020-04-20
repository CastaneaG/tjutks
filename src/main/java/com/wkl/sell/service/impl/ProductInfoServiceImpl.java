package com.wkl.sell.service.impl;

import com.wkl.sell.dataobject.ProductInfo;
import com.wkl.sell.repository.ProductInfoRepository;
import com.wkl.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 商品
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findAll() {
        return repository.findAll();
    }


    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void delete(String productId) {
        if (repository.existsById(productId)){
        repository.deleteById(productId);}
    }
}
