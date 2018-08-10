<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script type="text/javascript" src="/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css" />

    <link rel="stylesheet" href="/awesomplete/css/awesomplete.css" />
    <script src="/awesomplete/js/awesomplete.js" async></script>
</head>
<body>

<div class="layui-form-item">
    <label class="layui-form-label">选择框</label>
    <div class="layui-input-block">
        <select name="city" lay-verify="required">
            <option value=""></option>
            <option value="0">北京</option>
            <option value="1">上海</option>
            <option value="2">广州</option>
            <option value="3">深圳</option>
            <option value="4">杭州</option>
        </select>
    </div>
</div>
<form class="layui-form" action="">
<div class="layui-form-item">
    <label class="layui-form-label">选择框</label>
    <div class="layui-input-block">
<select name="quiz">
    <option value="">请选择</option>
    <optgroup label="城市记忆">
        <option value="你工作的第一个城市">你工作的第一个城市？</option>
    </optgroup>
    <optgroup label="学生时代">
        <option value="你的工号">你的工号？</option>
        <option value="你最喜欢的老师">你最喜欢的老师？</option>
    </optgroup>
</select>
    </div>
</div>
</form>

<button type="button" class="layui-btn" id="test1">
    <i class="layui-icon">&#xe67c;</i>上传文件
</button>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">输入框</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">辅助文字</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择框</label>
        <div class="layui-input-block">
            <select name="city" lay-verify="required">
                <option value=""></option>
                <option value="0">北京</option>
                <option value="1">上海</option>
                <option value="2">广州</option>
                <option value="3">深圳</option>
                <option value="4">杭州</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">复选框</label>
        <div class="layui-input-block">
            <input type="checkbox" name="like[write]" title="写作">
            <input type="checkbox" name="like[read]" title="阅读" checked>
            <input type="checkbox" name="like[dai]" title="发呆">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">开关</label>
        <div class="layui-input-block">
            <input type="checkbox" name="switch" lay-skin="switch">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男">
            <input type="radio" name="sex" value="女" title="女" checked>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文本域</label>
        <div class="layui-input-block">
            <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    <div id="fenye"></div>
</form>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

<form action="/user/test">
    <input name="id" value="1">
    <input name="id" value="2">
    <input type="submit" value="tijiao">
</form>


<script>
    layui.use('upload', function(){
        var upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/hello/insertreports' //上传接口
            ,accept: 'file'
            ,done: function(res){
                alert(res.data);
                //上传完毕回调
            }
            ,error: function(){
                alert("no");
                //请求异常回调
            }
        });
    });

    layui.use('laypage', function(){
        var laypage = layui.laypage;
        //执行一个laypage实例
        laypage.render({
            elem: 'fenye' //注意，这里的 test1 是 ID，不用加 # 号
            ,count: 100 //数据总数，从服务端得到
            ,limit:20
            ,limits:[10, 20, 30, 40, 50]
        });
    });
</script>


<input class="awesomplete" list="mylist" />
<datalist id="mylist">
    <option>Ada</option>
    <option>Java</option>
    <option>JavaScript</option>
    <option>Brainfuck</option>
    <option>LOLCODE</option>
    <option>Node.js</option>
    <option>Ruby on Rails</option>
</datalist>

</body>
</html>