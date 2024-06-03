package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	/*
	 * This Method is used to load the properties from config.properries file which is present in the resource folder
	 * @return the Properties prop object  
	 */
	
	public Properties init_prop()
	{
	   prop= new Properties();
		 try {
			FileInputStream ip= new FileInputStream("C:\\Users\\Dell\\Automation Software\\ProjectApril\\TestProject\\src\\test\\resources\\com\\qa\\config\\config.properties");
			prop.load(ip);
			
		    } 
		    catch (FileNotFoundException e) 
		    {
						e.printStackTrace();
		    } 
		    catch (IOException e) 
		     {
			     e.printStackTrace();
		     }
		
    return prop;
    
	}

}
