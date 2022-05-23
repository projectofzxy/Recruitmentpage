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
    <title>招聘方界面</title>
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
                        <a class="name" href="${pageContext.request.contextPath}/login/begin">登录</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="position: relative;width: 620px">
    <table>
        <tr>
            <th>
                <div>
                    <form method="post" action="${pageContext.request.contextPath}/main/gsyannouncement">
                        <textarea class="be-textarea_inner" rows="4" cols="30" name="announcement" maxlength="150" placeholder="编辑公告"></textarea>
                        发布者：<input type="text" name="company">
                        <input class="change-info-btn" type="submit" value="发布公告">
                    </form>
                </div>
            </th>
            <th>
                <div>
                    <form method="post" action="${pageContext.request.contextPath}/main/dorecruitment?username=${username}">
                        <textarea class="be-textarea_inner" rows="4" cols="30" name="recruitment" maxlength="150" placeholder="编辑招聘信息"></textarea>
                        <input class="change-info-btn" type="submit" value="发布招聘信息">
                        <a class="change-info-btn" href="${pageContext.request.contextPath}/main/alldeliveryinformation?username=${username}">刷新投递信息</a>
                    </form>
                </div>
            </th>
        </tr>
    </table>
</div>
<div class="tablesize">
    <h6 align="center">公告栏</h6>
<table class="fl-table">
    <thead>
    <tr>
        <th>发布者</th>
        <th>公告信息</th>
        <th>发布时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="announcement" items="${requestScope.get('announcements')}">
        <tr>
            <td>${announcement.getPublisher()}</td>
            <td>${announcement.getAnnouncement()}</td>
            <td>${announcement.getDate()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>


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
<div class="tablesize">
    <h6 align="center">投递本公司人员名单</h6>
<table class="fl-table">
    <thead>
    <tr>
        <th>投递人</th>
        <th>简历</th>
        <th>投递时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="deliveryInformation" items="${requestScope.get('deliveryInformations')}">
        <tr>
            <td>${deliveryInformation.getHirername()}</td>
            <td>${deliveryInformation.getResume()}</td>
            <td>${deliveryInformation.getDate()}</td>
            <td>
                <a href="${pageContext.request.contextPath}/main/dowload?id=${deliveryInformation.getId()}">下载</a> |
                &nbsp;|&nbsp;
                <a href="${pageContext.request.contextPath}/main/deldeliveryinformation/?id=${deliveryInformation.getId()}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
