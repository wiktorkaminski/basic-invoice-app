<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Basic Invoice App</title>
</head>
<body>
<h3>Sign in</h3>
<p>If you want to sign up click
<a href="${pageContext.request.contextPath}/register">here</a>
</p>

<form method="POST" action="login" id="loginForm">
    <label for="username">E-mail: </label>
    <input type=text id="username" name="username"/> <br/>

    <label for="password">Password: </label>
    <input type="password" name="password" id="password"> <br/>

    <input type="submit" value="Sign in"/>
</form>

</body>
</html>
