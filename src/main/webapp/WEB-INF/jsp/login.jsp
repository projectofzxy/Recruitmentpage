<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/21
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
    <link type="text/css" href="<c:url value="/css/login.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="main">
    <form method="post" action="${pageContext.request.contextPath}/login/dologin">

        <div class="login-right">
            <div class="form-login">
                <div class="input-box">
                    <div class="item">
                        <div class="status-box">
                            <div>用户名：<input type="text" class="" name="username"></div>
                        </div>
                        <div class="status-box">
                            <div>密码：<input type="password" class="" name="password"></div>
                        </div>
                    </div>
                    <div class="remember">
                        <div class="remember-tool">
                            <div>
                                <a class="forget-password" href="${pageContext.request.contextPath}/login/pwdfindback">找回密码</a>
                                <a class="not-checkout" href="${pageContext.request.contextPath}/login/tobezhaoping">申请招聘方</a>
                            </div>
                        </div>

                    </div>
                    <div class="btn-box">
                        <input class="btn-login" type="submit" value="登录">
                        <a class="btn" href="${pageContext.request.contextPath}/login/creat">注册</a>
                    </div>
                </div>
                <span style="color: #00a7de;font-weight: bold">${error}</span>
            </div>
        </div>
    </form>
</div>
</body>
</html>
