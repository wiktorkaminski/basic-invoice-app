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
            Modify
        </th>
        <th>
            Quick invoice
        </th>
    </tr>
    <c:forEach items="${contractors}" var="contractorDto">
        <tr>
            <td>
                <c:out value="${contractorDto.name}"/>
            </td>
            <td>
                <c:out value="${contractorDto.shortName}"/>
            </td>
            <td>
                <c:out value="${contractorDto.city}"/>
            </td>
            <td>
                <c:out value="${contractorDto.nip}"/>
            </td>
            <td>
                <c:out value="${contractorDto.regon}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
