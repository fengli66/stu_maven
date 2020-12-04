<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: fengli
Date: 2020/11/4
Time: 16:54
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>学生信息</title>
</head>
<style>
    table td {
        padding: 10px 30px;
        border-bottom: 1px solid #999;
        border-right: 1px solid #999;
    }
    .page-spliter {
        /*margin-left: 500px;*/
        width: 600px;
        height: 30px;
        background-color: #999999;
        text-align: center;
        font-size: 14px;
        padding-top: 20px;
    }

    .page-spliter * {
        margin: 0 5px;
    }

    .page-spliter .current {
        font-weight: bold;
        border-bottom: 1px solid #000;
    }

</style>

<body>
<div>
    <table border="1px" style="">
        <tr id="list">
            <td id="id">id</td>
            <td>image</td>
            <td>name</td>
            <td>sex</td>
            <td>score</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>
                        ${student.id}
                </td>
                 <td>
                        ${student.image}
                </td>

                <td>
                        ${student.name}
                </td>
                <td>
                        ${student.sex==1?"男":"女"}
                </td>
                <td>
                        ${student.score}
                </td>
                <td>
                    <a href="findByid.do?code=${student.id}">修改</a><br/>
                    <a href="delStudentInfo.do?ids=${student.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="addlist.jsp">添加学生信息</a></td>
        </tr>
    </table>
    <c:if test="${pb!=null}">
        <div class="page-spliter">
            <a href="list?pageIndex=1">首页</a>
            <c:forEach var="i" begin="1" end="${pb.pageCount }" step="1">
                <c:if test="${i==pb.pageIndex }">
                    <span class="current">${i }</span>
                </c:if>
                <c:if test="${not (i==pb.pageIndex) }">
                    <a href="list?pageIndex=${i }">${i }</a>
                </c:if>
            </c:forEach>
            <a href="list?pageIndex=${pb.pageCount }">尾页</a>
        </div>
    </c:if>
</div>
</body>
</html>