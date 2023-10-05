<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <label for="username">Username <em class="text-warning">(unavailable username: please try again)</em></label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <% String email = request.getParameter("email"); %>
            <input id="email" name="email" class="form-control" type="text" value="<%=email%>">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <% String password = request.getParameter("password"); %>
            <input id="password" name="password" class="form-control" type="password" value="<%=password%>">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <% String cpassword = request.getParameter("confirm_password"); %>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password" value="<%=cpassword%>">        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>

<script>
    alert("Username unavailable.")
</script>
</body>
</html>