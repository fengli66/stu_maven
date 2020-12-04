<%--
  Created by IntelliJ IDEA.
  User: fengli
  Date: 2020/11/4
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加表单</title>
</head>
<style>
    table td {
        padding: 10px 30px;
        border-bottom: 1px solid #999;
        border-right: 1px solid #999;
    }
</style>
<body>
<form action="addStudent.do" method="post" >
    <table>
        <tr>
            <td>学号</td>
            <td><input type="text" id="id" name="id"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" id="sex" name="sex" value="1" checked>男
                <input type="radio" name="sex" value="0">女
            </td>
        </tr>
        <tr>
            <td>分数</td>
            <td><input type="text" id="score" name="score"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
