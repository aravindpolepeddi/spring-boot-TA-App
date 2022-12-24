<!DOCTYPE html>
<html>
<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
<body>
<form action="BookCodeReview.htm" method="POST">
 <table>
  <tr>
    <td>Select Assignment</td>
    
    <td><select name="assignment" id="assignment">
        <option value="">Select Assignment</option>
    </select></td>
  </tr>
  <tr>
    <td>Select Date</td>
    
    <td><select name="date" id="date">
        <option value="">Select Date</option>
    </select></td>
  </tr>  
    <tr>
    <td>Select Time</td>
    
    <td><select name="time" id="time">
        <option value="">Select Time</option>
    </select></td>
    
  </tr> 

</table> 
<input type="submit" name="Student Book" value="Student Book"/><br/>
</form>
</body>
<script>
$(function (){
    $.ajax({                                      
      url: '/proj/student/AssignmentAJAX',
      cache: false,
      dataType: 'json',
      success: function(result){
    	  $.each(result,function(key,value){
    		$('<option>').val(key).text(value).appendTo("#assignment");  
    	  });
      }
   });
});

$(document).on("change", "#assignment", function(){
	$("#date").find('option').remove();
	$('<option>').val("").text("Select Date").appendTo('#date');
	$("#time").find('option').remove();
	$('<option>').val("").text("Select Time").appendTo('#time');
	var selectedAssId = $("#assignment").val();
    $.ajax({  
        url: '/proj/student/AssignmentDateAJAX',
        data: {
        	assignment: selectedAssId
        },
        dataType: 'json',
        success: function(result){
      	  $.each(result,function(key,value){
      		$('<option>').val(key).text(value).appendTo("#date");  
      	  });
        }
     });
	
});


$(document).on("change", "#date", function(){
	$("#time").find('option').remove();
	$('<option>').val("").text("Select Time").appendTo('#time');
	var selectedDate = $("#date").val();
    $.ajax({  
        url: '/proj/student/AssignmentTimeAJAX',
        data: {
        	date: selectedDate
        },
        dataType: 'json',
        success: function(result){
      	  $.each(result,function(key,value){
      		$('<option>').val(key).text(value).appendTo("#time");  
      	  });
        }
     });
	
});


</script>
<!--         <script>
        window.onload = function() {
            if (window.jQuery) {  
                // jQuery is loaded  
                alert("Yeah!");
            } else {
                // jQuery is not loaded
                alert("Doesn't Work");
            }
        }
        </script> -->
</html>