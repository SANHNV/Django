<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>My Account Information</title>
   </head>
   <body>
 
      <jsp:include page="_menu.jsp"></jsp:include>

      <div class="container">
            
         <h3>
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
               <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
               <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
            </svg> 
            My Account Information
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

         <table class="table">
            <thead class="thead-dark">
               <tr>
                  <th scope="col">FirstName</th>
                  <th scope="col">LastName</th>
                  <th scope="col">Login</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <th scope="row">${user.firstName}</th>
                  <th>${user.lastName}</th>
                  <th>${user.login}</th>
               </tr>
            </tbody>
         </table>
      </div>
  
   </body>
</html>
