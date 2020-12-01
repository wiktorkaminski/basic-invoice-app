<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Invoice items</title>
</head>
<body>
<h3>Invoice items</h3>

<form method="GET" action="/invoice/new-invoice-step-1-1">
    <input name="listId" value="${productList.id}" hidden/>
    <button type="submit">Add new item</button>
</form>

<form method="POST" action="/invoice/new-invoice-step-2">
    <input name="listId" value="${productList.id}" hidden/>
    <button type="submit">Item list done</button>
</form>

<table>
    <tr>
        <th>
            Name:
        </th>
        <th>
            Units:
        </th>
        <th>
            Quantity:
        </th>
        <th>
            Price:
        </th>
        <th>
            VAT:
        </th>
        <th>
            Net value:
        </th>
        <th>
            Gross value:
        </th>
    </tr>
    <c:forEach items="${productList.productList}" var="product">
        <tr>
            <td>
                <c:out value="${product.name}"/>
            </td>
            <td>
                <c:out value="${product.units}"/>
            </td>
            <td>
                <c:out value="${product.quantity}"/>
            </td>
            <td>
                <c:out value="${product.price}"/>
            </td>
            <td>
                <c:out value="${product.vatRate}"/>
            </td>
            <td>
                <fmt:formatNumber value="${product.quantity * product.price}" maxFractionDigits="2" minFractionDigits="2"/>
            </td>
            <td>
                <fmt:formatNumber value="${product.quantity * product.price * (1 + (product.vatRate * 0.01))}" maxFractionDigits="2" minFractionDigits="2"/>
            </td>
        </tr>
    </c:forEach>
</table>
</form>


</body>
</html>
