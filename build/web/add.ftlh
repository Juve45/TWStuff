 <!DOCTYPE html>
    
    <head>
      <meta charset="utf-8">
      <title>
        Profile
      </title>
  <link rel="stylesheet" href="//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.css" />
  <script src="//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.min.js"></script> <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Spinner - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="/resources/demos/external/jquery-mousewheel/jquery.mousewheel.js"></script>
<script>
$(function() {

  $(document).on('change', ':file', function() {
    var input = $(this),
        numFiles = input.get(0).files ? input.get(0).files.length : 1,
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [numFiles, label]);
  });


  $(document).ready( function() {
      $(':file').on('fileselect', function(event, numFiles, label) {

          var input = $(this).parents('.input-group').find(':text'),
              log = numFiles > 1 ? numFiles + ' files selected' : label;

          if( input.length ) {
              input.val(log);
          } else {
              if( log ) alert(log);
          }

      });
  });
  
});

</script>
<script>
    $(function() {
        $('#spinner').spinner({
            min: 1,
            max: 31,
            step: 1
        });
    });
</script>

    </head>
         <div class="row">
         <div class="input-group col-sm-10 col-sm-offset-1">
          <h1><font face="verdana"  size= "5.5" color="Gray"><b>Add item</b> </font> </h1>

          <br>
          <br></div></div>
          <div class="row">
              <div class="input-group col-sm-10 col-sm-offset-1">
                <label class="input-group-btn">
                    <span class="btn btn-primary">
                        Browse&hellip; <input type="file" style="display: none;" multiple>
                    </span>
                </label>
                <input type="text" class="form-control" readonly>
            </div>
            <br>
            </div>

             <div class="row">


            <div class="input-group col-sm-10 col-sm-offset-1">
                
                    <span class="input-group-addon" id="basic-addon3">Title</span>
                
                <input type="text"  id="tags" class="form-control">
            </div>
            <br>
            </div>
            
 <div class="row">

            <div class="input-group col-sm-10 col-sm-offset-1">
                
                    <span class="input-group-addon" id="basic-addon3">Location</span>
                <input type="text"  id="tags" class="form-control">
            </div>
            </div>
            <br>
            
      <div class="form-group row">
        <div class="input-group col-sm-10 col-sm-offset-1">
       <span class="input-group-addon" id="basic-addon3">Date</span>
          <input class="form-control" type="date" value="2017-01-01" id="example-date-input">
        </div>

      </div>
              <div class="row">


            <div class="input-group col-sm-10 col-sm-offset-1">
               
                    <span class="input-group-addon" id="basic-addon3">Tags</span>
              
                <input type="text" data-role="tagsinput" id="tags" class="form-control">
            </div>
            </div>

            <div class="row">
            <br>
        <center><button type="button" class="btn btn-info">Upload</button></center>
        </div>
        <br>
        
        <button class="btn btn-default">
            <a href = "https://api.vimeo.com/oauth/authorize?client_id=67ad6df17d16051fcd58414af180d6a85c2f0c6d&response_type=code&redirect_uri=http://localhost:8080/BackEndServer/API/vimeo&state=XXXXXX">
            <img src=${root+ "/img/vimeo.png"} width="100" > From Vimeo!
            </a>
</button>
        



