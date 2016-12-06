package controller;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Global 
{  // global class which holds temp vars used for validation
	public static String tempUserName;
	public static String tempPassword;
	public static String tempOtp;
	public static boolean resetAccountFlag = false;
	public static String firstName;
	public static String lastName;
	public static String dob;
	public static String gender;
	public static User tempUserObj;
	public static String[] userIdList;
	public static int index=0;
    
	
	public static Session initSession()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	 //saves duplicate code
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
		
	}
	
}
