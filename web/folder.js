

//Functia care incarca un folder
/*
$(function() {
      $('body').on('click', '.folder-panel', function() {
      	$("#main-frame").fadeToggle(300);
      	//await sleep(100);

      	var fnc = ((k) =>{return () => {$("#main-frame").load($(k).attr('data-href'));}})(this)
      	setTimeout( fnc, 300);
      	//$("#main-frame").load($(this).attr('data-href'));
      	$("#main-frame").fadeToggle(300);
      	var href=$(this).attr('data-href');
      	var name=$(this).attr('data-name');
      	$("#nav-path").append('<li data-href="'+href+'" class="top-nav-item"><a href="#">'+name+'</a></li>');
    });
});
*/
//Functia care face pop up la o imagine
 $(function() {
	
	$('body').on('click', '.clickable-image', function() {
    $('.enlargeImageModalSource').attr('src', $(this).attr('src'));
    $('#enlargeImageModal').modal('show');
  });
});


//Changes the top navbar when the page is changed from left menu. 
 $(function() {	
	$('body').on('click', '.navbar-nav li', function() {
		var tmp = $(this).find('a').html();
		var href = $(this).attr('data-href');
		$('#nav-path').html('<li data-href="'+href+'" class="top-nav-item"><a href="#">'+tmp+'</a></li>');
  });
});



// Deschide un video
$(function() {
    $('div').on('click', '.video', function () {
    	
      var theModal = $(this).data("target"),
      videoSRC = $(this).attr("data-video"),
      videoSRCauto = videoSRC + "?modestbranding=1&rel=0&controls=0&showinfo=0&html5=1";

      $(theModal + ' video').attr({'src': videoSRCauto});
      //$('iframe').attr('src', $('iframe').attr('src'));
      $(theModal + ' button.close').click(function () {
      	
      $(theModal + ' video').attr({'src': videoSRC, 'id':'yplayer'});
      
      //document.getElementById('yplayer').src = document.getElementById('yplayer').src;
      
      });
    });
  });




//adauga elemente pe pagina, in continuarea query-ului de la search

$(function(){
    	
    var tmp = "";
    $.get("tmp.html", function(response) {
     tmp = response;
		});

    $('body').on('click', '#more-btn', function(){
      $("#main-row").append(tmp);
    });
});
/*
//adauga elemente pe pagina de la advandced search
$(function(){
    	
    $('body').on('click', '#search-btn', function(){
      $("#main-row-search").load("home.html");
    });
});

*/

function loadSearch() {
      $("#main-row-search").load("home.html");
}



// Pnetru orice element dintr-o lista (meniu) incarc pagina aratata de acel element, daca exista
	//FIXME: 'li' -> trebuie pus ceva mai precis
	$(function(){
	    $('body').on('click', 'li', function(){

	        $("#main-frame").load($(this).attr("data-href"));
	        $("li").removeClass("active");
	        $(this).addClass("active");
	    });


	});


/*
	$(function(){	  
	    $('body').on('click', '.top-nav-item', function(){
	    	//$(this).append("afsdf");
	    	$(this).nextAll().remove();
	        //window.history.pushState('page2', 'Title', './'+$(this).attr("data-href"));
	    });
	});
*/

/*
	    $("li").click(function(){
	        $("#main-frame").load($(this).attr("data-href"));
	        $("li").removeClass("active");
	        $(this).addClass("active");
	        //window.history.pushState('page2', 'Title', './'+$(this).attr("data-href"));
	    });*/



