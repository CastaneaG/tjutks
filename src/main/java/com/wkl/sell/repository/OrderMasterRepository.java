package com.wkl.sell.repository;

import com.wkl.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerPhone(String buyerPhone, Pageable pageable);
    Page<OrderMaster> findAllByOrderByCreateTimeDesc(Pageable pageable);
}
