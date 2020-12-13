<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Bir form</title>
</head>
<body>
<form:form modelAttribute="nip" method="POST" action="/contractor/bir/search">
    <form:label path="nip">Search by NIP</form:label>
    <br/>
    <form:input path="nip" placeholder="Type in correct nip number"/>
    <form:errors path="nip" cssStyle="color: red"/>
    <input type="submit" value="Search"/>
</form:form>
<form method="GET" action="/contractor/form">
    <input type="submit" value="Cancel">
</form>
</body>
</html>
