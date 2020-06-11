<html>
<#include "../common/header.ftlh">

<body background="/sell/img/my.jpg">
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/adminnav.ftlh">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column" >
                    <form role="form" method="post" action="/sell/admin/save" >
                        <div class="form-group">
                            <label>用户名</label>
                            <input name="username" type="text" class="form-control" value="${(sellerInfo.username)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="text" class="form-control" value="${(sellerInfo.password)!''}"/>
                        </div>


                        <input hidden type="text" name="sellerId" value="${(sellerInfo.sellerId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>

</body>
</html>