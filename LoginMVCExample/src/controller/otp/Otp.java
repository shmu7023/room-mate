package controller.otp;

import java.util.Random;

import org.springframework.web.servlet.ModelAndView;

import controller.Email;
import controller.Global;

public  class Otp {
	
	public Database databaseType;
	 
	 // a warapper to generate rand no and send an email. save that in temp. Ideally it should be in DB
	public ModelAndView sendEmailWrapper(String email){
		Random rand = new Random();
		int val = rand.nextInt(999999);
		Global.tempOtp = String.valueOf(val);
		Email.sendEmail(email,"room-mate | OTP","Enter the following OTP to activate account\n"+Global.tempOtp);
		   
		return new ModelAndView("Otp", 
	    		  "message", "Check your mail for OTP");
	}
	/*
	public boolean matchOtp(String otp){
		if (Global.tempOtp.equals(otp) ){
			return true;
		}
		else{
			return false;
		}
	}
	*/
	public ModelAndView tryToWrite(){
		// this uses strategy design pattern. idea is to have this writeDB's behaviour change based  on sub classes
		//different methods are written in Database interface
		// based on the type of class, that behaviur is used.
		
		return databaseType.writeDb();
	 
		    }


}
