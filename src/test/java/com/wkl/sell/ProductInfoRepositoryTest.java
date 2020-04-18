package com.wkl.sell;

import com.wkl.sell.dataobject.ProductInfo;
import com.wkl.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void findOneTest(){
        ProductInfo productInfo = repository.findById("1001").orElse(null);
        System.out.println(productInfo.toString());
    }
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1003");
        productInfo.setProductName("豆浆");
        productInfo.setProductDescription("白");
        productInfo.setProductPrice(new BigDecimal(1.2));
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);

    }
}