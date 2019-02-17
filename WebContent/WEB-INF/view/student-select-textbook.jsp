<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="header">
			<h3>Για το μάθημα : ${course.title}</h3>
		</div>
<div class="ui segment">
	
<!--  <form method="get" action="http://localhost:8080/book-management/student/<%=session.getAttribute("student_id")%>" >
        <fieldset>  
        <legend>Επιλογή 1 Συγγράμματος</legend>  
        	<c:forEach var="existprofile_temp" items="${student_bookProfile}">
        			 <input type="checkbox" name="textbook" value="${existprofile_temp.getTextbook().getId()}" onclick="Atleast()" checked>${existprofile_temp.getTextbook().getTitle()}<br>  
        	</c:forEach>
        	<c:forEach var="non_temp" items="${non_ex}">
        			 <input type="checkbox" name="textbook" value="${non_temp.id}" onclick="Atleast2()">${non_temp.title}<br>  
        	</c:forEach>
        			
                <br>  
         <input type="submit" value="Save">   
        </fieldset>  
</form>  -->
 
 
 
 <form method="get" action="${pageContext.request.contextPath}/student/<%=session.getAttribute("student_id")%>" >
        <fieldset>  
        <legend>Επιλογή 1 Συγγράμματος</legend>  
        	
        	<c:forEach var="temp_book" items="${course_books}">
        			 <input type="checkbox" name="textbook" value="${temp_book.id}" onclick="Atleast()">${temp_book.title}<br>  
        	</c:forEach>
        			
                <br>  
         <input type="submit" value="Save">   
        </fieldset>  
</form>  
 
 
</div>





<script type="text/javascript">  




function Atleast()  
{  
	//	var checkedValue = null; 
        //alert(item.value);
        var checkboxes = document.getElementsByName("textbook");
        var check = [];
        var numberOfCheckedItems = 0;  
        for(var i = 0; i < checkboxes.length; i++)  
        {  		var j=0;
        		
                if(checkboxes[i].checked) {
                //	 checkedValue = inputElements[i].value;
                //	System.out.println(checkedValue);
         	       		//checked.add(checkboxes[i].value);
  						//check[j++] = checkboxes[i].value 
                        numberOfCheckedItems++;
                        check[j] = checkboxes[i].value
                       // alert(check[j]);
                        j++;
                        if(numberOfCheckedItems == 2 )  
                		{  
                        		alert("You can't select more than 1 textbooks!");  
                        		return false;  
                		}
                         
                }  
           }
        for(var j=0; j< check.length; j++){
        var urlCall = "<c:url value="/student/${student.id}/saveSelectedTextBook/"></c:url>";
		$.ajax({
			type: "POST",
			url : urlCall + check[j],
			success : function(result) {
				console.log(check[j])
				console.log(result);
				//$(location).attr("href", "<c:url value="/textbook/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
     }
}   	








</script>