
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Salut</title>
	<link rel="stylesheet" type="text/css" href="family.css">
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
</head>
<body>

<div class="row">
<div class="tree">
	<ul>
  <li data-href="profile.html">
    <a href="#">Me</a>
    <ul>
      <li data-href="profile1.html">
        <a href="#" data-toggle="tooltip" title="Hooray!">Alexandra Mititica</a>
        <ul>
          <li><a href="#">Grand Child</a></li>
          <li><a href="#">Grand Child</a></li>
        </ul>
      </li><li data-href="profile1.html">
        <a href="#">Child</a>
        <ul>
          <li>
            <a href="#">Grand Child</a>
            <ul>
              <li data-href="profile2.html">
                <a href="#">Maria Borcan</a>
              </li>
            </ul>
          </li><li>
            <a href="#">Grand Child</a>
          </li>
        </ul>
      </li>
    </ul>
  </li>
</ul>
</div>
</div>
</body>
</html>
