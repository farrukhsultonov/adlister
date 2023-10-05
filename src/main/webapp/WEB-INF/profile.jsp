<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>

    <p>Here are your ads:</p>

    <c:forEach items="${userAds}" var="ad">
    <div class="card" style="width: 30%;">
        <div class="card-body">
            <h3 class="card-title">${ad.title}</h3>
            <p class="card-text">${ad.description}</p>
            <a href="/ads/edit" class="btn btn-primary">Edit</a>
            <a href="#" class="btn btn-primary">Delete</a>
        </div>
        <hr>
    </div>
    </c:forEach>
</body>
</html>