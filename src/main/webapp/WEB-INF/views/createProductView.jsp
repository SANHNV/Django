<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>
 
    <jsp:include page="_menu.jsp"></jsp:include>

    <!--TODO: CREATE FORM-->
 
    <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
      <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Price</th>
        <th>LimitDate</th>
        <th>Image URL</th>
        <th>Quantity</th>
      </tr>
      <tr>
        <td>${product.idProduct}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${date}</td>
        <td>${product.image}</td>
        <td>${product.quantity}</td>
      </tr>
    </table>

    <form:form method="POST" action="/createP" modelAttribute="product">
    <table>
      <tr>
        <td><form:input path="idProduct" value="${code}" type="text" hidden="true"/></td>
      </tr>
      <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" type="text" required="true" /></td>
      </tr>
      <tr>
        <td><form:label path="price">price</form:label></td>
        <td><form:input path="price" type="text" required="true" /></td>
      </tr>
      <tr>
        <td><form:label path="image">image</form:label></td>
        <td><form:input path="image" type="text" required="true" /></td>
      </tr>
      <tr>
        <td><form:label path="limitDate">limitDate</form:label></td>
        <td><form:input path="limitDate" type="date" required="true" /></td>
      </tr>
      <tr>
        <td><form:label path="quantity">quantity</form:label></td>
        <td><form:input path="quantity" type="number" step="0.01" required="true" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>
  
 </body>
</html>
