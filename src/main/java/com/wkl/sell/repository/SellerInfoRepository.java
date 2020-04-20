package com.wkl.sell.repository;

import com.wkl.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByUsername(String username);
    Boolean existsByUsername(String username);
}
