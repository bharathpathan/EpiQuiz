<!DOCTYPE html>
    <html lang="en">
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
          <form name= "EditQueServlet" action="EditQueServlet" method="post">
       <textarea class="form-control" id="ques" rows="5" style="padding-bottom: 10px" name="question" placeholder="input your question here...."></textarea> 
        
        <p class="lead">please enter the choices for the above question and check the check boxes for the correct answer.</p>
        
        <div class="checkbox" style="padding-top: 10px; padding-left: 50px">
            <label><input type="checkbox" id="opp1" name="option" value="option1t" ><input type="text" value="" name="option1t" id="op1" placeholder="please give option 1"></label>
            <label class="checkbox-inline" style="padding-left: 300px"><input type="checkbox" id="opp2"name="option" value="option2t"><input type="text" id="op2" value="" name="option2t" placeholder="please give option 2"></label>
        </div>
        
        
        <div class="checkbox" style="padding-left: 50px">
            <label><input type="checkbox" id="opp3" name="option" value="option3t"><input type="text" value="" name="option3t" placeholder="please give option 3" id="op3"></label>
            <label class="checkbox-inline" style="padding-left: 300px"><input type="checkbox" id="opp4" name="option" value="option4t"><input type="text" id="op4" name="option4t" value="" placeholder="please give option 4"></label>
        </div>
        
        <p class="lead">please enter the tag for the question to find the question while adding to a quiz.</p>
        
        <div class="input-group">
            <span class="input-group-addon">Tag : </span>
            <input id="tag" type="text" class="form-control" name="tag" placeholder="Add a tag for the question.">
        </div>
            
       
        
  
        
         <div style="float: right">
        
        <input type="submit" onclick="return handleChange()" class="btn btn-success" value="+ add the question" name="add"/>
  
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
<script>

function handleChange(input) {
    var x = document.getElementById("ques").value;
    var y = document.getElementById("tag").value;
    var z = ((document.getElementById("op1").value!='')&&(document.getElementById("op1").value!='')&&(document.getElementById("op3").value!='')&&(document.getElementById("op4").value!=''));
    if(x==''&&y=='' && !z)
    	{
    	alert("please enter Question, options and Tag");
        return false;
    	}
    else if (x=='') {
        alert("please enter Question");
        return false;
    }
    else if(!z)
    	{
    	alert("please enter all the options");
        return false;
    	}
    else if (y=='')
    	{
    	 alert("please enter Tag");
         return false;
    	}
    else if(!($('input[id=opp1]').is(':checked') ||$('input[id=opp2]').is(':checked') || $('input[id=opp3]').is(':checked') || $('input[id=opp4]').is(':checked')))
	{	
	   alert("please select one of the option as an answer !!");
	   return false;
	}
    console.log($('input[id=op1]').is(':checked') ||$('input[id=op2]').is(':checked') || $('input[id=op3]').is(':checked') || $('input[id=op4]').is(':checked'));
    return true;
	}

</script>

</body>
<footer class="border border-dark">
<p class="lead">this is a online quiz program where admin can create the quiz and users can participate in a quiz.</p>

</footer>
</html>