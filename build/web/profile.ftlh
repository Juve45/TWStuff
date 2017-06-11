<!DOCTYPE html>	
<html>
    <head>
        <meta charset="utf-8">
        <title>
            Profile
        </title>
    </head>


    <!--
    <script type="text/javascript">
            
            $(document).ready(function(){
                $(".media-box").click(function(){
                    $(this).toggleClass("col-lg-3 col-md-4 col-xs-6 col-xs-12");
                });
            });	
    </script>*-->

    <div class= "row"> 
        <div class = "col-sm-4 col-xs-4" id="img-panel">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">My Profile</h3>
                </div>
                <div class="panel-body">
                    <div class="media"> <img alt="Salut" src="${user.picURL}" class="img-responsive center-block"  style="width:150px"> </div>
                </div>
            </div>

        </div>

        <div class = "col-sm-8 col-xs-5">
            <div class="panel panel-default">
                <div class="panel-body">
                    ${user.name}
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    Faculty of Computer Science Iasi
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    ${user.fbId}
                </div>
            </div>

        </div>
    </div>

</html>