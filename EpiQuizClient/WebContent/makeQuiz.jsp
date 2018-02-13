
<%@page import="fr.epita.epiquiz.model.Question"%>
<%-- <%@page import="fr.epita.core.services.HibernateIdentityDAO"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
    <html lang="en">
        <% List<Question> identitiesList = (List<Question>)session.getAttribute("quesList");

   session.removeAttribute("identitiesList");
  
%>
<head>
<%
    Boolean auth = (Boolean) session.getAttribute("authenticated");
    if (auth == null || !auth) {
%>
<meta http-equiv="refresh" content="0; URL=index.jsp">
<%
    }
%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>EpiQuiz</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <style type="text/css">
        body {
            padding-top: 0rem;
        }

        .starter-template {
            padding: 1rem 1.5rem;
            text-align: center;
        }
        
        .border{
            
        }
        input[type="checkbox"]{
  width: 30px; /*Desired width*/
  height: 30px; /*Desired height*/
  cursor: pointer;

  
}
    </style>
</head>

    
<body class="rounded" style="background-color:#FCF3CF ">

   

    <main role="main" class="container">

        <div class="starter-template">
            <div class="border border-dark">
            <h1>EPIQuiz</h1>
            
        </div></div>
      <form action="LogoutServlet" Method="post">
        <button type="submit" class="btn btn-success"   >Logout</button>
        <a href="studenthome.jsp"><button type="button" class="btn btn-success"   >Home</button></a>
</form>
    
    <div class="border border-dark" style="padding-left: 10px;padding-right: 10px;padding-top: 10px;padding-bottom: 10px; padding: 1.5rem;">
        <form class="form-horizontal"  method="post" action="MakeQuizServlet">
            <div class="border border-dark">
                
                <div style="padding-top: 1rem;padding-top: 1rem;" >
                    <table  >
                    <thead>please enter the <mark>Question Name</mark> and <mark>Marks</mark> to be given for the quiz.</thead>
                    <tr>
                        <td style="padding-left: 0em">
                            <input class="form-control" name="quizID" type="text" Value=<%=session.getAttribute("quizzid") %> readonly style="width:150px;  ">
                        </td>
                        
                    <td style="padding-left: 1.8em">
                            <div class="col-xs-3">
                            <input class="form-control" id="name" name="quizName" type="text" placeholder="Enter Quiz Name" style="width:350px "></div>
                        </td>
                        <td style="padding-left: 1.0em">
                            <div class="col-xs-3">
                            <input class="form-control" id="marks" name="quizMarks" type="text" placeholder="Marks" style="width:70px "></div>
                        </td>
                        
                        </tr>
                    
                    </table>
                
                
                
            </div>
            </div>
            
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Selection</th>
							<th>ID</th>
							<th>Question</th>
							<th>tags</th>
							<th>Explaination</th>
						</tr>
					</thead>
					<tbody>
					   <%
					   if (identitiesList == null || identitiesList.isEmpty()){ %>
						  <tr>
						      <td colspan="4">No result</td>
						  </tr>
						   
					   <% } else{
					   for (Question id : identitiesList){ %>
						<tr>
							<td><input name="quesSelection" type="checkbox" id="checkbox" value="<%=id.getId()%>"  /></td>
							<%-- <td> <label for="id" name="id" id="id" value="<%=id.getId() %>"><%=id.getId() %></label></td> --%>
							<td><%=id.getId() %></td>
							<%-- <td><%=id.getDisplayName() %></td> --%>
							<td><%=id.getQuestion() %></td>
							<%-- <td><%=id.getEmail() %></td> --%>
							<td><%=id.getTags() %></td>
							<%-- <td><%=id.getBirthDate() %></td> --%>
							<td><%=id.getExplaination() %></td>
							<td>
							<input type="image" name="edit" src="http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-9/256/edit-file-icon.png" style="width:20px; height:20px" value=<%=id.getId()%> />						
							</td>
							<td>
							<input type="image" name="delete" src="http://icons.iconarchive.com/icons/hopstarter/sleek-xp-software/256/Windows-Close-Program-icon.png" style="width:20px; height:20px" value=<%=id.getId()%> />						
							</td>
						</tr>
                        <%} 
                        }%>

					</tbody>
				</table>
			</div>
			<div class="form-group">
				<div class=" col-sm-offset-2 col-sm-10 text-right">
					
					
					<table>
					<tr>
					<label>Please select minimum number of questions to form a quiz.  the minum questions you need to select more is : <input class="form-control" name="quizID" type="text" id="see" Value=<%=5 %> readonly style="width:50px;  "> </label>
					</tr>
					<tr>
					<input type="submit" onclick="return handleChange()" class="btn btn-primary" id="make" value="Make Quiz" name="make" id="txt">	
					</tr></table>			
				</div>
	</div>
	</form>
       </div>
      
    </main>
    <!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript">

var a=0;

console.log("--->"+a);
$(':input[id="make"]').prop('disabled', true);

$('input[type=checkbox]').click(function () {
	 
	 
    if ($('input[type=checkbox]').is(':checked')) {
       a=a+1;
       if(a<5)
       $(':input[id="see"]').val(""+(5-a));
       if(a>=5){
    	   $(':input[id="see"]').val(""+0);
       $(':input[id="make"]').prop('disabled', false);
       
       }
       
       
     
       
    }
});

function handleChange(input) {
    var x = document.getElementById("name").value;
    var y = document.getElementById("marks").value;
    if(x==''&&y=='')
    	{
    	alert("please enter Quiz Name and Quiz Marks");
        return false;
    	}
    else if (x=='') {
        alert("please enter Quiz Name");
        return false;
    }
    else if (y=='')
    	{
    	 alert("please enter Quiz Marks");
         return false;
    	}
    return true;
}
</script>

</body>
<footer class="border border-dark">
<p class="lead">this is a online quiz program where admin can create the quiz and users can participate in a quiz.</p>

</footer>
</html>