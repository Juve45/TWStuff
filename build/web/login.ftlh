<!DOCTYPE html>
<html>
    <head>
        <base href=${root + "/web"}>
              <title>Facebook Login JavaScript Example</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <script>
            // This is called with the results from from FB.getLoginStatus().
            function statusChangeCallback(response) {
                console.log('statusChangeCallback =========');
                console.log(response);
                // The response object is returned with a status field that lets the
                // app know the current login status of the person.
                // Full docs on the response object can be found in the documentation
                // for FB.getLoginStatus().
                if (response.status === 'connected') {

                    console.log(response.authResponse.accessToken);
                    var x = $.post('${"http://localhost:8080"+root+"/API/facebookLogin"}', {'name': "John", 'accessToken': response.authResponse.accessToken}, function (data) {
                        console.log("session recieved: " + data);
                        $.post('${"http://localhost:8080"+root+"/page/session"}', {'session': data});
                        //testAPI();
                        window.location.replace('${"http://localhost:8080"+root+"/page/home"}');
                        //trimit la serverul de front end/
                    });
                    // Logged into your app and Facebook.
                    testAPI();
                    //window.location.replace('${"http://localhost:8080"+root+"/page/home"}');
                } else {
                    console.log("not logged in yet!");
                    // The person is not logged into your app or we are unable to tell.
                    document.getElementById('status').innerHTML = 'Please log ' +
                            'into this app.';
                }
            }



            // This function is called when someone finishes with the Login
            // Button.  See the onlogin handler attached to it in the sample
            // code below.
            function checkLoginState() {
                FB.getLoginStatus(function (response) {
                    statusChangeCallback(response);
                    //window.location.replace('${"http://localhost:8080"+root+"/page/home"}');
                });
            }

            window.fbAsyncInit = function () {
                FB.init({
                    appId: '630154653854447',
                    channelUrl: '${"http://localhost:8080/"+root}',
                    cookie: true, // enable cookies to allow the server to access 
                    xfbml: true, // parse social plugins on this page
                    version: 'v2.9' // use graph api version 2.8
                });


                FB.login(function (response) {
                    if (response.authResponse) {
                        console.log('Welcome!  Fetching your information.... ');
                        FB.api('/me', function (response) {
                            console.log('Good to see you, ' + response.name + '.');
                            //statusChangeCallback(response);
                        });
                    } else {
                        console.log('User cancelled login or did not fully authorize.');
                    }
                });

                FB.getLoginStatus(function (response) {
                    statusChangeCallback(response);
                });

            };

            // Load the SDK asynchronously
            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));

            // Here we run a very simple test of the Graph API after login is
            // successful.  See statusChangeCallback() for when this call is made.
            function testAPI() {
                console.log('Welcome!  Fetching your information.... ');
                FB.api('/me', function (response) {
                    console.log('Successful login for: ' + response.name);
                    document.getElementById('status').innerHTML =
                            'Thanks for logging in, ' + response.name + '!';
                    //window.location.replace('${"http://localhost:8080"+root+"/page/home"}');

                });
            }

        </script>

        <!DOCTYPE html>
    <html>
        <head>
            <title>Home Page</title>
            <meta charset="utf-8">
            <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet'  type='text/css'>
            <link href='http://fonts.googleapis.com/css?family=Meriweather' rel='stylesheet'  type='text/css'>

            <//link rel="stylesheet" type="text/css" href="myProfileStyle.css">

            <//link rel="stylesheet" type="text/css" href="style2.css">
            <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

            <!-- Optional theme -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
            <style type="text/css">
                body{background-image:url("img/back2.png");}
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
                                    <img src="home1.jpg" alt="..."class="img-responsive center-block">
                                    <div class="carousel-caption">
                                        ...
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="home2.jpg" alt="..."class="img-responsive center-block">
                                    <div class="carousel-caption">
                                        ...
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="home3.jpg" alt="..."class="img-responsive center-block">
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
                    <center>

                        <div class="fb-login-button"  class="border-bottom-3" data-max-rows="1"
                             data-size="large" data-button-type="continue_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="false" onlogin="checkLoginState();">
                        </div> 
                    </center>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>


                    <div id="status">
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



</body>
</html>