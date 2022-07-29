 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 
<h1>New Book</h1>
<form:form action="/books/new" method="post" modelAttribute="book">
    <p>
        <form:label path="title">Title :</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    
    
    <p>
        <form:label path="author">Select Author :</form:label>
        <form:errors path="author"/>
        <form:select path="author">
        
        <option >select  Author</option>
        <c:forEach var="i" items="${authors}">
		        <form:option value="${i.id}"> 
		        		<c:out value="${i.name}"/> 
		        </form:option>
	        </c:forEach>
        </form:select>
    </p>
    
    <p>
        <form:label path="description">Description :</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="language">Language :</form:label>
        <form:errors path="language"/>
        <form:input path="language"/>
    </p>
    <p>
        <form:label path="numberOfPages">Pages</form:label>
        <form:errors path="numberOfPages"/>     
        <form:input type="number" path="numberOfPages"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>


  