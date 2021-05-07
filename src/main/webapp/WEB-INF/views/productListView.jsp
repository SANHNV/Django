<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
   <title>Product List</title>
</head>

<body>

   <jsp:include page="_menu.jsp"></jsp:include>

   <div class="container">

      <h3 class="m-3">
         <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-list" viewBox="0 0 16 16">
            <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
            <path d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm-1-5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zM4 8a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm0 2.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z"/>
         </svg>
         Product List
      </h3>

      <c:if test="${errorString != null }">
         <div class="alert alert-warning alert-dismissible show">
            <svg class="bi flex-shrink-0 me-2" width="24" height="24"><use xlink:href="#exclamation-triangle-fill"/></svg>
            <strong>Holy Guacamoly!</strong> You've got an error: ${errorString}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
         </div>
      </c:if>

      <div class="d-flex justify-content-center m-3">
         <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/createProduct">Create Product</a>
      </div>

      <table class="table">
         <thead class="thead-dark">
            <tr>
               <th scope="col">Code</th>
               <th scope="col">Name</th>
               <th scope="col">Price</th>
               <th scope="col">Image</th>
               <th scope="col">Edit</th>
               <th scope="col">Delete</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach items="${productList}" var="product">
               <tr>
                  <th scope="row">${product.idProduct}</th>
                  <th>${product.name}</th>
                  <th>${product.price}</th>
                  <th><img src="${product.image}" width="100" height="100"> </th>
                  <th><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/editProduct?code=${product.idProduct}">Edit</a></td>
                  <th><a type="button" class="btn btn-danger" href="${pageContext.request.contextPath}/deleteProduct?code=${product.idProduct}">Delete</a></th>
               </tr>
            </c:forEach>
         </tbody>
      </table>
   </div>
</body>

</html>