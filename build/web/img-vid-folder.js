
	$(document).ready(function(){
    	
    var tmp;
    $.get("tmp.html", function(response) {
     tmp = response;
		});
    $("#more-btn").click(function(){
	        $("#main-row").append(tmp);
	    });
});