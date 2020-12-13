<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<form:form modelAttribute="invoice" method="POST" action="/invoice/new-invoice-step-3">

    <form:label path="saleDate">Input date of transaction: </form:label>
    <br/>
    <form:input path="saleDate" placeholder="dd/mm/yyyy"/>
    <form:errors path="saleDate" cssStyle="color: red"/>
    <br/>
    <form:label path="paymentDate">Input payment date:</form:label>
    <br/>
    <form:input path="paymentDate" placeholder="dd/mm/yyyy"/>
    <form:errors path="paymentDate" cssStyle="color: red"/>
    <br/>
    <br/>
    Seller:
    <br/>
    <form:hidden path="seller"/>
    <c:out value="${invoice.seller.name}"/> <br/>
    <c:out value="${invoice.seller.street} ${invoice.seller.property}"/> <br/>
    <c:out value="${invoice.seller.zipCode} ${invoice.seller.city}"/> <br/>
    <c:out value="${invoice.seller.nip}"/> <br/>
    <c:out value="${invoice.seller.email}"/> <br/><br/>

    <label for="buyer">Buyer:</label>
    <br/>
    <select name="buyerId" id="buyer">
        <option value="-1">-- please select --</option>
        <c:forEach items="${contractors}" var="contractor">
            <option value="${contractor.id}">${contractor.label}</option>
        </c:forEach>
    </select>
    <c:if test="${not empty buyerErr}">
        <p style="color: red">
        ${buyerErr}</c:if>
        </p>
    <br/><br/>

    <form:label path="amountPaid">Amount paid: </form:label>
    <br/>
    <form:input path="amountPaid"/>
    <form:errors path="amountPaid" cssStyle="color: red"/>
    <br/>
    <form:label path="notes">Notes: </form:label>
    <form:textarea path="notes" rows="4"/>
    <br/>

    <form:hidden path="invoiceProductList"/>
    <button type="submit">Finalize</button>

</form:form>

</body>
<head>
    <title>New invoice</title>
</head>
</html>