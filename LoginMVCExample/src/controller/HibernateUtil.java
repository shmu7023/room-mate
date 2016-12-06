package controller;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import org.hibernate.cfg.Configuration;
 
public class HibernateUtil 
{
	
    public static SessionFactory getSessionFactory() 
	{
     	
    	  Configuration configuration = new Configuration().configure();
    	  configuration.addAnnotatedClass(controller.User.class);
    	  configuration.configure();
    	  StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
    	
    	  .applySettings(configuration.getProperties());    	
           SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());    	
    	   return sessionFactory;
    	
	}
}

