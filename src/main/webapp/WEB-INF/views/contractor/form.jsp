
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Contractor form</title>
    <style>
        a {
            text-decoration: none;
            color: blue;
        }
        a:visited {
            text-decoration: none;
            color: blue;
        }
    </style>

</head>
<body>

<form:form modelAttribute="contractor" method="POST" action="/contractor/form">
    <form:hidden path="id"/>
    <h3>New contractor form</h3>
    Click
    <a href="${pageContext.request.contextPath}/contractor/bir/search">here</a>
    to search by NIP in GUS
    <br/>
    <br/>
    <form:label path="name">Name: </form:label>
    <form:input path="name" size="100"/>
    <br/>
    <form:label path="shortName">Shortened name: </form:label>
    <form:input path="shortName"/>
    <br/>
    Address
    <form:label path="address.street">Street: </form:label>
    <form:input path="address.street"/>
    <form:label path="address.property" >Property: </form:label>
    <form:input path="address.property"/>
    <br/>
    <form:label path="address.zipCode" >ZIP Code: </form:label>
    <form:input path="address.zipCode"/>
    <form:label path="address.city" >City: </form:label>
    <form:input path="address.city"/>
    <br/>
    <form:label path="address.country" >Country: </form:label>
    <form:input path="address.country"/>
    <br/>
    Registry data
    <br/>
    <form:label path="nip" >NIP: </form:label>
    <form:input path="nip"/>
    <form:errors path="nip" cssStyle="color: red"/>
    <form:label path="regon" >REGON: </form:label>
    <form:input path="regon"/>
    <form:errors path="regon" cssStyle="color: red"/>
    <br/>
    Contacts
    <br/>
    <form:label path="phone" >Phone number: </form:label>
    <form:input path="phone"/>
    <form:label path="email" >e-mail: </form:label>
    <form:input path="email"/>
    <form:errors path="email" cssStyle="color: red"/>
    <form:label path="website" >WWW: </form:label>
    <form:input path="website"/>
    <form:errors path="website" cssStyle="color: red"/>

    <br/>
    <button type="submit">Save</button>
</form:form>
<form method="GET" action="/contractor/list">
    <input type="submit" value="Cancel">
</form>
</body>
</html>
