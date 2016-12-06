<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Spring MVC login example.</title>
  </head>
  
  <body background='background.jpg' style=\"background-color:lightgrey\">
<h1 style="text-align: center;"><i>Welcome to Room Mate</i></h1>
<h2 style="text-align: center;"> Enter credentials to get started!</h2>
<div style="text-align: center;">

<form method = post action=login.html>
<table align='center'>
<tr> <td> Username/Email: </td><td> <input type="text" name="userName" value="" ></td></tr>
<tr> <td> Password: </td><td> <input type="password" name="password" value="" ></td></tr>
<tr> <td> <input type=submit value = "Login" > </td></tr>
</table>
</form>

<form method = post action=loginOtp.html>
<table align='center'>
<tr> <td><br><h4 style="text-align:center;">New User? Register</h4></br> </td> </tr>
<tr> <td> email ID: </td><td> <input type=text name="email" ></td></tr>
<tr> <td> Password: </td><td> <input type=password name="newPassword" ></td></tr>
<tr> <td> Re - Password: </td><td> <input type=password name="newPasswordRe"></td></tr>
<tr> <td> First Name: </td><td> <input type=text name="firstName"></td></tr>
<tr> <td> Last Name: </td><td> <input type=text name="lastName"></td></tr>
<tr> <td> DOB: </td><td> <input type=text name="dob"></td></tr>
<tr> <td> Sex: </td><td> <input type=text name="gender"></td></tr>
<tr> <td> <input type=submit value = "Submit" > </td></tr>
</table>
</form>
<form method = post action=loginOtp.html>
<table align='center'>
<tr> <td><br><h4 style="text-align:center;">Forgot Password? Enter your email to reset</h4></br> </td> </tr>
<tr> <td> E-mail: </td><td> <input type="text" name="resetEmail" value="" ></td></tr>
<tr> <td> <input type=submit value = "Recover" > </td></tr>
</table>
</form>


</div>
</body>
</html>