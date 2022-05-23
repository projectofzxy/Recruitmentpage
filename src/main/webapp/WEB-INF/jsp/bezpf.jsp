<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/24
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>招聘方注册页面</title>
    <link type="text/css" href="<c:url value="/css/login.css"/>" rel="stylesheet"/>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/login/bezhaoping">
        <div class="main">
            <div class="login-right">
            <div class="form-login">
                <div class="input-box">
                    <div class="item">
                        <div class="status-box">
                            <div>
                                账号名：<input type="text" name="username">
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                密码：<input type="password" name="password">
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                邮箱：<input type="text" name="mail">
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                公司：<input type="text" name="company">
                            </div>
                        </div>
                        <div class="status-box">
                            <div>
                                公司信息：<textarea rows="3" cols="50" name="information"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="btn-box">
                        <input class="btn-login" type="submit" value="申请">
                        <a href="${pageContext.request.contextPath}/login/begin" class="btn-login">返回</a>

                    </div>
                    <span style="color: skyblue;font-weight: bold">${error}</span>
                </div>
            </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
