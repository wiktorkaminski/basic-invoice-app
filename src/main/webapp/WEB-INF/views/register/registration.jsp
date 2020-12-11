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
    <form:errors path="username" cssStyle="color: red"/>
    <br/>
    <form:label path="firstName">First name: </form:label>
    <form:input path="firstName"/>
    <form:errors path="firstName" cssStyle="color: red"/>
    <br/>
    <form:label path="lastName">Last name: </form:label>
    <form:input path="lastName"/>
    <form:errors path="lastName" cssStyle="color: red"/>
    <br/>
    <form:label path="password">Password: </form:label>
    <form:password path="password"/>
    <form:errors path="password" cssStyle="color: red"/>
    <br/><br/>
    <form:label path="companyName">Company name: </form:label>
    <form:input path="companyName"/>
    <form:errors path="companyName" cssStyle="color: red"/>
    <br/>
    <form:label path="shortName">Shortened company name: </form:label>
    <form:input path="shortName"/>
    <form:errors path="shortName" cssStyle="color: red"/>
    <br/>
    <br/>
    <form:label path="street">Street: </form:label>
    <form:input path="street" />
    <form:errors path="street" cssStyle="color: red"/>
    <form:label path="property">Property number: </form:label>
    <form:input path="property"/>
    <form:errors path="property" cssStyle="color: red"/>
    <br/>
    <form:label path="zipCode">Zip code: </form:label>
    <form:input path="zipCode"/>
    <form:errors path="zipCode" cssStyle="color: red"/>
    <form:label path="city">City: </form:label>
    <form:input path="city"/>
    <form:errors path="city" cssStyle="color: red"/>
    <br/>
    <form:label path="country">Country: </form:label>
    <form:input path="country"/>
    <br/>
    <form:label path="nip">NIP: </form:label>
    <form:input path="nip"/>
    <form:errors path="nip" cssStyle="color: red"/>

    <form:label path="regon">REGON: </form:label>
    <form:input path="regon"/>
    <form:errors path="regon" cssStyle="color: red"/>
    <br/>
    <form:label path="phone">Phone (optional): </form:label>
    <form:input path="phone"/>
    <br/>
    <form:label path="email">Company e-mail (optional): </form:label>
    <form:input path="email" />
    <form:errors path="email" cssStyle="color: red"/>
    <br/>
    <form:label path="website">Website (optional): </form:label>
    <form:input path="website"/>
    <form:errors path="website" cssStyle="color: red"/>
    <br/>
    <input type="submit" value="Sign up">
</form:form>

</body>
</html>
