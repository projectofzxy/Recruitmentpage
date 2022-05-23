<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/21
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>找回密码页面</title>
    <link type="text/css" href="<c:url value="/css/login.css"/>" rel="stylesheet"/>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/login/pwdfind">
        <div class="main">
            <div class="login-right">
            <div class="form-login">
                <div class="input-box">
                    <div class="item">
                        <div class="status-box">
                            <div>
                                用户名：<input type="text" name="username">
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                邮箱：<input type="text" name="mail">
                            </div>
                        </div>
                    </div>
                    <div class="btn-box">
                        <input type="submit" class="btn-login" name="action" value="发送验证码">
                    </div>
                    <div class="item">
                        <div class="status-box">
                            <div>
                                验证码：<input type="text" name="mail_password">
                            </div>
                        </div>
                        <div class="btn-box">
                            <input type="submit" class="btn-login" name="action" value="找回密码">
                            <a href="${pageContext.request.contextPath}/login/begin" class="btn-login">返回</a>
                        </div>
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
