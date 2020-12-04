<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>文件上传</title>
</head>
<body>
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
<form action="upload" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>
                姓名：
            </td>
            <td>
                <input type="text" name="name" id="name"/>
            </td>
        </tr>
        <tr>
            <td>
                照片：
            </td>
            <td>
                <input type="file" name="photo"
                       onchange="selectImage(this)" id="photo"/>
                <img width="160px" height="160px" name="imgPhoto" id="imgPhoto"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="btnSubmit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
