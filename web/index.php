<!DOCTYPE html>
<html>
	<head>
		<title>TW</title>

		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
<body>


  	<div id="header" >
		  <div class="cl_div_header">
		    <h1 id="sigla">D!v@</h1>
		  </div>
		 			<div class="input-group">
		        <input type="text" class="form-control" placeholder="Search">
		        <div class="input-group-btn">
		          <button class="btn btn-default" type="submit">
		            <i class="glyphicon glyphicon-search"></i>
		          </button>
		        </div>
		      </div>
	</div>

	
	<div id="content">

  	<div class="vertical-menu" id="meniu_vertical_stanga">
 		<a href="#" >Home</a>
 		<a href="#">Profile</a>
  		<a href="#">Photos</a>
  		<a href="#">Tree</a>
  		<a href="#">New Item</a>
		</div>


	<div id="container">

	<form action="index.php"> 
	<input type="submit" name="GO">
	</form>
	<?php
		$dbconn = pg_connect("dbname=tw host=localhost port=5432 user=alexandru password=123qwe");
		$result = pg_query($dbconn, "SELECT * FROM resource");
		$arr = pg_fetch_all($result);
		foreach ($arr as $v) 
		{
			$tmp = '<div class="panel-heading"> <b>'.$v['type'].'</b></div> <div class="panel-body"><img width=80px src="'.$v['resource_file_link'].'"><br>'.$v['tag'];
			echo '<div class="panel panel-default">  '.$tmp.'</div></div>';
		}
	?>
	

    </div>

	</div>

</div>


</body>
</html>