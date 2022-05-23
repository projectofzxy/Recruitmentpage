<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/22
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link type="text/css" href="<c:url value="/css/login.css"/>" rel="stylesheet"/>

</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/main/tochangeUser">
        <div class="main">
            <div class="login-right">
            <div class="form-login">
                <div class="input-box">
                    <div class="item">
                        <div class="status-box">
                            <div>
                                邮箱：<input type="text" name="mail" value="${user.mail}">
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                姓名：<input type="text" name="name" value="${user.name}">
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                生日：<input type="date" name="birthday" value="${user.birthday}">
                            </div>
                        </div>
                    </div>
                    <div><span>性别：
                <input type="radio" name="gender" value="男" checked>男
                <input type="radio" name="gender" value="女">女</span>
                    </div>
                    <input type="hidden" name="username" value="${user.username}">
                    <div class="btn-box">
                        <input type="submit" class="btn-login" value="修改">
                    </div>
                    <span style="color: skyblue;font-weight: bold">${information}</span>
                </div>
            </div>
            </div>
        </div>

    </form>
</div>
</body>
</html>
