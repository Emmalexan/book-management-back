 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="ui segment">

		<div id="header">
			<h2>Για το μάθημα : ${course.title}</h2>
		</div>
<form method="get" action="${pageContext.request.contextPath}/teacher/<%=session.getAttribute("teacher_id")%>/choose" >
        <fieldset>  
        <legend>Επιλογή 2 Συγγραμμάτων</legend>  
        	<c:forEach var="exist_temp" items="${existing_books}">
        			 <input type="checkbox" name="textbook" value="${exist_temp.getId()}" onclick="Atleast()" checked>${exist_temp.getTitle()}<br>  
        	</c:forEach>
        	<c:forEach var="non" items="${non}">
        			 <input type="checkbox" name="textbook" value="${non.id}" onclick="Atleast2()">${non.title}<br>  
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
        var Nocheck = [];
        var numberOfNoCheckedItems = 0;  
        for(var i = 0; i < checkboxes.length; i++)  
        {  		var j=0;
        		//if(numberOfNoCheckedItems > 2)  
        		//{  
                //		alert("You can't select more than two textbooks!");  
                //		return false;  
        		//}
                if(!checkboxes[i].checked) {
                //	 checkedValue = inputElements[i].value;
                //	System.out.println(checkedValue);
         	       		//checked.add(checkboxes[i].value);
  						//check[j++] = checkboxes[i].value 
                        numberOfNoCheckedItems++;
                        Nocheck[j] = checkboxes[i].value
                        alert(Nocheck[j]);
                        j++;
                         
                }  
           }
        for(var j=0; j< Nocheck.length; j++){
        var urlCall = "<c:url value="/teacher/${course.id}/DeleteSelectedTextBook/"></c:url>";
		$.ajax({
			type: "POST",
			url : urlCall + Nocheck[j],
			success : function(result) {
				console.log(Nocheck[j])
				console.log(result);
				//$(location).attr("href", "<c:url value="/textbook/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
     }
}  


function Atleast2()  
{  
	//	var checkedValue = null; 
        //alert(item.value);
        var checkboxes = document.getElementsByName("textbook");
        var check = [];
        var numberOfCheckedItems = 0;  
        
        for(var i = 0; i < checkboxes.length; i++)  
        {  		var j=0;
        	//	if(numberOfCheckedItems == 2)  
        	//	{  
            //    		alert("You can't select more than two textbooks!");  
                		//return false;  
        	//	}
        	//	if(numberOfCheckedItems == 3)  
        	//	{  
            //    		alert("alert");  
            //    		return false;  
        	//	}
                if(checkboxes[i].checked) {
                	
                //	 checkedValue = inputElements[i].value;
                //	System.out.println(checkedValue);
         	       		//checked.add(checkboxes[i].value);
  						//check[j++] = checkboxes[i].value 
                        numberOfCheckedItems++;
                        check[j] = checkboxes[i].value
                       // alert(check[j]);
                        j++;
                       // if(numberOfCheckedItems == 2){
                       // 	alert("You can't select more than two textbooks!"); 
                       // }
                       if(numberOfCheckedItems == 3){
                        	alert("You can't select more than two textbooks!"); 
                        	alert("alert");  
                    		return false;  
                        }
                }  
           }
        for(var j=0; j< check.length; j++){
        var urlCall = "<c:url value="/teacher/${course.id}/saveSelectedTextBook/"></c:url>";
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





<!-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="ui segment">

		<div id="header">
			<h2>Για το μάθημα : ${course.title}</h2>
		</div>
<form>
        <fieldset>  
        <legend>Επιλογή Συγγραμμάτων</legend>  
        	<c:forEach var="exist_temp" items="${existing_books}">
        			 <input type="checkbox" name="textbook" value="${exist_temp.getId()}" onclick="Atleast2()" checked>${exist_temp.getTitle()}<br>  
        	</c:forEach>
        	<c:forEach var="non" items="${non}">
        			 <input type="checkbox" name="textbook" value="${non.id}" onclick="Atleast2()">${non.title}<br>  
        	</c:forEach>
        			
                <br>  
         <input type="button" value="Save" onclick="on_save(<%=session.getAttribute("teacher_id")%>)">  
        </fieldset>  
</form>  
</div>

<script type="text/javascript">  
function Atleast2()  
{  
	//	var checkedValue = null; 
        //alert(item.value);
        var checkboxes = document.getElementsByName("textbook");
        var check = [];
        var numberOfCheckedItems = 0;  
        for(var i = 0; i < checkboxes.length; i++)  
        {  		var j=0;
        		if(numberOfCheckedItems >= 2)  
        		{  
                		alert("You can't select more than two textbooks!");
                		checkboxes[i].checked = false;
                		return false;  
        		}
                if(checkboxes[i].checked) {
                //	 checkedValue = inputElements[i].value;
                //	System.out.println(checkedValue);
         	       		//checked.add(checkboxes[i].value);
  						//check[j++] = checkboxes[i].value 
                        numberOfCheckedItems++;
                        check[j] = checkboxes[i].value
                        //alert(check[j]);
                        j++;
                         
                }  
           }
}
function on_save(tid){
   	 var checkboxes = document.getElementsByName("textbook");
   	 var check=[];
   	 for(var i=0; i< checkboxes.length;i++){
   		 if(checkboxes[i].checked){
   			 check.push(checkboxes[i].value);
   		 }
   		 console.log("ok");
   	 }
		 console.log(check);
		 datas = JSON.stringify(check);
		 console.log(datas)

        var urlCall = "<c:url value="/teacher/${course.id}/saveSelectedTextBook/"></c:url>";
		$.ajax({
			type: "POST",
			//contentType : "application/json",
			//data : datas,
		    //dataType: "json",
			url : urlCall + check[0],
			success : function(success) {
				//console.log(check[0])
				console.log("SUCCESS",success);
				$(location).attr("href", "<c:url value="/teacher/${tid}"></c:url>");
			},
			error : function(e) {
				console.log("ERROR",e);
			},
		});
     
}  

</script> -->
 



