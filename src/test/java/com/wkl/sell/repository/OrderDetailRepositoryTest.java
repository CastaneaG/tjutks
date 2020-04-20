package com.wkl.sell.repository;

import com.wkl.sell.dataobject.OrderDetail;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("20012");
        orderDetail.setOrderId("2001");
        orderDetail.setProductId("1002");
        orderDetail.setProductName("油条");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductQuantity(1);

        OrderDetail result = repository.save(orderDetail);

    }

    @Test
    void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("2001");
        System.out.println(orderDetailList.toString());
    }
}