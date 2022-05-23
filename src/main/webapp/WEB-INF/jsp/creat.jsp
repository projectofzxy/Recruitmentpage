<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/21
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link type="text/css" href="<c:url value="/css/login.css"/>" rel="stylesheet"/>
</head>
<body>

<div>
    <form method="post" action="${pageContext.request.contextPath}/login/addUser">
        <div class="main">
            <div class="login-right">
            <div class="form-login">
                <div class="input-box">
                    <div class="item">
                        <div class="status-box">
                            <div>
                                <div>用户名：<input type="text" class="" name="username"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>密码：<input type="password" class="" name="password"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>确认密码：<input type="password" class="" name="password1"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>邮件：<input type="text" class="" name="mail"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>姓名：<input type="text" class="" name="name"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>生日：<input type="date" class="" name="birthday"></div>
                            </div>
                        </div>
                    </div>
                    <div>性别：
                        <span>
                                        <input type="radio" name="gender" value="男" checked>男
                                        <input type="radio" name="gender" value="女">女
                                    </span>
                    </div>
                    <div class="btn-box">
                        <input type="submit" class="btn-login" value="注册">
                        <input type="reset" class="btn" value="重置">
                    </div>
                    <span style="color:#ff0000;font-weight: bold">${summary}</span>
                </div>
            </div>
            </div>
        </div>

    </form>
</div>
</body>
</html>
