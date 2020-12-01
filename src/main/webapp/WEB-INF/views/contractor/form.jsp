
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Contractor form</title>
</head>
<body>
<form:form modelAttribute="contractor" method="POST" action="/contractor/form">
    <form:hidden path="id"/>
    Contractor
    <br/>
    <form:label path="name">Name: </form:label>
    <form:input path="name"/>
    <br/>
    <form:label path="shortName">Shortened name: </form:label>
    <form:input path="shortName"/>
    <br/>
    Address
    <form:label path="address.street">Street: </form:label>
    <form:input path="address.street"/>
    <form:label path="address.property" >Property: </form:label>
    <form:input path="address.property"/>
    <form:label path="address.zipCode" >ZIP Code: </form:label>
    <form:input path="address.zipCode"/>
    <form:label path="address.city" >City: </form:label>
    <form:input path="address.city"/>
    <form:label path="address.country" >Country: </form:label>
    <form:input path="address.country"/>
    <br/>
    Registry data
    <br/>
    <form:label path="nip" >NIP: </form:label>
    <form:input path="nip"/>
    <form:label path="regon" >REGON: </form:label>
    <form:input path="regon"/>
    <br/>
    Contacts
    <br/>
    <form:label path="phone" >Phone number: </form:label>
    <form:input path="phone"/>
    <form:label path="email" >e-mail: </form:label>
    <form:input path="email"/>
    <form:label path="website" >WWW: </form:label>
    <form:input path="website"/>
    <br/>
    <button type="submit">Zapisz</button>
</form:form>
</body>
</html>
