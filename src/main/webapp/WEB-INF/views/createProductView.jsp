<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>
 
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
      <tr>
         <th>Code</th>
         <th>Name</th>
         <th>Price</th>
         <th>Image URL</th>
         <th>Quantity</th>
      </tr>
      <tr>
         <td>${product.idProduct}</td>
         <td>${product.name}</td>
         <td>${product.price}</td>
         <td>${product.image}</td>
         <td>${product.quantity}</td>
      </tr>
    </table>
  
 </body>
</html>
