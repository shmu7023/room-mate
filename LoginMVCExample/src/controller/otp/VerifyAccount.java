package controller.otp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;

import controller.Global;
import controller.HibernateUtil;

public class VerifyAccount extends Otp {

	public VerifyAccount(){
		
		super();
		databaseType  = new NewUser();
		
	}
	public VerifyAccount(String tmp){
		
	}
	// validate new user
	public ModelAndView validateAccount(String email, String newPassword, String newPasswordRe,
		String fisrtName,String lastName,String dob,String gender){
		String message;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
			
	      if ( email != null &&  !email.equals("") 
					&& newPassword != null && !newPassword.equals("") 
					&& newPasswordRe != null &&  !newPasswordRe.equals("")
					&&  fisrtName!= null && !fisrtName.equals("")
					&& lastName != null &&  !lastName.equals("")
					&& dob != null &&  !dob.equals("")
					&& gender != null &&  !gender.equals("")){  // create new user
				if ( newPassword.equals(newPasswordRe)){ //push 
					try{
						Global.tempUserName = email;
						Global.tempPassword = newPassword;
						Global.firstName = fisrtName;
						Global.lastName = lastName;
						Global.dob = dob;
						Global.gender = gender; // this will eventually pushed to DB
						return sendEmailWrapper(email);
					}
					catch(Exception e){
						message = "Failed to send e-mail.Enter valid email.";
					    return new ModelAndView("errorPage", 
					    		  "message", message); 
					}
				}
				else{
					message = "Password did not match!";
					session.close();
					sessionFactory.close();
			    	  return new ModelAndView("errorPage", 
			    			  "message", message);
				}
				
			}
			else  {
				message = "Complete all fields to register";
				session.close();
				sessionFactory.close();
		    	  return new ModelAndView("errorPage", 
		    			  "message", message);
			}
	      
	}

}
