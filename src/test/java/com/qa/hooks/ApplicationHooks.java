/*
 * Author: Smita Shetty
 * 
 */

package com.qa.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;	
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0) // to read the config file and get browser name
	public void getProperty() 
	{
		
		configReader= new ConfigReader();
		
		prop=configReader.init_prop();
	
	}
	
	
	@Before(order=1)
	public void launchBrowser()
	{
		String BrowserName=prop.getProperty("Browser");
		
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(BrowserName);
	}
	
	@After(order=0)
	public void QuitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//take screenshot
			String ScreenshotName=scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", ScreenshotName);
		}
	}
	
	
	
}
