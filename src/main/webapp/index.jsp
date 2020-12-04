<%--
  Created by IntelliJ IDEA.
  User: fengli
  Date: 2020/11/4
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>学生信息系统</title>
</head>
<script src="js/jquery-1.12.4.js" type="text/javascript"/>
<script>
    $(function () {
        $("#name").blur(function () {
            $("#msg").html("");
            var name = this.value;
            if (name == null || name === "") {
                $("#msg").html("用户名不能为空！");
            } else {
                $.post("loginform.do" + "username=" + name, callBack);
                //响应成功时的回调函数
                function callBack(data) {
                    if (data === "true") {
                        $("#msg").html("用户名已被使用！");
                    } else {
                        $("#msg").html("用户名可以使用！");
                    }
                }
            }
        });
    });
</script>

<body>
<%--Ajax验证用户名测试--%>
<form action="" method="post" id="form1">
    <br> 用户名: <input type="text" name="name" id="name" <%--onblur="checkUserExists()"--%>>
    <div id="msg" style="display: inline"></div>
</form>
</body>

</html>