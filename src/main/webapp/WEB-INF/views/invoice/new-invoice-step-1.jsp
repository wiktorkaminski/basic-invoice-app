<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Invoice item adding</title>
</head>
<body>
Type in new invoice item:
<form:form modelAttribute="invoiceProduct" method="POST" action="/invoice/new-invoice-step-1-2">
    <form:label path="name">Product/service name</form:label>
    <form:input path="name"/>
    <br/>
    <form:label path="units">Units: </form:label>
    <form:select path="units" items="${units}" multiple="false"/>
    <form:label path="quantity">Quantity: </form:label>
    <form:input path="quantity"/>
    <form:label path="price">Price: </form:label>
    <form:input path="price"/>
    <form:label path="vatRate">VAT: </form:label>
    <form:select path="vatRate" items="${vatRate}" multiple="false"/>
    <br/>
    <input name="listId" value="${listId}" hidden/>
    <button type="submit">Add</button>
</form:form>
</body>
</html>