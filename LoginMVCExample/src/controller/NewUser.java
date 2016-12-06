package controller;

import controller.otp.VerifyAccount;
import controller.otp.ResetAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// for new user 
@Controller
public class NewUser {
   @RequestMapping("/loginOtp")  
   public ModelAndView login(HttpServletRequest request,
		   HttpServletResponse response) {
	  String resetEmail=request.getParameter("resetEmail");
	  String newPassword=request.getParameter("newPassword");
      String newPasswordRe=request.getParameter("newPasswordRe");
      String email=request.getParameter("email");
      String firstName=request.getParameter("firstName");
      String lastName=request.getParameter("lastName");
      String dob=request.getParameter("dob");
      String gender=request.getParameter("gender");
	  
      // new user verification
      if ( email != null &&  !email.equals("") ){
        VerifyAccount vaObj = new VerifyAccount("");  // this is for the startegy pattern
        return vaObj.validateAccount(email,newPassword,newPasswordRe,firstName,lastName,dob,gender);
      }
      
	  // reset email, forget password option
      else if ( resetEmail != null &&  !resetEmail.equals("") ){
    	  ResetAccount raObj = new ResetAccount("");  // this is for the startegy pattern
          return raObj.validateReset(resetEmail);
      }
  		
      else{
    	  return new ModelAndView("errorPage", 
    		  "message", "Enter valid details");
      }	 
   }
}
