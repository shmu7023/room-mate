<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body bgcolor="#E6E6FA">
</body>
  <head>
  <style>
.myButton {
	-moz-box-shadow:inset 0px 1px 0px 0px #a6827e;
	-webkit-box-shadow:inset 0px 1px 0px 0px #a6827e;
	box-shadow:inset 0px 1px 0px 0px #a6827e;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #7d5d3b), color-stop(1, #634b30));
	background:-moz-linear-gradient(top, #7d5d3b 5%, #634b30 100%);
	background:-webkit-linear-gradient(top, #7d5d3b 5%, #634b30 100%);
	background:-o-linear-gradient(top, #7d5d3b 5%, #634b30 100%);
	background:-ms-linear-gradient(top, #7d5d3b 5%, #634b30 100%);
	background:linear-gradient(to bottom, #7d5d3b 5%, #634b30 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#7d5d3b', endColorstr='#634b30',GradientType=0);
	background-color:#7d5d3b;
	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	border-radius:3px;
	border:1px solid #54381e;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:13px;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px 1px 0px #4d3534;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #634b30), color-stop(1, #7d5d3b));
	background:-moz-linear-gradient(top, #634b30 5%, #7d5d3b 100%);
	background:-webkit-linear-gradient(top, #634b30 5%, #7d5d3b 100%);
	background:-o-linear-gradient(top, #634b30 5%, #7d5d3b 100%);
	background:-ms-linear-gradient(top, #634b30 5%, #7d5d3b 100%);
	background:linear-gradient(to bottom, #634b30 5%, #7d5d3b 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#634b30', endColorstr='#7d5d3b',GradientType=0);
	background-color:#634b30;
}
.myButton:active {
	position:relative;
	top:1px;
}
</style>
    <title>Spring MVC login example.</title>
  </head>
  <body>
    <h2>${message}</h2>
    <h1 style="text-align: center;"><i>Almost done..</i></h1>
<h2 style="text-align: center;"> Enter OTP </h2>
<div style="text-align: center;">

<form method = post action=login.html>
<table align='center'>
<tr> <td><font size="5"> OTP: </font></td><td> <input type=text name="otp"></td></tr>
<tr> <td> <input type=submit class="myButton" value = "Submit" > </td></tr>


      
    </script>
</table>
</form>


</div>
    
  </body>
</html>