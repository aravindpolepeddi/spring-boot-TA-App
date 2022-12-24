<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>

  </head>
  <body>
  <table border="2">
     <tr>
        <td>Marks</td>
        <td>Remarks</td>
   </tr>      
   <c:forEach items="${requestScope.cr}" var="cr" >
      <tr>
      <td> ${cr.student_marks}</td>
      <td> ${cr.ta_remarks}</td>
      </tr>
  </c:forEach>

  </table>
  </body>
</html>

