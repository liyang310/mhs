<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="static/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="static/styles/Common.css" rel="stylesheet" />
    <link href="static/styles/Index.css" rel="stylesheet" />
</head>
<body>
    <div class="header">

        <img class="logo" src="static/images/logo.jpg" />
        <label class="logo-title">Talent Fleet System</label>
        <ul class="inline">
            <li>
                <img src="static/images/32/client.png" />&nbsp;&nbsp;欢迎您,Admin
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle mymsg" data-toggle="dropdown" href="#"><img src="static/images/32/166.png" />&nbsp;&nbsp;修改个人信息<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">修改密码</a></li>
                </ul>

            </li>
            <li>
                <img src="static/images/32/200.png" />&nbsp;&nbsp;<a class="loginout" href="#">退出</a>
            </li>

        </ul>


    </div>


    <div class="nav">

        <ul class="breadcrumb">
            <li>
                <img src="static/images/32/5025_networking.png" />
            </li>
            <li><a href="#">首页</a> <span class="divider">>></span></li>
            <li class="active"></li>
        </ul>
    </div>



    <div class="container-fluid content">
        <div class="row-fluid">
            <div class="span2 content-left">
                <div class="accordion">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                <img class="left-icon" src="static/images/32/5026_settings.png" /><span class="left-title">系统设置</span>
                            </a>
                        </div>
                        <div id="collapseOne" class="accordion-body collapse in">
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/4962_sitemap.png" /><span class="left-body"> 模块管理</span>
                            </div>
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/4957_customers.png" /><span class="left-body"> 角色管理</span>

                            </div>
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/4992_user.png" /><span class="left-body"> 用户管理</span>

                            </div>
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/612.png" /><span class="left-body"> 单位管理</span>

                            </div>
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/8.png" /><span class="left-body"> 字典管理</span>

                            </div>
                        </div>
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                                <img class="left-icon" src="static/images/32/5026_settings.png" /><span class="left-title">Fleet Register</span>
                            </a>
                        </div>
                        <div id="collapseTwo" class="accordion-body collapse in">
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/4962_sitemap.png" /><span class="left-body"><a href="listCompany"> company manage</a></span>
                            </div>
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/4957_customers.png" /><span class="left-body"> 角色管理</span>

                            </div>
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/4992_user.png" /><span class="left-body"> 用户管理</span>

                            </div>
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/612.png" /><span class="left-body"> 单位管理</span>

                            </div>
                            <div class="accordion-inner">
                                <img class="left-icon-child" src="static/images/32/8.png" /><span class="left-body"> 字典管理</span>

                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="span10 content-right">
                <iframe id="right" src="listUser" class="iframe"></iframe>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="foot"></div>
    <script src="static/scripts/jquery-1.9.1.min.js"></script>
    <script src="static/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="static/scripts/Index.js"></script>
	<div style="text-align:center;">
<p>copyright:<a href="http://www.mycodes.net/" target="_blank">北京易海海事科技</a></p>
</div>

</body>
</html>
