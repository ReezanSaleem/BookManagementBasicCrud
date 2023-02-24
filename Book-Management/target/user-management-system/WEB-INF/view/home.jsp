<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.userwebapp.model.Book" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>

<style>
    .centerBtn {
        display: flex;
        justify-content: center;
        margin: 20px 0;
    }
    .buttonArrangement{
        display: flex;
        justify-content:center;
        padding:5px;
    }

</style>

<body>
<h3 style="text-align: center">Book Management System</h3>

<div class="centerBtn">
    <button type="button"><a href="newForm">Add New Book</a></button>
</div>
<table border="1" align="center" style="width: 70%; text-align: center">
    <tr>
        <th>ISBN</th>
        <th>Name</th>
        <th>Author</th>
        <th>Publisher</th>
        <th colspan="2">Action</th>
    </tr>

    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>${book.getISBN()} </td>
            <td>${book.getName()} </td>
            <td>${book.getAuthor()} </td>
            <td>${book.getPublisher()} </td>
            <td colspan="2">
                <div class="buttonArrangement">
                    <button type="button" style="margin:2px 10px"><a href="update?isbn=${book.getISBN()}">Update</a></button>

                    <button type="button" style="margin:2px 10px"><a href="delete?isbn=${book.getISBN()}">Delete</a></button>
                </div>
            </td>
        </tr>
    </c:forEach>

</table>

</body>

</html>