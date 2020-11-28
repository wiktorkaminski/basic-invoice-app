<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Confirmation</title>
</head>
<body>
<h3>
    <c:out value="Are you sure you want to delete ${contractorName}?"/>
</h3>
<form method="POST" action="/contractor/delete-confirmed">
    <input name="id" value="${id}" hidden>
    <button>Yes, delete!</button>
</form>
<form method="GET" action="/contractor/list">
    <button>No</button>
</form>
</body>
</html>
