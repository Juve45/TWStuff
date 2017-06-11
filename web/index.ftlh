<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Page Title</title>
        <meta charset="UTF-8">

        <base href=${root + "/web"}>
              <link rel="stylesheet" type="text/css" href="style2.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!--script src="jquery.min.js"></script-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script src="folder.js"></script>

    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="row">

                <div class="col-lg-1 col-lg-offset-1 col-md-1 col-xs-1"> 
                    <button type="button" class="btn btn-inverse" aria-label="Left Align">
                        <span class="glyphicon glyphicon glyphicon-home" aria-hidden="true"></span>
                    </button>  		
                </div>

                <div class="col-lg-6 col-md-7 col-xs-7"> 
                    <div class="input-group" id="bara_cautare">
                        <input type="text" class="form-control" placeholder="Cauta-ma!">
                        <div class="input-group-btn">
                            <button class="btn btn" type="submit">
                                <i class="glyphicon glyphicon-search "></i>
                            </button>
                        </div>
                    </div>
                </div>


                <div class="col-lg-2 col-md-2 col-xs-2">
                    <!--button class="btn glyphicon"-->
                             <img src="${user.picURL}" class="img-rounded" alt="Profile pic" style="width:36px">
                    <!--/button-->
                    <!--button type="button" class="btn btn-default" aria-label="Right Align">
                        <span class="glyphicon glyphicon-user"></span>
                    </button-->
                    <span id="user">${user.name}</span>
                </div>

                <div class="col-lg-1 col-md-2 col-xs-2">
                    <div  class="pull-right" >
                        <button type="button" class="btn btn-basic" aria-label="Right Align">
                            <span class="glyphicon glyphicon-log-out"></span>Log out
                        </button>
                    </div>
                </div>

            </div>
        </nav>

        <!-- End of top nav bar  -->

        <div class="row first-row">

            <div class="col-lg-2 col-lg-offset-1 col-md-3 col-sm-3" id="left-menu">
                <div class="sidebar-nav">

                    <div class="navbar navbar-default" role="navigation" >
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <span class="visible-xs navbar-brand">Menu</span>
                        </div>

                        <div class="navbar-collapse collapse sidebar-navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="page/home">Home</a></li>
                                <li><a href="page/profile">Profile</a></li>
                                <li><a href="page/search">Advanced Search</a></li>
                                <li><a href="page/add">Add Media</a></li>
                                <li><a href="page/family">My family</a></li>
                                <li><a href="page/about">About us </a></li>
                            </ul>
                        </div><!--/.nav-collapse -->

                    </div>

                </div>

            </div>

            <#assign str = root + "/page">
            <div class="col-lg-8 col-md-9 col-sm-9" id="central-container">
                <ol class="breadcrumb" id="nav-path">
                    <#list navItem as item>
                    <#assign str = str+"/"+item>
                    <li class="top-nav-item"><a href=${str}>${item}</a></li>
                    </#list>
                </ol>

                <div class="panel panel-default">
                    <div class="panel-heading" id="main-frame">

                        <!-- Editable space ^^ -->

                        <#include page>
                        <!-- End of editable space ^^ -->

                    </div>
                </div>




            </div>
        </div>
        <nav id="bara_jos" class="navbar navbar-inverse navbar-fixed-bottom" >
            <div class="container">
                <p class="navbar-text"><span class="glyphicon glyphicon-copyright-mark" aria-hidden="true"></span>TheLastPerfectTeam</p>
            </div>
            +</nav>
    </body>

</html>