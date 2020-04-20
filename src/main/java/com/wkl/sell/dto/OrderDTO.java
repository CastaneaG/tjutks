package com.wkl.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wkl.sell.dataobject.OrderDetail;
import com.wkl.sell.enums.OrderStatusEnum;
import com.wkl.sell.utils.EnumUtil;
import com.wkl.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//dto 数据传输对象
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 创建时间. */
    //@JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

}
