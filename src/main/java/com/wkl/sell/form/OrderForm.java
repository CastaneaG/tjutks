package com.wkl.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {
    //买家信息
    @NotEmpty(message = "姓名必填")
    private String name;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    @NotEmpty
    private String items;

}
