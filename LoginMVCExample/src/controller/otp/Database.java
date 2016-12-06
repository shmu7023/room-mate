package controller.otp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;

import controller.Global;
import controller.HibernateUtil;
import controller.User;
import controller.Admin;

public interface Database {
	// method for strategy design pattern.
	// This can be used in 3 ways based on sub class behaviour.
	// overriding at every children produces code duplication
	// this is a better  design
	// every one is writing to DB. But their way of handling is different. Hence strategy.
	// all return ModelAndView which is returned back to the browser
	ModelAndView writeDb();
   
}

// Class used for new user
//writes  new username and password to DB 
class NewUser implements Database{

	public ModelAndView writeDb() {
		String message;
		
		 	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
			Session session = sessionFactory.openSession();
			session.beginTransaction();
		
			try{
	    		  User user = new User(Global.tempUserName, Global.tempPassword,Global.firstName,
	    				  Global.lastName,Global.dob,Global.gender);
					session.save(user);
					session.getTransaction().commit();
					session.close();
					sessionFactory.close();
					message = "Success! Added " +Global.tempUserName + " to DB! Login with your new credentials.";
					
	    		  }
	    		  catch(Exception e){
	    			  message = "Failed! Email already exists.";
				      
	    		  }
	    		  return new ModelAndView("errorPage", 
			    		  "message", message);
		
		
	}
	
}

//Class used for restting password for user
// only writes  password to DB for an existig username in Global.tempUserName
class ResetUser implements Database{

	public ModelAndView writeDb() {
		String message;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User userObj = session.get(controller.User.class, Global.tempUserName);
		userObj.setPassword(Global.tempPassword);
		session.save(userObj);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		message = "Successfully reset password! Login in with your new credentials.";
		//session.close();
		//sessionFactory.close();
    	  return new ModelAndView("errorPage", 
    			  "message", message);
				
	}

}

// class used to compare username and password with database. input username and passwd are in global temp class
class LoginUser implements Database{

	public ModelAndView writeDb() {
		String message;
		
		
	if ( Global.tempUserName == null || Global.tempUserName.equals("") 
			|| Global.tempPassword == null || Global.tempPassword.equals("") 
			){
		message = "Enter Valid credentials";
    	  return new ModelAndView("errorPage", 
    			  "message", message);
	}
	if ( Global.tempUserName.equals("admin") && Global.tempPassword.equals("room-mate")   ){
		Admin adminObj = Admin.getInstance();
		return new ModelAndView("welcome", 
	    		  "message", Global.tempUserName+ "\n"+adminObj.getTest());

	}
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	User userObj = session.get(controller.User.class, Global.tempUserName);
	session.close();
	sessionFactory.close();
	
	 if ( userObj == null) {
	  message = "Username does not exist";
	  return new ModelAndView("errorPage", 
			  "message", message);
	  
  }
  else if(
		  Global.tempPassword.equals(userObj.getPassword())){
	  Global.tempUserObj = userObj;
      return new ModelAndView("welcome", 
    		  "message", Global.tempUserName);  
	  	    	  
  }else{
	  message = "Invalid Password";
	  return new ModelAndView("errorPage", 
			  "message", message);
  }
				
	}

}