<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Invoices</title>
</head>
<body>
<table>
    <tr>
        <th>
            Symbol
        </th>
        <th>
            Contractor
        </th>
        <th>
            Date
        </th>
        <th>
            Net
        </th>
        <th>
            Gross
        </th>
    </tr>
    <c:forEach items="${invoices}" var="invoice">
        <tr>
            <td>
                <c:out value="${invoice.symbol}"/>
            </td>
            <td>
                <c:out value="${invoice.buyer.name}"/>
            </td>
            <td>
                <c:out value="${invoice.saleDate}"/>
            </td>
            <td>
                <fmt:formatNumber value="${invoice.grossValue}" minFractionDigits="2" maxFractionDigits="2"/>
            </td>
            <td>
                <fmt:formatNumber value="${invoice.netValue}" minFractionDigits="2" maxFractionDigits="2"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
