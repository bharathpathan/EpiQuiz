<!DOCTYPE html>
<html lang="en">
<head>
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
            padding-top: 1rem;
        }

        .starter-template {
            padding: 3rem 1.5rem;
            text-align: center;
        }
        
        .border{
            
        }
    </style>
</head>

    
<body class="rounded" style="background-color:#FCF3CF ">

   

    <main role="main" class="container">

        <div class="starter-template">
            <div class="border border-dark">
            <h1>EPIQuiz</h1>
            <p class="lead">this is a online quiz program where admin can create the quiz and users can participate in a quiz.</p>
             <p class="lead">Login Page.</p>
        </div></div>
      
    <form name= "LoginServlet" action="LoginServlet" method="post">
    <div class="form-group">
  <label for="usr">Name:</label>
  <input type="text" class="form-control" name="usr" id="usr" >


  <label for="pwd">Password:</label>
  <input type="password" class="form-control" name="pwd" id="pwd">
  </div>
        <input type="submit" onclick="return handleChange()" class="btn btn-info" value="Submit Button" style="align-content: center">
     </form>   
     
      
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
    var x = document.getElementById("usr").value;
    var y = document.getElementById("pwd").value;
    
    if(x==''&&y=='' && !z)
    	{
    	alert("please enter Username and Password");
        return false;
    	}
    else if (x=='') {
        alert("please enter Username");
        return false;
    }

    else if (y=='')
    	{
    	 alert("please enter Password");
         return false;
    	}

   
    return true;
	}

</script>
</body>

</html>