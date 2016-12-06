package controller.otp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;

import controller.Global;
import controller.HibernateUtil;
import controller.User;

public class ResetAccount extends Otp{
public ResetAccount(){
		
		super();
		databaseType  = new ResetUser();
		
	}
  public ResetAccount(String temp){
	  
  }
  // validate reset password 
  public ModelAndView validateReset(String resetEmail){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    User userObj = session.get(controller.User.class, resetEmail);
		session.close();
		sessionFactory.close();
		
		 if ( userObj == null) {
		 
  	      return new ModelAndView("errorPage", 
  			  "message", "Username does not exist");
		 }
		   Global.tempUserName = resetEmail;
		   Global.resetAccountFlag = true; // to diiferentiate betn account reset otp and otp for new user
		   return sendEmailWrapper(resetEmail);
    }
  }

