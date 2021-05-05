<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Create Account</title>
 </head>
 <body>
 
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Create Account</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>FirstName</th>
          <th>LastName</th>
          <th>Login</th>
          <th>Password</th>
       </tr>
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
        </tr>
    </table>
  
 </body>
</html>