<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h3>Register form - type in user and company data</h3>
<form:form modelAttribute="registrationForm" action="/register" method="POST">
    <form:label path="username">Email: </form:label>
    <form:input path="username"/>
    <br/>
    <form:label path="firstName">First name: </form:label>
    <form:input path="firstName"/>
    <br/>
    <form:label path="lastName">Last name: </form:label>
    <form:input path="lastName"/>
    <br/>
    <form:label path="password">Password: </form:label>
    <form:password path="password"/>
    <input type="submit" value="Sign up">
</form:form>

</body>
</html>
