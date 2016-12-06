package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Logout
{
   @RequestMapping("/logout")  
   public ModelAndView login(HttpServletRequest request,
		   HttpServletResponse response)
	{   
	   HttpSession session = request.getSession();
	   session.invalidate(); 	 // destroy session
	   return new ModelAndView("errorPage", 
	    			  "message", "Sucessfully logged out");
    	 
     
   }
}
