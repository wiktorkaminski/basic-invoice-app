<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contractor List</title>
</head>
<body>
<table>
    <tr>
        <th>
            Name
        </th>
        <th>
            Short name
        </th>
        <th>
            City
        </th>
        <th>
            NIP
        </th>
        <th>
            REGON
        </th>
        <th>
            Details
        </th>
        <th>
            Quick invoice
        </th>
    </tr>
    <c:forEach items="${contractors}" var="contractor">
        <tr>
            <td>
                <c:out value="${contractor.name}"/>
            </td>
            <td>
                <c:out value="${contractor.shortName}"/>
            </td>
            <td>
                <c:out value="${contractor.address.city}"/>
            </td>
            <td>
                <c:out value="${contractor.nip}"/>
            </td>
            <td>
                <c:out value="${contractor.regon}"/>
            </td>
            <td>
                <form method="POST" action="/contractor/show-details">
                    <input name="id" value="${contractor.id}" hidden>
                    <button type="submit">View</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<p>Options:</p>
<a href="${pageContext.request.contextPath}/dashboard"> >Dashboard< </a>
<a href="${pageContext.request.contextPath}/invoice/new-invoice-step-1-1"> >New invoice< </a>
<br/>
</body>
</html>
