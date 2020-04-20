<html>
<#include "../common/header.ftlh">

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                外卖订单管理系统
            </h3>
            <form role="form" method="post" action="/sell/seller/signin/check">
                <div class="form-group">
                    <label>用户名</label>
                    <input name="username" type="text" class="form-control" />
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input name="password" type="password" class="form-control" />
                </div>

                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>
</body>
</html>