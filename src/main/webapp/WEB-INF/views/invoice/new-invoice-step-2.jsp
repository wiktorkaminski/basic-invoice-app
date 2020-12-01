<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New invoice</title>
</head>
<body>

<form:form modelAttribute="invoiceDto" method="POST" action="/invoice/new-invoice-step-3">

    <form:label path="saleDate">Input date of transaction:</form:label>
    <br/>
    <form:input path="saleDate"/>
    <br/>
    <form:label path="paymentDate">Input payment date:</form:label>
    <br/>
    <form:input path="paymentDate"/><br/>

    Seler:
    <br/>
    <c:out value="${invoiceDto.seller.name}"/> <br/>
    <c:out value="${invoiceDto.seller.street} ${invoiceDto.seller.property}"/> <br/>
    <c:out value="${invoiceDto.seller.zipCode} ${invoiceDto.seller.city}"/> <br/>
    <c:out value="${invoiceDto.seller.nip}"/> <br/>
    <c:out value="${invoiceDto.seller.email}"/> <br/>

    <form:label path="buyer">Buyer:</form:label>
    <br/>
    <form:select path="buyer.id" itemValue="id" itemLabel="label">
        <form:option value="-" label="-- please select --"/>
        <form:options items="${contractorsDtoList}"/>
        <input name="listId" value="${listId}" hidden>
    </form:select>
    <br/>

    <form:label path="amountPaid">Amount paid: </form:label>
    <br/>
    <form:input path="amountPaid"/>
    <br/>
    <form:label path="notes">Notes: </form:label>
    <form:textarea path="notes" rows="4"/>
    <br/>


    <button type="submit">Finalize</button>

</form:form>

</body>
</html>