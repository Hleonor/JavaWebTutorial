<%--
  Created by IntelliJ IDEA.
  User: Hleonor
  Date: 2023-01-16
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>登录</h1>

    <div style="text-align: center">
        <%--这里表单表示的意思是：以post方式提交，提交到login请求--%>
        <form action="${pageContext.request.contextPath}/login" method="post">
            用户名：<input type="text" name="username"> <br>
            密码：<input type="password" name="password"> <br>
            爱好：
            <input type="checkbox" name="hobby" value="PS5">PS5
            <input type="checkbox" name="hobby" value="吉他">吉他
            <input type="checkbox" name="hobby" value="跑步">跑步
            <input type="checkbox" name="hobby" value="唱歌">唱歌
            <br>

            <input type="submit">
        </form>
    </div>
</body>
</html>
