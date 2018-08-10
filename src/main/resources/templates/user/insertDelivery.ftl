<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>insertDelivery</title>

    <script type="text/javascript" src="/js/jquery/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css">
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<div class="pr pb10 form-search">
<form name="deliverydata" id="deliverydata">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th colspan="4">汇率 </th>
        </tr>
        </thead>
        <tbody>
        <tr >
            <td colspan="4">年份:<input type="text" value="${year}" id="year" name="year"></td>
        </tr>
        <tr>
            <td><input type="text" value="${year}" id="year" name="year"></td>
            <td><input type="text" value="${year}" id="year" name="year"></td>
            <td>warehouseCode</td>
            <td>createTime</td>
        </tr>
        <tr>
            <td><input type="text" placeholder="orderCode" id="orderCode" name="orderCode"></td>
            <td><input type="text" placeholder="referenceCode" id="referenceCode" name="referenceCode"></td>
            <td><input type="text" placeholder="warehouseCode" id="warehouseCode" name="warehouseCode"></td>
            <td><input type="text" id="beginTimeHour" size="18" name="beginTimeHour"
                                   onFocus="WdatePicker({onpicking:function(dp){resetDate('endTimeHour',30,dp.cal.getNewDateStr(),'yyyy-MM-dd hh:mm');},isShowClear:false,maxDate:'%y-%M-%d %H:%m:',dateFmt:'yyyy-MM-dd HH:mm',minDate:''});" class="Wdate gps-input w130" value="" style="width: 160px"/></td>
        </tr>
        </tbody>
    </table>
    <table class="layui-table" id="skudata">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th colspan="4">sku数据</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>sku</td>
            <td>quantity</td>
            <td>quality</td>
            <td>操作</td>
        </tr>
        <tr>
            <td><input type="text" placeholder="sku" id="sku" name="sku"></td>
            <td><input type="number" placeholder="0" id="quantity" name="quantity"></td>
            <td><input type="text" placeholder="Y" id="quality" name="quality"></td>
            <td><input type="button" class="layui-btn" id="deletecol" value="删除行" onclick='{if(confirm("确定要删除吗?")) {deleteCurrentRow(this); }else {}}'/></td>
           </tr>
        </tbody>
    </table>
    <input class="layui-btn" id="insertcol" type="button" value="新增一行"/>

    <br><br>
    <input class="layui-btn layui-btn-danger" onclick="doinsert()" value="确认提交">

</form>
</div>
</body>
</html>
<script>

    $("#insertcol").bind("click",function(){
    // function insertcol(){
        var trHTML = "<tr>\n" +
                "            <td><input type=\"text\" placeholder=\"sku\" id=\"sku\" name=\"sku\"></td>\n" +
                "            <td><input type=\"number\" placeholder=\"0\" id=\"quantity\" name=\"quantity\"></td>\n" +
                "            <td><input type=\"text\" placeholder=\"Y\" id=\"quality\" name=\"quality\"></td>\n" +
                "            <td><input type=\"button\" class=\"layui-btn\" id=\"deletecol\" value=\"删除行\" onclick='{if(confirm(\"确定要删除吗?\")) {deleteCurrentRow(this); }else {}}'/></td>\n" +
                "           </tr>";
        $("#skudata").append(trHTML);
    })



    function deleteCurrentRow(obj){

        var tr=obj.parentNode.parentNode;
        var tbody=tr.parentNode;
        tbody.removeChild(tr);
        //只剩行首时删除表格
        // if(tbody.rows.length==1) {
        //     tbody.parentNode.removeChild(tbody);
        // }
    }

    function aa() {
        alert("11");
    }

    function doinsert(){
        $.ajax({
            url:"/fourpx/dokeyDelivery",
            type:'get',
            dataType:'json',
            data:$("#deliverydata").serialize(),
            success:function(json){
                if (json.data==1){
                    alert("修改成功");
                } else if(json.data==0) {
                    alert("当月已设定,不能重新设定");
                }
            }
        });
    }
</script>