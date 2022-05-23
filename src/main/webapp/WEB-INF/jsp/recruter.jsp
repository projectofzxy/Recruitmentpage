<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/21
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="tablesize">
    <h6 align="center">招聘信息栏</h6>
<table class="fl-table">
    <thead>
    <tr>
        <th>招聘者</th>
        <th>招聘信息</th>
        <th>发布时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="recruitmentInformation" items="${requestScope.get('recruitmentInformations')}">
        <tr>
            <td>${recruitmentInformation.getHiresname()}</td>
            <td>${recruitmentInformation.getRecruitment()}</td>
            <td>${recruitmentInformation.getTime()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
