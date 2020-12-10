<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Register</title>
</head>
<body>
<h3>Register form - type in user and company data</h3>
<c:if test="${not empty userExistsErr}">
    <p style="color: red">
        <c:out value="${userExistsErr}"/>
    </p>
</c:if>
<form:form modelAttribute="registrationForm" action="/register" method="POST">
    <form:label path="username">Email: </form:label>
    <form:input path="username"/>
    <br/>
    <form:label path="firstName">First name: </form:label>
    <form:input path="firstName"/>
    <br/>
    <form:label path="lastName">Last name: </form:label>
    <form:input path="lastName"/>
    <br/>
    <form:label path="password">Password: </form:label>
    <form:password path="password"/>
    <br/><br/>
    <form:label path="companyName">Company name: </form:label>
    <form:input path="companyName"/>
    <br/>
    <form:label path="shortName">Shortened company name: </form:label>
    <form:input path="shortName"/>
    <br/>
    <br/>
    <form:label path="street">Street: </form:label>
    <form:input path="street"/>
    <form:label path="property">Property number: </form:label>
    <form:input path="property"/>
    <br/>
    <form:label path="zipCode">Zip code: </form:label>
    <form:input path="zipCode"/>
    <form:label path="city">City: </form:label>
    <form:input path="city"/>
    <br/>
    <form:label path="country">Country: </form:label>
    <form:input path="country"/>
    <br/>
    <form:label path="nip">NIP: </form:label>
    <form:input path="nip"/>
    <form:label path="regon">REGON: </form:label>
    <form:input path="regon"/>
    <br/>
    <form:label path="phone">phone: </form:label>
    <form:input path="phone"/>
    <br/>
    <form:label path="email">Main e-mail (optional): </form:label>
    <form:input path="email" />
    <br/>
    <form:label path="website">Website (optional): </form:label>
    <form:input path="website"/>
    <br/>
    <input type="submit" value="Sign up">
</form:form>

</body>
</html>
