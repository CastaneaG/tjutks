package com.wkl.sell.repository;

import com.wkl.sell.dataobject.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    private final String PHONENUM= "12345678901";
    @Test
    void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2001");
        orderMaster.setBuyerName("王康力");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setBuyerAddress("天津理工大学");
        orderMaster.setOrderAmount(new BigDecimal(11.3));

        repository.save(orderMaster);
    }
    @Test
    public void findByBuyerPhone() throws Exception{
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<OrderMaster> result = repository.findByBuyerPhone(PHONENUM,pageRequest);
        System.out.println(result.getTotalElements());
    }
}