<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><c:out value="${invoice.symbol}"/></title>
</head>
<body>
<div class="tg-wrap">
    <table style="undefined;table-layout: fixed; width: 989px">
        <colgroup>
            <col style="width: 259px">
            <col style="width: 193px">
            <col style="width: 71px">
            <col style="width: 87px">
            <col style="width: 48px">
            <col style="width: 48px">
            <col style="width: 138px">
            <col style="width: 193px">
        </colgroup>
        <thead>
        <tr>
            <th colspan="7"><br>Invoice number <c:out value="${invoice.symbol}"/><br></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>Sale date:<br/>
                <c:out value="${invoice.saleDate}"/><br>
                <br/>
                Payment date:<br/>
                <c:out value="${invoice.saleDate}"/><br>
            </td>
        </tr>
        <tr>
            <td>
                Seller:<br/>
                <c:out value="${invoice.seller.name}"/> <br/>
                <c:out value="${invoice.seller.street} ${invoice.seller.property}"/> <br/>
                <c:out value="${invoice.seller.zipCode} ${invoice.seller.city}"/> <br/>
                <c:out value="${invoice.seller.nip}"/> <br/>
                <c:out value="${invoice.seller.email}"/> <br/>
            </td>
            <td>
                Buyer:<br/>
                <c:out value="${invoice.buyer.name}"/> <br/>
                <c:out value="${invoice.buyer.street} ${invoice.buyer.property}"/> <br/>
                <c:out value="${invoice.buyer.zipCode} ${invoice.buyer.city}"/> <br/>
                <c:out value="${invoice.buyer.nip}"/> <br/>
                <c:out value="${invoice.buyer.email}"/> <br/>
            </td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="2">Product</td>
            <td>Unit</td>
            <td>Price</td>
            <td>Qty</td>
            <td>VAT</td>
            <td>Net value<br></td>
            <td>Gross value<br></td>
        </tr>
        <tr>
            <c:forEach items="${invoice.invoiceProductList.productList}" var="product">
                <td colspan="2">${product.name}</td>
                <td><c:out value="${product.units}"/><br></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.vatRate}"/></td>
                <td>
                    <fmt:formatNumber value="${product.price * product.quantity}" minFractionDigits="2" maxFractionDigits="2"/>
                    <br>
                </td>
                <td><fmt:formatNumber value="${product.price * product.quantity * (1+product.vatRate * 0.01)}" minFractionDigits="2" maxFractionDigits="2"/></td>
            </c:forEach>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>Total net:</td>
            <td><c:out value="${invoice.netValue}"/></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>Total gross:</td>
            <td><c:out value="${invoice.grossValue}"/></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>Amount paid<br></td>
            <td>${invoice.amountPaid}<br></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>Remaining payment: <br></td>
            <td><c:out value="${invoice.amountToPay}">t<br></td>
        </tr>
        <tr>
            <td colspan="3">Notes:<br>${invoice.notes}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
    <br/>
    <br/>
    <br/>
<p>Options:</p>
<a href="${pageContext.request.contextPath}/contractor/form"> New contractor </a>
<%@ include file="/WEB-INF/jspf/options.jspf" %>
</body>
</html>
