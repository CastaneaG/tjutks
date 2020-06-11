<html>
<#include "../common/header.ftlh">

<body background="/sell/img/my.jpg">
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftlh">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-8 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>信息</th>
                            <th>数据</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>订单id</td>
                            <td>${orderDTO.orderId}</td>

                        </tr>
                        <tr>
                            <td>订单总金额</td>
                            <td>${orderDTO.orderAmount}</td>
                        </tr>

                        <tr>
                            <td>买家姓名</td>
                            <td>${orderDTO.buyerName}</td>
                        </tr>
                        <tr>
                            <td>买家手机号</td>
                            <td>${orderDTO.buyerPhone}</td>
                        </tr>
                        <tr>
                            <td>订单地址</td>
                            <td>${orderDTO.buyerAddress}</td>
                        </tr>

                        <tr>
                            <td>订单创建时间</td>
                            <td>${orderDTO.createTime}</td>
                        </tr>

                        </tbody>
                    </table>
                </div>

            <#--订单详情表数据-->
                <div class="col-md-12 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>总额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTO.orderDetailList as orderDetail>
                        <tr>
                            <td>${orderDetail.productId}</td>
                            <td>${orderDetail.productName}</td>
                            <td>${orderDetail.productPrice}</td>
                            <td>${orderDetail.productQuantity}</td>
                            <td>${orderDetail.productQuantity * orderDetail.productPrice}</td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--操作-->
                <div class="col-md-12 column">
                <#if orderDTO.getOrderStatusEnum().message == "新订单">
                    <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
                    <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
                </#if>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>