<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New invoice</title>
</head>
<body>

<form:form modelAttribute="invoiceDto">
    Seler:<br/>
    <c:out value="${invoiceDto.seller.name}"/> <br/>
    <c:out value="${invoiceDto.seller.street} ${invoiceDto.seller.property}"/> <br/>
    <c:out value="${invoiceDto.seller.zipCode} ${invoiceDto.seller.city}"/> <br/>
    <c:out value="${invoiceDto.seller.nip}"/> <br/>
    <c:out value="${invoiceDto.seller.email}"/> <br/>

    Buyer:<br/>
    <form:select path="buyer">
        <form:option value="-" label="-- please select --"/>
        <form:options items="${contractorsDtoList}"/>
    </form:select>
</form:form>

</body>
</html>
