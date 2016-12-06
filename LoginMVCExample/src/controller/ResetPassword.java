package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import controller.otp.Otp;
import controller.otp.ResetAccount;

@Controller
public class ResetPassword {
   @RequestMapping("/resetPassword")  
   public ModelAndView login(HttpServletRequest request,
		   HttpServletResponse response) {
	      String newPassword=request.getParameter("newPassword");
	      String newPasswordRe=request.getParameter("newPasswordRe");
	     
     if (	 newPassword != null && !newPassword.equals("") 
				&& newPasswordRe != null &&  !newPasswordRe.equals("")){  // create new user
			if ( newPassword.equals(newPasswordRe)){ //push ) 
				Global.tempPassword = newPassword;
			//in this case, tryToWrite writes to DB in a diffrent way. It just resets the password, instead of setting both.
			//that is not the case with tryToWrite when it comes to Verify password and login user
			// Hence strategy design pattern
				Otp resetObj = new ResetAccount();
	    		return resetObj.tryToWrite();
				
			}
			else{
		    	return new ModelAndView("resetPassword", 
		    			  "message", "Password did not match!");
			}
     }
     else{
	    	  return new ModelAndView("resetPassword", 
	    			  "message", "Enter Valid password!");
    	 
      }
   }
}
