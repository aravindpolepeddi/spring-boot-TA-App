<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Add User Form</title>
</head>
<body>

<h2>User Login</h2>

<form:form modelAttribute="user">

<table>
	<tr>
		<td>Username:</td>
		<td><form:input path="username" size="30" /><font color="red"><form:errors path="Username" /></font></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><form:password path="password" size="30" /><font color="red"><form:errors path="Password" /></font></td>
	<tr>
		<td colspan="2"><input type="submit" value="Login" /></td> 
	</tr>
</table>
</form:form>
</body>
</html>