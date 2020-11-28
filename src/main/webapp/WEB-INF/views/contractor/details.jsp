<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><c:out value="${contractorDto.shortName}"/></title>
</head>
<body>
<h3><c:out value="${contractorDto.name} detailes:"/></h3> <br/>
Name: <c:out value="${contractorDto.name}"/> <br/>
Short name: <c:out value="${contractorDto.shortName}"/> <br/>
Address: <c:out value="${contractorDto.fullAddress}"/> <br/>
NIP: <c:out value="${contractorDto.nip}"/> <br/>
REGON: <c:out value="${contractorDto.regon}"/> <br/>
E-mail: <c:out value="${contractorDto.email}"/> <br/>
Phone: <c:out value="${contractorDto.phone}"/> <br/>
website: <c:out value="${contractorDto.website}"/> <br/>
<br/>
Actions
<br/>
<form method="post" action="/contractor/update">
    <input name="id" value="${contractorDto.id}" hidden/>
    <button type="submit">Modify</button>
</form>
<form method="post" action="/contractor/delete">
    <input name="id" value="${contractorDto.id}" hidden/>
    <button type="submit">Delete</button>
</form>
</body>
</html>
