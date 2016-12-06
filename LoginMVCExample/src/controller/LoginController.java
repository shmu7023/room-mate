package controller;

import controller.Global;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.otp.Otp;
import controller.otp.VerifyAccount;
import controller.otp.LoginAccount;
//public String val="";

// main page for login
@Controller
public class LoginController
{
   @RequestMapping("/login")  
   public ModelAndView login(HttpServletRequest request,HttpServletResponse response) 
   {
	  String userName=request.getParameter("userName");  
      String password=request.getParameter("password");
      String otp =request.getParameter("otp");
      String message;

   
		  if ( otp != null &&  !otp.equals("") )
		  {
	    	  if ( otp.equals(Global.tempOtp))
			  {
	    		  if ( Global.resetAccountFlag == true )
				  {
	    			  Global.resetAccountFlag = false;
	    			  message = "Enter your new password";
		    		  return new ModelAndView("resetPassword", "message", message);
	    			  
	    		  }
	    		  
	    		  Otp verifyObj = new VerifyAccount();
	    		  return verifyObj.tryToWrite();
	    	  }
	    	  else
			  {
	    		  message = "Failed! OTP Did not match.";
	    		  return new ModelAndView("errorPage", "message", message);
	    	  }
	      }
		  	  
		// returning user now
		
		Global.tempUserName = userName;
		Global.tempPassword = password;
		Otp laObj = new LoginAccount();
		return laObj.tryToWrite();
		   	 
   }
}
