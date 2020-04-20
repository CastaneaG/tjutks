package com.wkl.sell.service;

import com.wkl.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品详情
 */
public interface ProductInfoService {
    ProductInfo findById(String productId);
    Page<ProductInfo> findAll(Pageable pageable);
    List<ProductInfo> findAll();
    ProductInfo save(ProductInfo productInfo);
    void delete(String productId);
}
