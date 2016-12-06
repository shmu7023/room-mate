package controller;

import javax.persistence.Entity;
import controller.profile.UserProfile;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
@Entity
@Table(name="USER")
@Controller
public class User extends UserProfile
{
	@Id
	private String username;
	private String password;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
    public User(){}
    public User(String uname, String passwd,String fName,String lName, String dob, String gender){
    	this.setUsername(uname);
    	this.setPassword(passwd);
    	this.setFirstName(fName);
    	this.setLastName(lName);
    	this.setDob(dob);
    	this.setGender(gender);
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@RequestMapping("/buildProfile")   // when he cliks on edit profile, give him this response
	public ModelAndView login(HttpServletRequest request,
			   HttpServletResponse response){
		return new ModelAndView("buildProfile", 
	    		  "message", "Please provide your preferences and save");
	}
	
	@RequestMapping("/mainMenu") // grab his preferrences , push to DB
	public ModelAndView saveProfile(HttpServletRequest request,
			   HttpServletResponse response){
		String pts =request.getParameter("pts");
		String Rent_sltn =request.getParameter("Rent_sltn");
		String APT_SELECTION =request.getParameter("APT_SELECTION");
		String area =request.getParameter("area");
		String gndr =request.getParameter("gndr");
		String smkr =request.getParameter("smkr");
		String drnk =request.getParameter("drnk");
		String clns =request.getParameter("clns");
		String trsh =request.getParameter("trsh");
		String prty =request.getParameter("prty");
		String vgn =request.getParameter("vgn");
		String rm =request.getParameter("rm");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User userObj = session.get(controller.User.class, Global.tempUserName);
		userObj.setPets(pts);
		userObj.setSmoke(smkr);
		userObj.setDrink(drnk);
		userObj.setRent_sltn(Rent_sltn);
		userObj.setAPT_SELECTION(APT_SELECTION);
		userObj.setArea(area);
		userObj.setGndr(gndr);
	    userObj.setClns(clns);
	    userObj.setTrsh(trsh);
	    userObj.setPrty(prty);
	    userObj.setVgn(vgn);
	    userObj.setRm(rm);
		session.save(userObj);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		return new ModelAndView("welcome", 
	    		  "message", "Your preferences saved");
	}
	
}