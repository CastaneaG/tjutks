# SQL
```sql
-- 商品
create table `product_info` (
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '单价',
    `product_description` varchar(64) comment '描述',
    primary key (`product_id`)
);

-- 订单
create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment '买家名字',
    `buyer_phone` varchar(32) not null comment '买家电话',
    `buyer_address` varchar(128) not null comment '买家地址',
    `order_amount` decimal(8,2) not null comment '订单总金额',
    `order_status` tinyint(3) not null default '0' comment '订单状态, 默认为新下单',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    primary key (`order_id`)
);

-- 订单商品
create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '当前价格,单位分',
    `product_quantity` int not null comment '数量',
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
);

create table if not exists `seller_info`(
`seller_id` varchar(32) not null,
`username` varchar(32) not null,
`password` varchar(32) not null,
`permission` int not null,
primary key (`seller_id`)
)comment '卖家信息表';

ALTER TABLE order_detail ADD FOREIGN KEY orderid (order_id) REFERENCES order_master (order_id);
ALTER TABLE order_detail ADD FOREIGN KEY productid (product_id) REFERENCES product_info (product_id);
```

