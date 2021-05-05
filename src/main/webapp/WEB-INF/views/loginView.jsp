<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>My Account Information</title>
  </head>
  <body>
 
  <jsp:include page="_menu.jsp"></jsp:include>

  <h3>My Account Information</h3>

  <p style="color: red;">${errorString}</p>

  <form:form method="POST" action="/addUser" modelAttribute="user">
    <table>
      <tr>
        <td><form:label path="firstName">FirstName</form:label></td>
        <td><form:input path="firstName"/></td>
      </tr>
      <tr>
        <td><form:label path="lastName">LastName</form:label></td>
        <td><form:input path="lastName"/></td>
      </tr>
      <tr>
        <td><form:label path="login">Login</form:label></td>
        <td><form:input path="login"/></td>
      </tr>
      <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>

  </body>
</html>
