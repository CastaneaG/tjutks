package com.wkl.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by 廖师兄
 * 2017-07-23 17:20
 */
@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;


    /** 描述. */
    private String productDescription;



}
