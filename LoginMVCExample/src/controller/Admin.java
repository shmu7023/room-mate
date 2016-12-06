package controller;

public class Admin 
{
	private static Admin firstInstantiation = null;
	private final String test = "Hi, I am admin. This page will be replaced by DB stuff";
   
	private static boolean firstThread = true;   // for sync issues in multithreads
	
	private Admin() { }  // default constructor
	
	public static Admin getInstance() {
		if(firstInstantiation == null) 
		{
			if(firstThread)
			{
				firstThread = false;
				
				try 
				{
					Thread.currentThread();
					Thread.sleep(500);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			synchronized(Admin.class){  // lazy init
				if(firstInstantiation == null)  // let it initialize only ONCE
				{	
					firstInstantiation = new Admin();						
				}
			
			}
			
		}
		
		return firstInstantiation;
	}
	public String getTest() 
	{
		return firstInstantiation.test;
	}

	
}