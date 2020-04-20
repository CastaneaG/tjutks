package com.wkl.sell.service.impl;

import com.wkl.sell.dataobject.OrderDetail;
import com.wkl.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("wkl2");
        orderDTO.setBuyerAddress("TJJJJ");
        orderDTO.setBuyerPhone("12345678902");
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1003");
        o1.setProductQuantity(3);
        orderDetailList.add(o1);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("1002");
        o2.setProductQuantity(2);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result= orderService.create(orderDTO);
        log.info("【创建订单】 result={}",result);
    }

    @Test
    void findById() {
    }

    @Test
    void cancel() {
    }

    @Test
    void finish() {
    }

    @Test
    void findList() {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage =  orderService.findList(request);
        System.out.println(orderDTOPage.toString());
    }
}