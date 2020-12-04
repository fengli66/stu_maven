<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fengli
  Date: 2020/11/4
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>修改信息</title>
    <script>
        var image = '';

        function selectImage(file) {
            if (!file.files || !file.files[0]) {
                return;
            }
            var reader = new FileReader();
            reader.onload = function (evt) {
                document.getElementById('imgPhoto').src = evt.target.result;
                image = evt.target.result;
            }
            reader.readAsDataURL(file.files[0]);
        }


    </script>
    <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
    <script>
        $(function () {
            if ($("#sex").val() === '1') {
                $("#sex1").attr('checked', 'checked')
            }else {
                $("#sex2").attr('checked', 'checked')
            }
        });
    </script>
</head>

<body>
<form action="editStudent.do" method="post">
    <table>
        <tr>
            <td>id</td>
            <td><input type="text" id="id" name="id" value="${student.id}" readonly></td>
        </tr>
        <%--  <tr>
              <td>
                  <input type="file" name="photo"
                         onchange="selectImage(this)" id="photo"/>
                  <img width="160px" height="160px" name="imgPhoto" id="imgPhoto"/>
              </td>
          </tr>--%>
        <tr>
            <td>name</td>
            <td><input type="text" id="name" name="name" value="${student.name}"></td>
        </tr>
        <%--   <tr>
               <td>图片</td>
               <td>
                   <input type="file" name="photo" onchange="checkPhoto(this.files[0])" id="p" />
                   <img width="160px" height="160px" name="imgPhoto" id="imgPhoto" src="${this.getServletContext().getRealPath("/files")}+${sessionScope.student.name};" />
               </td>
           </tr>--%>
        <tr>
            <td>sex</td>
            <td>
                <input type="hidden" id="sex" value='${student.sex}'>
                <input type="radio" id="sex1" name="sex" value="1">男
                <input type="radio" id="sex2" name="sex" value="0">女
            </td>
        </tr>
        <tr>
            <td>score</td>
            <td><input type="text" id="score" name="score" value="${student.score}"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
