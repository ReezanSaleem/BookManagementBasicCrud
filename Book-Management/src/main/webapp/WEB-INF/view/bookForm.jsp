<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: reezan
  Date: 2023-02-24
  Time: 11.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<c:set var="type" value="${book.ISBN == 0 ? 'Add New Book' : 'Edit Book'}" />


<head>
    <title>${type}</title>
</head>
<body>
<h1 style="text-align: center">${type}</h1>

<form:form action="saveBook" method="post" modelAttribute="book"><%--this model  attribute is only mapped there with @MedelAttribute Book book in saveBook--%>
    <table align="center">
        <form:hidden path="ISBN"/>
        <tr>
            <td>
                <form:label path="name">Book Name</form:label>
            </td>
            <td>
                <form:input path="name" required="true"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="author">Author</form:label>
            </td>
            <td>
                <form:input path="author" required="true"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="publisher">Publisher</form:label>
            </td>
            <td>
                <form:input path="publisher" required="true"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center" style="padding: 30px">
                <input type="submit" style="width: 100%" value=${type}/>
            </td>

        </tr>
    </table>
</form:form>

</body>
</html>
