<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>

<h1>Show a Date Control</h1>

<%-- <form:form modelAttribute="TA">
  <label for="Code Review Date">Code Review Date:</label>
  <form:input type="Date" path="codereviewdate" />
  
   <label for="time period">Choose time period:</label>  
  <form:select path="codereviewperiod">
    <form:option value="10 mins" label="10 mins"/>
    <form:option value="15 mins" label="15 mins"/>
    <form:option value="30 mins" label="30 mins"/>
</form:select>
  
  <form:input path="codereviewstart" size="30" value="5:00 PM"/> 
  <form:input path="codereviewend" size="30" value="01:23 AM"/> 


  
  <input type="submit" id="btnCompare" value="Compare" onclick="Compare()">
</form:form> --%>



<form action="CodeReview.htm" method="POST">
<label for="Assignment_Num">Enter Assignment Number:</label>
<input type="number" id="Assignment_Num" name="Assignment_Num">

<label for="Code Review Date">Code Review Date:</label>
<input type="date" id="Code_Review_Date" name="Code_Review_Date">

<label for="time period">Choose time period:</label> 
<select name="codereviewperiod" id="codereviewperiod">
  <option value="10">10 mins</option>
  <option value="15">15 mins</option>
  <option value="30">30 mins</option>
</select>

<input type="time" id="codereviewstart" name="codereviewstart" min="09:00" max="22:00" required>
<input type="time" id="codereviewend" name="codereviewend" min="09:00" max="22:00" required>
<input type="submit" id="btnCompare" value="Compare" onclick="Compare()">
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