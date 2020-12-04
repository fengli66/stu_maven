<%--
  Created by IntelliJ IDEA.
  User: fengli
  Date: 2020/11/6
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>使用Ajax实现自动提示功能</title>
        </head>
        <style>
            .suggest_link {
                background-color: pink;
                padding: 2px 6px;
            }
            
            .suggest_link_over {
                background-color: whitesmoke;
                color: #3c7a4e;
                padding: 2px 6px;
            }
            
            #suggest {
                position: absolute;
                background-color: lightgray;
                text-align: left;
                border: 1px solid #000000;
                width: 200px;
                display: none;
            }
        </style>

        <script type="text/javascript">
            String.prototype.trim = function() {
                var m = this.match(/^\s*(\S+(\s+\S+)*)\s*$/);
                return (m == null) ? "" : m[1];
            }

            function searchSuggest() {
                var txtSearch = document.getElementById("txtSearch").value;
                doAjax("SearchSuggest.do?txtSearch=" + txtSearch + "&auto=auto");
            }

            var xmlhttp;

            function doAjax(url) {
                try {
                    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP")
                    } catch (e) {
                        try {
                            xmlhttp = new XMLHttpRequest();
                            if (xmlhttp.overrideMimeType) {
                                xmlhttp.overrideMimeType("text/html");
                            }
                        } catch (e) {

                        }
                    }
                }
                xmlhttp.onreadystatechange = processReuqest;
                xmlhttp.open("post", url, true);
                //如果以post方式请求，必须要添加
                xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlhttp.send(null);
            }

            function setSearch(select) {
                document.getElementById("txtSearch").value = select;
                //    隐藏内容
                document.getElementById("suggest").style.display = "none";
            }

            //鼠标移入
            function suggestOver(obj) {
                obj.className = "suggest_link_over";

            }

            //鼠标移出
            function suggestOut(obj) {
                obj.className = "suggest_link";
            }

            function processReuqest() {
                if (xmlhttp.readyState === 4) {
                    if (xmlhttp.status === 200) {
                        var sobj = document.getElementById("suggest");
                        sobj.innerHTML = "";
                        var str = xmlhttp.responseText.split("-");
                        var suggest = "";
                        if (str.length > 0 && str[0].length > 0) {
                            for (i = 0; i < str.length; i++) {
                                suggest += "<div onmouseover='javascript:suggestOver(this);'";
                                suggest += " onmouseout='javascript:suggestOut(this);'";
                                suggest += " onclick='javascript:setSearch(this.innerHTML);'";
                                suggest += " class='suggest_link'>" + str[i] + "</div>";
                            }
                            sobj.innerHTML = suggest;
                            document.getElementById("suggest").style.display = "block";
                        } else {
                            document.getElementById("suggest").style.display = "none";
                        }
                    }
                }
            }
        </script>

        <body>
            <h1>使用Ajax实现自动提示功能</h1>
            <h3>
                Ajax实现搜索提示
            </h3>
            <div style="width: 500px">
                <form action="" id="formSearch">
                    <input type="text" id="txtSearch" name="txtSearch" onkeyup="searchSuggest()" autocomplete="off" />
                    <input type="submit" id="cmdSearch" name="cmdSearch" value="搜索" /> <br>
                    <div id="suggest" style="width: 200px"></div>
                </form>
            </div>
        </body>

        </html>