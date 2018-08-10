<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title> - V2.6.2</title>
    <link href="/local/protrack365.com/images/fav.ico" rel="icon" type="/image/x-icon" />
    <link rel="stylesheet" type="text/css" href="/css/base.v1.css?v=2018051701" />
    <link rel="stylesheet" type="text/css" href="/css/comm.v1.css?v=2018051701" />
    <link rel="stylesheet" type="text/css" href="/css/forms.css?v=2018051701" />
    <link rel="stylesheet" type="text/css" href="/dealer/css/home.css?v=2018051701">
    <link rel="stylesheet" type="text/css" href="/css/home.css?v=2018051701">
    <link rel="stylesheet" href="/js/scrollbar/jquery.mCustomScrollbar.min.css">
    <script type="text/javascript">
        var customerid = 83412;
        window.isAuth2ModifyPlatform = true;
        //LocationService?method=customerDeviceAndGpsone&customerid=10025  //帐号登录初始化数据
        //LocationService?method=deviceAndGpsone&deviceid=74  imei号登录初始化参数
        //LocationService?method=monitor&customerid=10025 //帐号登录刷新接口
        //LocationService?method=track&deviceid=74  //设备登录刷新接口
    </script>
    <script type="text/javascript" src="/js/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/js/artDialog/jquery.artDialog.js?skin=blue"></script>
    <script type="text/javascript" src="/js/artDialog/plugins/iframeTools.js"></script>
    <script type="text/javascript" src="/js/comm/zh-cn.js?v=2018051701"></script>
    <script type="text/javascript" src="/js/comm/config.js?v=2018051701"></script>
    <script type="text/javascript" src="/js/comm/core-c.js?v=2018051701"></script>
    <script type="text/javascript" src="/js/comm/utill.js?v=2018051701"></script>
    <script type="text/javascript" src="/js/comm/validator.js?v=2018051701"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?5bfe020eaccf36a9f0bfa1014334e417";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
</head>
<body class="f13">
<div id="searchWrapper">
    <div class="nav">
        <div class="wap">
            <div class="logo"><a href="/dealer"><img src="/local/protrack365.com/images/header_logo.png" height="50" style="vertical-align: middle;"/></a></div>
            <div class="fl mainmenu">
                <ul class="f16 ff-ms">
                    <li class=''>
                        <a href='/page?customerid=83412'>监控</a>
                    </li>

                    <li class=''>
                        <a href='?p=stat&customerid=83412'>统计报表</a>
                    </li>

                    <li class='active'>
                        <a href='#'>设备管理</a>
                    </li>


                </ul>
            </div>

        </div>
    </div>
</div>
























<link rel="stylesheet" type="text/css"
      href="/css/stat.css?v=2018051701" />
