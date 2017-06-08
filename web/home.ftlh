<!DOCTYPE html>	
<html>

    <head>
        <meta charset="utf-8">
        <title>
            Profile
        </title>

        <base href=${root + "/web"}>

    </head>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">
                    <img src="a.jpg">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>


    <div class="container-fluid">
        <div class= "row row-eq-height" id="main-row">
            <!-- Foldeeeers--------------------------------------------------------->
            <#list folders as folder>
            <#if folder.type=="folder">
                <a href ="${startPath + folder.path+"/"+folder.name}">
                    <div class = "col-lg-3 col-md-4 col-xs-6 folder-box">
                        <div class="panel panel-default folder-panel">
                            <div class="panel-body">
                                <div class="media"><img src="folder.png" class="img-responsive center-block folder-img"  style="width:auto"></div>
                            </div>
                            <div class="panel-footer">${folder.name}</div>
                        </div>
                    </div>
                </a>
            </#if>
            </#list>


            <!-- Other resources ---------------------------------------->
            
            
            <!-- Foldeeeers--------------------------------------------------------->
            <#list folders as res>
            <#if res.type=="image">
               <div class = "col-lg-3 col-md-4 col-xs-6 media-box">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="media"><img src=${res.dataPath} class="img-responsive center-block clickable-image"  style="width:auto"></div>
                    </div>
                    <div class="panel-footer">${res.name}</div>
                </div>
            </div>
            
            <div class="modal fade" id="enlargeImageModal" tabindex="-1" role="dialog" aria-labelledby="enlargeImageModal" aria-hidden="true">
                <div class="modal-dialog modal-md" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            ${res.name}
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        </div>
                        <div class="modal-body">
                            <img src="" class="enlargeImageModalSource" style="width: 70%" >
                        </div> <div class="modal-footer"><span class="form-control-static pull-left">
                                <button type="button" class="btn btn-info" aria-label="Left Align">tag1 </button> 
                                <button type="button" class="btn btn-info" aria-label="Left Align" >tag2</button>
                                <button type="button" class="btn btn-info" aria-label="Left Align" >tag3</button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <#elseif res.type="video">
            
            
            <div class = "col-lg-3 col-md-4 col-xs-6 media-box">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <video id="my-vid" class=" video center-block"  src=${res.dataPath}  data-video=${res.dataPath} data-toggle="modal" data-target="#videoModal" ></video>
                    </div>

                    <div class="panel-footer">${res.name}</div>

                </div>
            </div>

            <div class="modal fade" id="videoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            ${res.name} 
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        </div>
                        <div class="modal-body">

                            <video width="100%" height="350" src="" frameborder="0" allowfullscreen controls></video>
                        </div>
                        <div class="modal-footer"><span class="form-control-static pull-left">
                                <button type="button" class="btn btn-info" aria-label="Left Align">tag1 </button> 
                                <button type="button" class="btn btn-info" aria-label="Left Align" >tag2</button>
                                <button type="button" class="btn btn-info" aria-label="Left Align" >tag3</button>
                            </span>


                        </div>
                    </div>
                </div>
            </div>
            <#elseif res.type=="document">
            
            <div class = "col-lg-3 col-md-4 col-xs-6 media-box">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="media"><a href=${res.dataPath}> <img data=${res.dataPath} type="application/pdf" src="pdf.png" class="img-responsive center-block clickable-image"  style="width:auto"></a></div>	
                    </div>
                    <div class="panel-footer">${res.name}</div>
                </div>
            </div>
            <div class="modal fade" id="enlargeImageModal" tabindex="-1" role="dialog" aria-labelledby="enlargeImageModal" aria-hidden="true">
                <div class="modal-dialog modal-md" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            ${res.name}
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        </div>
                        <div class="modal-body">
                            <img src="" class="enlargeImageModalSource" style="width: 70%" >
                        </div> <div class="modal-footer"><span class="form-control-static pull-left">
                                <button type="button" class="btn btn-info" aria-label="Left Align">tag1 </button> 
                                <button type="button" class="btn btn-info" aria-label="Left Align" >tag2</button>
                                <button type="button" class="btn btn-info" aria-label="Left Align" >tag3</button>
                            </span>


                        </div>
                    </div>
                </div>
            </div>

            </#if>
            </#list>
          


        </div>
        <button type="button" class="btn btn-default" id="more-btn"> Load more..</button>
    </div>
</html>