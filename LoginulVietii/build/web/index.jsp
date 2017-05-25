<%@page import="app.fbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	fbConnection fbConnection = new fbConnection();
%>
<!DOCTYPE html>
<html>
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet'  type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Meriweather' rel='stylesheet'  type='text/css'>

  <link rel="stylesheet" type="text/css" href="myProfileStyle.css">

	<link rel="stylesheet" type="text/css" href="style2.css">
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
  <style type="text/css">
    body{background-image:url("./img/back2.png");}
    #header{font-family: 'Lobster', sans-serif;
    padding-top: 10px;
    color:#333;
    opacity: 0.8;
    font-size: 110px;
    }
    #motivatie{
     font-family: 'Lobster', sans-serif;
    padding-top: 10px;
    color:#436f6e;
    opacity: 0.8;
    font-size: 30px;
    }
  </style>
</head>

<body>
<div class="container" id="header">
  <center>Memories</center></div>
  <div class = "container" >
          <div class="panel panel-default">
        <div class="panel-body">
           <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
              <!-- Indicators -->
              <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
              </ol>

              <!-- Wrapper for slides -->
              <div class="carousel-inner" role="listbox">
                <div class="item active">
                  <img src="./img/home1.jpg" alt="..."class="img-responsive center-block">
                  <div class="carousel-caption">
                    ...
                  </div>
                </div>
                <div class="item">
                  <img src="./img/home2.jpg" alt="..."class="img-responsive center-block">
                  <div class="carousel-caption">
                    ...
                  </div>
                </div>
                  <div class="item">
                  <img src="./img/home3.jpg" alt="..."class="img-responsive center-block">
                  <div class="carousel-caption">
                    ...
                  </div>
                </div>
              </div>

              <!-- Controls -->
              <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>
        </div>
      </div>
      <div class= "row"> 
            <div class = "col-sm-4 col-sm-offset-4" >
          
               <a href="<%=fbConnection.getfbAuthUrl()%>"> <img
			style="margin-top: 50px; margin-bottom:100px;" src="http://campaign.5000s.org/views/images/fb-login-button.png" />
		</a>
              </div>
         
      </div>
  </div>
  <nav class="navbar navbar-default navbar-fixed-bottom">
  <div class="container">
   <p class="navbar-text"><span class="glyphicon glyphicon-copyright-mark" aria-hidden="true"></span>TheLastPerfectTeam</p>
   </div>
</nav>
      
  <!-- JQuery File-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
