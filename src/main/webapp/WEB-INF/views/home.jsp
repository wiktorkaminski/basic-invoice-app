<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h2>
   Hello, what do you want to do today?
</h2>
<form method="GET" action="${pageContext.request.contextPath}/invoice/list">
   <button type="submit">Invoices</button>
</form>
<form method="GET" action="${pageContext.request.contextPath}/contractor/list">
   <button type="submit">Contractors</button>
</form>
<br/>
<br/>
<form method="POST" action="/logout">
   <input type="submit" value="Logout"/>
</form>
</body>
</html>
