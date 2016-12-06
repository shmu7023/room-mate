package controller.search;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.Global;
import controller.HibernateUtil;
import controller.User;

@Controller
public class Algorithm {
	@RequestMapping("/searchByEmail")
	public ModelAndView searchByEmail(HttpServletRequest request,HttpServletResponse response)
	{
		
		 String email=request.getParameter("email");
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			User userObj = session.get(controller.User.class, email);
			if ( userObj == null )
			{
				return new ModelAndView("welcome", "message", "Did not find any results for "+email); 
			}
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			return dumpUser(userObj);
		 
	}
	// dumps user variables to screen and also ones inherited from user profile
	public ModelAndView dumpUser(User obj)
	{
		String message;
		message =" Your match"+
		          " <br><br>Name	:"+ obj.getFirstName()+" "+obj.getLastName()+
		          "<br><br> Email ID	: " +obj.getUsername()+
		          "<br><br> Sex 	: " + obj.getGender()+
		          "<br><br> Profile Information <br><br>" +
				"Are you looking for an apartment 	:" + obj.getAPT_SELECTION() + 
				"<br><br>Which Area would you want to move in 	:" + obj.getArea() +
				"<br><br>Maximum Rent 	: " + obj.getRent_sltn() +
				"<br><br>Your Preferred Room-mate 	:" + obj.getGndr() + 
				" <br><br>Pets	:" + obj.getPets()+
                " <br><br>Smoking	:" + obj.getSmoke()+
                " <br><br>Drinking	:" + obj.getDrink()+
                " <br><br>Cleaning Dishes Preference	:" + obj.getClns()+
                " <br><br>Taking our trash preference	:" + obj.getTrsh()+
                " <br><br>Party Preference	:" + obj.getPrty()+
                " <br><br>Vegan Preference	:" + obj.getVgn()+
                " <br><br>Room Preference	:" + obj.getRm()
		            ;
		return new ModelAndView("dumpUser", "message", message); 
	}
	@RequestMapping("/searchByProfile")
	public ModelAndView searchByProfile(HttpServletRequest request,HttpServletResponse response)
	{
		
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 
	     User userObj = session.get(controller.User.class,Global.tempUserName);
	     int match = 0;
	     int index =0;
	     for ( int i=0; i <Global.index;i++)
		 {
			 // lets loopthough all available profiles
	    	 User tmpObj = session.get(controller.User.class,Global.userIdList[Global.index]);
	    	 
	    	 if ( tmpObj == null)
	    		 continue;
	    	// skip slef
	    	 if ( tmpObj.getUsername().equals(userObj.getUsername()))
				continue;
			//compare with current
	    	int tmp = checkMatch(tmpObj,userObj);
	    	if ( tmp > match)// note the highest with its position in the array
			{ 
	    		match = tmp;
	    		index =i;
	    	}
	    	 
	     }
	    if ( match == 0)
		{
	    	return new ModelAndView("dumpUser", 
		    		  "message", "Oops! No match found. Try changing your profile"); 
	    }
		//call closest match 
	     userObj = session.get(controller.User.class,Global.userIdList[index]);
	     session.getTransaction().commit();
	     session.close();
		sessionFactory.close();
		return dumpUser(userObj);
		 
	}
	
	// comapre attributes and return frequency
    int checkMatch( User a, User b)
	{
    	int val =0;
    	if ( a.getPets().equals(b.getPets()))
    		val++;
    	if ( a.getSmoke().equals(b.getSmoke()))
    		val++;
    	if ( a.getDrink().equals(b.getDrink()))
    		val++;
    	 if ( a.getArea().equals(b.getArea()))
    		  val++;
    		   
		if ( a.getRent_sltn().equals(b.getRent_sltn()))
    		  val++;
    		   
    	if ( a.getGndr().equals(b.getGndr()))
    		  val++;
    		   
    	if ( a.getClns().equals(b.getClns()))
    		  val++;
		if ( a.getTrsh().equals(b.getTrsh()))
    		  val++;
    	if ( a.getPrty().equals(b.getPrty()))
    		  val++;
		if ( a.getVgn().equals(b.getVgn()))
    		  val++;
    	if ( a.getRm().equals(b.getRm()))
    		  val++;
    		  
    	return val;
    		
    }
}
