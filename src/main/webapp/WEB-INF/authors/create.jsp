
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 
<h1>New Author</h1>

<c:if test="${success !=null }">
<c:out value="${success}"/>
</c:if>

<form:form action="/authors/create" method="POST" modelAttribute="Author">
    <p>
        <form:label path="name">name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="email">email:</form:label>
        <form:errors path="email"/>
        <form:textarea path="email"/>
    </p>
   
    <input type="submit" value="Submit"/>
</form:form>

