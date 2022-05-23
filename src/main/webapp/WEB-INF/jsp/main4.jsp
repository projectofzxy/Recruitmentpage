<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/22
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <link type="text/css" href="<c:url value="/css/main.css"/>" rel="stylesheet"/>

</head>
<body>

<div class="international-header">
    <div class="mini-type">
        <div class="mini-header__content">
            <div class="nav-user-center">
                <div class="user-con">
                    <div class="item">
                        <a class="name" href="${pageContext.request.contextPath}/main/toperson?username=${username}">个人中心</a>
                    </div>
                    <div class="item">
                        <a class="name" href="${pageContext.request.contextPath}/main/creatgly">创建管理员</a>
                    </div>
                    <div class="item">
                        <a class="name" href="${pageContext.request.contextPath}/login/begin">登录</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="position: relative;width: 620px">
    <div class="texsize">
        <form method="post" action="${pageContext.request.contextPath}/main/glyannouncement">
            <textarea class="be-textarea_inner" rows="4" cols="30" name="announcement" maxlength="150" placeholder="编辑公告"></textarea>
            <input type="submit" class="change-info-btn" value="发布公告">
        </form>
    </div>
    <div class="texsize">
        <a class="change-info-btn" href="${pageContext.request.contextPath}/main/main4">刷新</a>
    </div>

</div>

<jsp:include page="announce.jsp"></jsp:include>
<div class="tablesize">
    <h6 align="center">公司申请栏</h6>
<table class="fl-table">
    <thead>
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>邮箱</th>
        <th>公司名</th>
        <th>公司信息</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="recruiter" items="${requestScope.get('recruiters')}">
        <tr>
            <td>${recruiter.getUsername()}</td>
            <td>${recruiter.getPassword()}</td>
            <td>${recruiter.getMail()}</td>
            <td>${recruiter.getCompany()}</td>
            <td>${recruiter.getInformation()}</td>
            <td>
                <a href="${pageContext.request.contextPath}/main/passrecurit?id=${recruiter.getId()}">通过</a> |
                &nbsp;|&nbsp;
                <a href="${pageContext.request.contextPath}/main/delrecurit/${recruiter.getId()}">拒绝</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<jsp:include page="recruter.jsp"></jsp:include>
</body>
</html>
