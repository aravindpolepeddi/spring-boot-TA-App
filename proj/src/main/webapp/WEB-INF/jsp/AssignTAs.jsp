<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<h1>Assign Student to a TA</h1>



<form action="AssignTAs.htm" method="POST">

<label for="students">Choose student:</label>
 <select name="students" id="students">
<c:forEach items="${requestScope.studentList}" var="student" >
  <option value=${student.ID}>${student.firstname}, ${student.lastname}</option>
</c:forEach>
</select>

<label for="TAs">Choose TA:</label> 
<select name="TAs" id="TAs">
<c:forEach items="${requestScope.taList}" var="ta">
  <option value=${ta.ID}>${ta.firstname}, ${ta.lastname}</option>
</c:forEach>
</select>
<input type="submit" id="submit" value="submit">
</form>



</body>
<script>
function Compare() {
	var GivenDate = new Date(document.getElementById("Code_Review_Date").value);
	var CurrentDate = new Date();
	if(GivenDate < CurrentDate){
	    alert('Given date is not greater than the current date.');
	}
    var strStartTime = document.getElementById("codereviewstart").value;
    var strEndTime = document.getElementById("codereviewend").value;

    var startTime = new Date().setHours(GetHours(strStartTime), GetMinutes(strStartTime), 0);
    var endTime = new Date(startTime)
    endTime = endTime.setHours(GetHours(strEndTime), GetMinutes(strEndTime), 0);
    if (startTime > endTime) {
        alert("Start Time is greater than end time");
    }
    if (startTime == endTime) {
        alert("Start Time equals end time");
    }
}
function GetHours(d) {
    var h = parseInt(d.split(':')[0]);
    if (d.split(':')[1].split(' ')[1] == "PM") {
        h = h + 12;
    }
    return h;
}
function GetMinutes(d) {
    return parseInt(d.split(':')[1].split(' ')[0]);
}
</script>
</html>