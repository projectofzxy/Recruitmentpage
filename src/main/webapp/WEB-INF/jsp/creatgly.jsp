<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/23
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建管理员</title>
    <link type="text/css" href="<c:url value="/css/login.css"/>" rel="stylesheet"/>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/main/addgly" >
        <div class="main">
            <div class="login-right">
            <div class="form-login">
                <div class="input-box">
                    <div class="item">
                        <div class="status-box">
                            <div>
                                <div>用户名：<input type="text" name="username"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>密码：<input type="password" name="password"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>确认密码：<input type="password" name="password1"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>邮件：<input type="text" name="mail"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>姓名：<input type="text" name="name"></div>
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                <div>生日：<input type="date" name="birthday"></div>
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
                        <input type="submit" class="btn-login" value="创建">
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
