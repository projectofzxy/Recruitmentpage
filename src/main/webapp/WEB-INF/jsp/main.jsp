<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10079
  Date: 2021/12/21
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link type="text/css" href="<c:url value="/css/main.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="international-header">
    <div class="mini-type">
        <div class="mini-header__content">
            <div class="nav-user-center">
                <div class="user-con">
                    <div class="item">
                        <a class="name" href="${pageContext.request.contextPath}/login/begin">登录</a>
                    </div>
                    <div class="item">
                        <a class="name" href="${pageContext.request.contextPath}/main/allannouncement">刷新公告</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="bak">
    <div class="left">
        <div class="box-title">招聘信息</div>
        <ul>

            <c:forEach var="recruitmentInformation" items="${requestScope.get('recruitmentInformations')}">
                <li>
                    <div class="sub-li">
                        <a href="#" class="job-info">
                            <div class="sub-li-top">
                                <p class="name">${recruitmentInformation.getRecruitment()}</p>
                            </div>
                        </a>
                        <div class="sub-li-bottom">
                            <div class="sub-li-bottom-commany-info">
                                <div>${recruitmentInformation.getHiresname()}</div>||
                                <div>${recruitmentInformation.getTime()}</div>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="right">
        <div class="box-title">公告栏</div>
        <ul>
            <c:forEach var="announcement" items="${requestScope.get('announcements')}">            <li>
                <div class="sub-li">
                    <a href="#" class="job-info">
                        <div class="sub-li-top">
                            <p class="name">${announcement.getAnnouncement()}</p>
                        </div>
                    </a>
                    <div class="sub-li-bottom">
                        <div class="sub-li-bottom-commany-info">
                            <div><td>${announcement.getPublisher()}</td></div>||
                            <div>${announcement.getDate()}</div>
                        </div>
                    </div>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
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
<jsp:include page="recruter.jsp"></jsp:include>
</body>
</html>
