package com.wkl.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class SellerInfo {

    @Id
    private String sellerId;


    private String username;


    private String password;


    private int permission;

}
