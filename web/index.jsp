<%--
  Created by IntelliJ IDEA.
  User: coolerLin
  Date: 2020/8/22
  Time: 7:59 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市级联查询</title>
    <style type="text/css">
      #main_div{
        align-self: center;
        background-color: cadetblue;
      }
    </style>
    <script src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      $(function () {
        //页面加载完直接加载数据
        loadDate();
        //绑定事件
/*        $("#btnload").on("click",function () {
          loadDate();
        })*/
        //给省份的下拉列表绑定一个事件
        $("#province").on("change",function () {
            //获取选中对象的value
            var provinceId = $("#province>option:selected").val();
          //再请求一次.post(URL,data,function(data,status,xhr),dataType)
          queryCityByid(provinceId);
        })
      })
      //抽象出方法，传入参数
      function queryCityByid(provinceId) {
        $.post("queryCity", {provinceId: provinceId}, function (data) {
          $("#city").empty();
          $.each(data, function (index, element) {
            //增加城市选项
            $("#city").append("<option value='" + element.cityId + "'>" + element.cityName + "</option>");
          })

        }, "json")
      }
      //抽象方法，加载数据
      function loadDate() {
        //做ajax请求
        $.ajax(
                {
                  url: "queryProvince",
                  dataType: "json",
                  success: function (data) {
                    //删除旧数据
                    $("#province").empty();
                    $("#city").empty();
                    // [{"provinceId":1,"provinceName":"河北","abbreviation":"冀","mainCity":"石家庄"}.....]是一个json数据
                    $.each(data, function (index, element) {
                      //增加省份选项
                      $("#province").append("<option value='" + element.provinceId + "'>" + element.provinceName + "</option>")
                    })
                    //设置默认值
                    queryCityByid(1);
                  },
                }
        )
      }
    </script>
  </head>
  <body>
  <div id="main_div"  align="center">
    <table border="1">
      <tr>
        <td>省份：</td>
        <td>
          <select id="province">
            <option value="0">请选择。。。</option>
          </select>
          <input type="button" value="加载数据" id="btnload">
        </td>
      </tr>
      <tr>
        <td>城市：</td>
        <td>
          <select id="city">
            <option value="0">请选择。。。</option>
          </select>
        </td>
      </tr>
    </table>
  </div>
  </body>
</html>
