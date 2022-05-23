<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/21
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>公告栏</title>
</head>
<body>
<div class="gonggaolan">
<div class="tablesize">
    <h6 align="center">公告栏</h6>
<table class="fl-table">
    <thead>
    <tr>
        <th>发布者</th>
        <th>公告信息</th>
        <th>发布时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="announcement" items="${requestScope.get('announcements')}">
        <tr>
            <td>${announcement.getPublisher()}</td>
            <td>${announcement.getAnnouncement()}</td>
            <td>${announcement.getDate()}</td>
            <td>
                <a href="${pageContext.request.contextPath}/main/delannouncement/${announcement.getId()}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</div>
</body>
</html>
