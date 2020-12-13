<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><c:out value="${contractor.shortName}"/></title>
</head>
<body>
<h3><c:out value="${contractor.name} detailes:"/></h3> <br/>
Name: <c:out value="${contractor.name}"/> <br/>
Short name: <c:out value="${contractor.shortName}"/> <br/>
Address: <c:out value="${contractor.address.fullAddress}"/> <br/>
NIP: <c:out value="${contractor.nip}"/> <br/>
REGON: <c:out value="${contractor.regon}"/> <br/>
E-mail: <c:out value="${contractor.email}"/> <br/>
Phone: <c:out value="${contractor.phone}"/> <br/>
website: <c:out value="${contractor.website}"/> <br/>
<br/>
Actions
<br/>
<form method="post" action="/contractor/update">
    <input name="id" value="${contractor.id}" hidden/>
    <button type="submit">Modify</button>
</form>
<form method="post" action="/contractor/delete">
    <input name="id" value="${contractor.id}" hidden/>
    <button type="submit">Delete</button>
</form>

<br/>
<p>Options:</p>
<a href="${pageContext.request.contextPath}/contractor/list"> Back </a>
<a href="${pageContext.request.contextPath}/dashboard"> Dashboard </a>

</body>

</html>
