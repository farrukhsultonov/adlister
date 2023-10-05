<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Please fill in your info</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <% String uname = request.getParameter("username"); %>
            <input id="username" name="username" class="form-control" type="text" value="<%=uname%>">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <% String email = request.getParameter("email"); %>
            <input id="email" name="email" class="form-control" type="text" value="<%=email%>">
        </div>
        <div class="form-group">
            <label for="password">Password <em class="text-warning">(please enter/confirm your password)</em></label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>

<script>
    alert("Please enter and/or confirm your password.")
</script>
</body>
</html>