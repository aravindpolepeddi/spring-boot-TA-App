<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <style>
.block {
  display: block;
  width: 100%;
  border: none;
  background-color: #04AA6D;
  color: white;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
}

.block:hover {
  background-color: #ddd;
  color: black;
}
</style>
    <body>
            <c:set var="url">${req.requestURL}</c:set>
    <c:set var="uri" value="${req.requestURI}" />
    <c:set var="base_url">${fn:substring(url, 0, fn:length(url) - fn:length(uri))}</c:set>
        
                  <div>
            <form action="${base_url}/proj/admin/AddStudents.htm" method="get">
                <input class="block" type="submit" name="AddStudents" value="Add Students"/><br/>
            </form>
        </div>
        
                  <div>
            <form action="${base_url}/proj/admin/AddTAs.htm" method="get">

                <input class="block" type="submit" name="Add TAs" value="Add TAs"/><br/>

            </form>
        </div>
                          <div>
            <form action="${base_url}/proj/admin/AssignTAs.htm" method="get">

                <input class="block" type="submit" name="Assign TAs" value="Assign TAs"/><br/>

            </form>
        </div>
                                   <div>
            <form action="${base_url}/proj/Logout.htm" method="get">

                <input class="block" type="submit" name="Logout" value="Logout"/><br/>

            </form>
        </div> 


    </body>
</html>