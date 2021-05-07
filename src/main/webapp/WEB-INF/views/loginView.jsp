<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login</title>
  </head>
  <body>
 
  <jsp:include page="_menu.jsp"></jsp:include>

  <div class="container">
    <h3>
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-person" viewBox="0 0 16 16">
        <path d="M11 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
        <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2v9.255S12 12 8 12s-5 1.755-5 1.755V2a1 1 0 0 1 1-1h5.5v2z"/>
      </svg>
      Login
    </h3>

    <c:if test="${errorString != null }">
         <div class="alert alert-warning alert-dismissible show">
            <p class="d-flex align-items-center">
              <svg class="bi flex-shrink-0 me-2" width="24" height="24"><use xlink:href="#exclamation-triangle-fill"/></svg>
              <strong>Holy Guacamoly!</strong> You've got an error:</p>
            <p>${errorString}</p>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
         </div>
      </c:if>
  
    <form:form method="POST" action="/checkUser" modelAttribute="user">
      <table>
        <tr>
          <td><form:label path="login">Login</form:label></td>
          <td><form:input type="text" required="true" path="login"/></td>
        </tr>
        <tr><td><p> </p></td></tr>
        <tr>
          <td><form:label path="password">Password</form:label></td>
          <td><form:input type="password" required="true" path="password"/></td>
        </tr>
        <tr>
          <td><p> </p><input type="submit" class="btn btn-success m-2" value="Submit" /></td>
        </tr>
      </table>
    </form:form>
  
  </div>
  </body>
</html>
