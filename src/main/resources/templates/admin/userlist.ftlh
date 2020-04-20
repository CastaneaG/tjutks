<html>
<#include "../common/header.ftlh">
<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/adminnav.ftlh">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>用户id</th>
                            <th>用户名</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list sellerInfoList as sellerInfo>
                            <tr>
                                <td>${sellerInfo.sellerId}</td>
                                <td>${sellerInfo.username}</td>
                                <td><a href="/sell/admin/index?sellerId=${sellerInfo.sellerId}">修改</a></td>
                                <td><a href="/sell/admin/delete?productId=${sellerInfo.sellerId}">删除</a></td>

                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>