<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <title>Home Page</title>
</head>

<nav class="navbar navbar-expand-lg navbar-default">
   <div class="container-fluid">
     <div class="navbar-header">
       <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
     </div>
     <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/productList">Product List</a></li>
      <c:if test="${sessionScope.user != null }">
         <li class="active"><a href="${pageContext.request.contextPath}/userInfo">My Account Info</a></li>
      </c:if>
      <c:if test="${sessionScope.user == null }">
         <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
         <li><a href="${pageContext.request.contextPath}/signin">Sign In</a></li>
      </c:if>
     </ul>
   </div>
 </nav>