<div id="wrapper">
    <div id="container">
        <div class="gps-breadcrumb-item">我的设备</div>
        <iframe name="pages" id="statpagesframe"
                src="/page/devicelist.jsp?customerid=83412"
                style="width: 100%; height: 100%;" scrolling="auto" frameborder="0"></iframe>
    </div>
    <div id="nav_menu" style="background-color: #FFF;">

        <script type="text/javascript">
            function onClick(event, treeId, node, clickFlag)
            {
                stat_customerid = node.id;
                $("#statpagesframe").attr("src","/page/"+pages[page_index]+"?customerid="+stat_customerid);
                //alert(node.id);
            };
        </script>
        <!-- 客户树 star-->
























        <style type="text/css">
            /*监控界面针对经销商客户树模块*/
            .cust_tree_container .cust_tit{cursor:pointer;padding-left:28px;font-weight:500;position: relative;font-size: 14px;color: #777;}
            .cust_tree_container .cust_tit:before{position: absolute;left: 16px;top: -1px;}
            .cust_tree_container .fold{background-position:0px -35px;}
            .cust_tree_container .fold:before{left: 18px;top: 0;}
            #tree_content{overflow-y:auto;padding:5px 0px 5px 5px;background:#fff;border-top: 1px solid #F0F0F0;}
            .expand{background-color:#f7f7f7;cursor:n-resize;font-size:0;padding:2px;text-align:center;top:140px;border-top:1px solid #f0f0f0;height: 5px;background-image: url(/images/n-resize.gif);background-repeat: no-repeat;background-position: center;}
            .cust_tree_container .h_menu {background:#F8F8F8;border-top: 1px solid #F0F0F0;color: #666666;height:35px;line-height:35px;}
        </style>

        <!-- 客户树 star-->
        <div class="cust_tree_container">
            <div class="h_menu" style="margin-top:0px !important;">
                <h3 class="cust_tit gps-caret-down-icon">我的客户</h3>
            </div>
            <div class="cust_tree_layer">
                <ul id="tree_content" class="ztree" style="overflow:auto;height:150px;"></ul>
                <div class="expand" onmousedown="drag_top(this,event,'menu_list');"></div>
            </div>
        </div>
        <!-- 客户树 end-->
        <link rel="stylesheet" type="text/css" href="/js/zTree_v3/css/zTreeStyle/zTreeStyle.css?v=20170925"/>
        <script type="text/javascript" src="/js/zTree_v3/jquery.ztree.core-3.5.min.js"></script>
        <script type="text/javascript">
            var root =  [{"name":"York Company(9/10)", "id":83412, "hadchild": true,iconSkin:"c1",type:1}];
            var tree_data_url = "/DataService?method=treecustomer&puretree=1";
        </script>
        <script type="text/javascript" src="/page/js/tree_customer.js"></script>
        <!-- 客户树 end-->

        <div class="_tit fb">
            <h3 class="gps-menu-title gps-caret-down-icon">设备管理</h3>
        </div>
        <div id="menu_list" class="gps-menu f14" style="overflow-y: auto;">
            <div index=1
                 class="gps-menu-item  gps-menu-item-active">
                <a class="gps-menu-item-icon gps-laptop-icon"></a>我的设备</div>
            <div index=2
                 class="gps-menu-item ">
                <a class="gps-menu-item-icon gps-sitemap-icon"></a>设备分组</div>
            <div index=3
                 class="gps-menu-item ">
                <a class="gps-menu-item-icon gps-tint-icon"></a>保养概览</div>

            <div index=5
                 class="gps-menu-item ">
                <a class="gps-menu-item-icon gps-share-icon"></a>分享链接管理</div>
            <div index="7"
                 class="gps-menu-item ">
                <a class="gps-menu-item-icon gps-commenting-icon"></a>提醒管理</div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var stat_customerid = "83412";
    var page_index = 1;
    var pages = ['',"devicelist.jsp","group.jsp","maintenancelist.jsp","addtarget.jsp","shareadmin.jsp","devicelist.jsp","reminde.jsp"];
    var stat_tit = ['','我的设备','设备分组','保养概览','添加设备','分享链接管理','订阅','提醒管理'];
    $("#nav_menu .gps-menu-item").click(
            function() {
                var index = $(this).attr("index");
                $("#nav_menu .gps-menu-item").each(
                        function(n) {
                            var k = $(this).attr("index");
                            if (k == index) {
                                $(this).addClass("gps-menu-item-active");
                                page_index = index;
                                $("#statpagesframe").attr(
                                        "src",
                                        "/page/" + pages[index]
                                        + "?customerid="
                                        + stat_customerid);
                                $("#container .gps-breadcrumb-item").html(
                                        stat_tit[index]);
                            } else {
                                $(this).removeClass("gps-menu-item-active");
                            }
                        });
            });

    function resetFrame() {
        var c_tree_h = $(".cust_tree_container").innerHeight() ? $(
                ".cust_tree_container").innerHeight() : 0;
        $("#container").width(document.body.clientWidth - 241);
        $("#wrapper").height(document.body.clientHeight - 60);
        $("#container").height(document.body.clientHeight - 60);
        $("#nav_menu").height(document.body.clientHeight - 60);
        $("#menu_list").height(document.body.clientHeight - 60 - 35 - c_tree_h);
        //$("#tab_container").height(document.body.clientHeight-60-36);
        $("#statpagesframe").height(document.body.clientHeight - 60 - 35);
        //$("#statpagesframe").contents().find("#tab_container").height(document.body.clientHeight-60-36);
    }
    $(window).resize(resetFrame);
    resetFrame();
</script>

</body>
</html>
<script type="text/javascript" src="/page/js/customerdetail.js?v=2018051701"></script>
<script type="text/javascript" src="/page/js/alarmsetting.js?v=2018051701"></script>
<script type="text/javascript" src="/page/js/settings.js?v=2018051701"></script>
<script type="text/javascript" src="/page/js/password.js"></script>
<script type="text/javascript" src="/page/js/myservice.js"></script>
<script type="text/javascript" src="/page/js/devicedetail.js?v=2018051701"></script>
<link rel="stylesheet" href="/js/simpletooltip/css/simpletooltip.min.css" media="screen" />
<script type="text/javascript" src="/js/simpletooltip/js/simpletooltip.min.js"></script>

<!--<script type="text/javascript" src="/js/comm/alarm.js?v=2018051701"></script>-->
<script type="text/javascript" src="/page/js/maintenance.js?v=2018051701"></script>
<script type="text/javascript" src="/page/js/messagelist.js"></script>
<script type="text/javascript" src="/js/comm/autocomplete.js"></script>
<script type="text/javascript" src="/page/js/parentIframe.js?v=2018051701"></script>
<script src="/js/scrollbar/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="/js/scrollbar/jquery.mousewheel.min.js"></script>
<script type="text/javascript">
    function resetFrame(){
        var _h = $("#searchWrapper").css("display")=="none"?0:60;
        $("#icontent_container,#monitor_iframe").width(document.body.clientWidth);
        $("#icontent_container,#monitor_iframe").height(document.body.clientHeight-_h);
    }

    //切换语言
    function changeLang(lang){
        var urlPamar = location.href,
                url = changeURLArg(urlPamar,"lang",lang);
        location.href = url;
    }

    //退出
    function signOut(){
        location.href = "/";
    }

    $(document).ready(function() {
        var setmwidth = getHtmlSize("服务商<br />报警设置<br/>密码").w+21;
        $(window).resize(resetFrame);
        resetFrame();
        getunreadmessage("badgediv");

        $(".settingmore").mouseenter(function(){
            $(this).addClass("hover");
        }).mouseleave(function(){
            $(this).removeClass("hover");
        });
        $(".settingmorelist").css("width",setmwidth);

        setLocalStorage("baidu");  //设置地图maptype


        $(".header-lang").mouseenter(function(){
            $(this).children(".header-lang-select").addClass("select-open");
            $(this).children(".header-lang-option").removeClass("none");
        }).mouseleave(function(){
            $(this).children(".header-lang-select").removeClass("select-open");
            $(this).children(".header-lang-option").addClass("none");
        });

        var itvalTime;
        $(".profile-toggle").click(function(e){
            // window.event? window.event.cancelBubble = true : e.stopPropagation();
            // window.event? window.event.returnValue = false : e.preventDefault();
            var elem = $(".profile-toggle-box");
            //$(this).toggleClass("down-icon");
            elem.toggleClass("none");
            clearInterval(itvalTime);
            itvalTime = setInterval(function() {
                if (document.activeElement != $(".profile-toggle")[0]) {
                    clearInterval(itvalTime);
                    elem.addClass("none");
                }
            }, 200);
        });
    });

    // setTimeout(function(){
    // 	wobj = new Alarm(83412,"http://www.protrack365.com:80/");
    // 	wobj.loadDate();
    // },2000);

</script>

