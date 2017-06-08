<?php
	if(!session_id()) {
		$_SESSION["nr"] = 0;
	}
	session_start();
	$_SESSION["nr"] = 0;
	header("Location: index.php");
  exit;

?>