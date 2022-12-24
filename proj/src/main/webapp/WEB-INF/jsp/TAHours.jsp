<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>

<h1>TA Hours</h1>




<form action="TAHours.htm" method="POST">
<label for="TA Hour Date">Code Review Date:</label>
<input type="date" id="TA_Hour_Date" name="TA_Hour_Date">

<input type="time" id="tahourstart" name="tahourstart" min="09:00" max="22:00" required>
<input type="time" id="tahourend" name="tahourend" min="09:00" max="22:00" required>
<input type="submit" id="btnCompare" value="Compare" onclick="Compare()">
</form>



</body>
<script>
function Compare() {
	var GivenDate = new Date(document.getElementById("TA_Hour_Date").value);
	var CurrentDate = new Date();
	if(GivenDate < CurrentDate){
	    alert('Given date is not greater than the current date.');
	}
    var strStartTime = document.getElementById("tahourstart").value;
    var strEndTime = document.getElementById("tahourend").value;

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