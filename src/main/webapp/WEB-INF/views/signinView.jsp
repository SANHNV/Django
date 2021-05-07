<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Sign In</title>
  </head>
  <body>
 
    <jsp:include page="_menu.jsp"></jsp:include>

    <div class="container">

      <h3>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-person-fill" viewBox="0 0 16 16">
          <path d="M9.293 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.707A1 1 0 0 0 13.707 4L10 .293A1 1 0 0 0 9.293 0zM9.5 3.5v-2l3 3h-2a1 1 0 0 1-1-1zM11 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0zm2 5.755V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1v-.245S4 12 8 12s5 1.755 5 1.755z"/>
        </svg>
        Sign In
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

      <form:form method="POST" action="/addUser" modelAttribute="user">
        <table>
          <tr>
            <td><form:label path="firstName">FirstName</form:label></td>
            <td><form:input type="text" required="true" path="firstName"/></td>
          </tr>
          <tr><td><p> </p></td></tr>
          <tr>
            <td><form:label path="lastName">LastName</form:label></td>
            <td><form:input type="text" required="true" path="lastName"/></td>
          </tr>
          <tr><td><p> </p></td></tr>
          <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input type="text" required="true" path="login"/></td>
          </tr>
          <tr><td><p> </p></td></tr>
          <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input type="password" required="true" path="password"/></td>
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
