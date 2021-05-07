<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
  <c:if test="${product.idProduct == null}">
    <title>Create Product</title>
  </c:if>
  <c:if test="${product.idProduct != null}">
    <title>Edit Product</title>
  </c:if>
</head>

<body>

  <jsp:include page="_menu.jsp"></jsp:include>

  <div class="container">
    <c:if test="${product.idProduct == null}">
      <h3>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
          <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
        </svg>
        Create Product
      </h3>
    </c:if>
    <c:if test="${product.idProduct != null}">
      <h3>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
          <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
          <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
        </svg>
        Edit Product
      </h3>
    </c:if>

    <c:if test="${errorString != null }">
      <div class="alert alert-warning alert-dismissible show">
        <svg class="bi flex-shrink-0 me-2" width="24" height="24"><use xlink:href="#exclamation-triangle-fill"/></svg>
        <strong>Holy Guacamoly!</strong> You've got an error: ${errorString}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
      </div>
    </c:if>
  
    <c:if test="${product.image != null}">
      <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Code</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">LimitDate</th>
            <th scope="col">Image rendue</th>
            <th scope="col">Quantity</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">${product.idProduct}</th>
            <th>${product.name}</th>
            <th>${product.price}</th>
            <th>${date}</th>
            <th><img src="${product.image}" width="100" height="100"> </th>
            <th>${product.quantity}</th>
          </tr>
        </tbody>
      </table>
    </c:if>

    <hr class="my-4">
    <p class="lead"> Form :</p>
  
    <form:form method="POST" action="/createP" modelAttribute="product">
      <table>
        <tr>
          <td>
            <form:input path="idProduct" value="${code}" type="text" hidden="true" />
          </td>
        </tr>
        <tr>
          <td>
            <form:label path="name">Name</form:label>
          </td>
          <td>
            <form:input path="name" type="text" required="true" />
          </td>
        </tr>
        <tr><td><p> </p></td></tr>
        <tr>
          <td>
            <form:label path="price">price</form:label>
          </td>
          <td>
            <form:input path="price" type="text" required="true" />
          </td>
        </tr>
        <tr><td><p> </p></td></tr>
        <tr>
          <td>
            <form:label path="image">image</form:label>
          </td>
          <td>
            <form:input path="image" type="text" required="true" />
          </td>
        </tr>
        <tr><td><p> </p></td></tr>
        <tr>
          <td>
            <form:label path="limitDate">limitDate</form:label>
          </td>
          <td>
            <form:input path="limitDate" type="date" required="true" />
          </td>
        </tr>
        <tr><td><p> </p></td></tr>
        <tr>
          <td>
            <form:label path="quantity">quantity</form:label>
          </td>
          <td>
            <form:input path="quantity" type="number" step="0.01" required="true" />
          </td>
        </tr>
        <tr><td><p> </p></td></tr>
        <tr>
          <td><input type="submit" class="btn btn-success m-2" value="Submit" /></td>
        </tr>
      </table>
    </form:form>
  </div>

</body>
</html>