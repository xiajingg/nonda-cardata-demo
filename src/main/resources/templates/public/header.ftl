<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
    <#--<base href="./../">-->
    <#--<meta charset="utf-8">-->
    <#--<meta http-equiv="X-UA-Compatible" content="IE=edge">-->
    <#--<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">-->
    <#--<meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">-->
    <#--<meta name="author" content="Łukasz Holeczek">-->
    <#--<meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">-->
    <#--<title>header</title>-->
    <#--<link href="node_modules/@coreui/icons/css/coreui-icons.min.css" rel="stylesheet">-->
    <#--<link href="node_modules/flag-icon-css/css/flag-icon.min.css" rel="stylesheet">-->
    <#--<link href="node_modules/font-awesome/css/font-awesome.min.css" rel="stylesheet">-->
    <#--<link href="node_modules/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">-->
<#--</head>-->
<#--<body>-->
<header class="app-header navbar">
    <button class="navbar-toggler sidebar-toggler d-lg-none mr-auto" type="button" data-toggle="sidebar-show">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">
        <img class="navbar-brand-full" src="/img/brand/logo.svg" width="89" height="25" alt="CoreUI Logo">
        <img class="navbar-brand-minimized" src="/img/brand/sygnet.svg" width="30" height="30" alt="CoreUI Logo">
    </a>
    <ul class="nav navbar-nav ml-auto">
        <li class="nav-item dropdown">
        <#if Session?? && Session["email"]?exists>
            欢迎：[${Session["email"]}]
        </#if>
            <a class="nav-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                <img class="img-avatar" src="/img/avatars/6.jpg" alt="admin@bootstrapmaster.com">
            </a>
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="#">
                    <i class="fa fa-lock"></i> Logout</a>
            </div>
        </li>
    </ul>
    <button class="navbar-toggler aside-menu-toggler d-md-down-none" type="button" data-toggle="aside-menu-lg-show">
        <span class="navbar-toggler-icon"></span>
    </button>
    <button class="navbar-toggler aside-menu-toggler d-lg-none" type="button" data-toggle="aside-menu-show">
        <span class="navbar-toggler-icon"></span>
    </button>
</header>
<#--</body>-->
<#--</html>-->