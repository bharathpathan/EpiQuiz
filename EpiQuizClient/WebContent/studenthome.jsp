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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
        
</form>

<form name="StudentHomeServlet" action="StudentHomeServlet" method="post">
        <div class="panel-group">
   



    <div class="panel panel-success">
        <div class="panel-heading"><h4 class="text-default">Participate in a quiz</h4></div>
      <div class="panel-body">
          
          <h5 class="text-success">In this section you as a student can <mark>can participate</mark> in a quiz. qAll multiple choice questions which contains one answer. gaining points will increase your score and puts you in top of leader board.</h5>
        <div style="float: right;">
            <input type="submit" name="participate" class="btn btn-default" value="+ Participate" style="font-size: 40px; float: inherit" /></div>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading"><h4 class="text-default">Check your results</h4></div>
     <div class="panel-body">
          
         <h5 class="text-info">In this section you as a student can <mark>view your result.</mark> </h5>
        <div style="float: right;">
            <input type="submit" name="view" class="btn btn-default" value="> View" style="font-size: 40px; float: inherit" /></div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading"><h4 class="text-default">view Student quiz results</h4></div>
      <div class="panel-body">
          
          <h5 class="text-default">In this section you as a student can <mark>View other's results</mark> </h5>
        <div style="float: right;">
          <input type="submit" name="oView" class="btn btn-default" value="> View" style="font-size: 40px; float: inherit" /></div>
        </div>
    </div>

    
  </div>
  </form>
        
     
      
    </main>
    <!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>

<footer class="border border-dark">
<p class="lead">this is a online quiz program where admin can create the quiz and users can participate in a quiz.</p>

</footer>
</html>