package com.wkl.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    CART_EMPTY(18,"购物车不能为空"),
    ORDER_CANCEL_SUCCESS(22, "订单取消成功"),
    ORDER_FINISH_SUCCESS(23, "订单完结成功"),
    USER_NOT_EXIST(25,"用户不存在")
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
