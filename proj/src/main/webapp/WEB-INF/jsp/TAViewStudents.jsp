<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
  <table border="2">
     <tr>
        <td>Student First Name</td>
        <td>Student Last Name</td>

   </tr>   
  
   <c:forEach items="${requestScope.studentList}" var="cr" >
      <tr>
      <td> ${cr.firstname}</td>
      <td> ${cr.lastname}</td>
      </tr>
  </c:forEach>

  </table>
    </body>
</html>