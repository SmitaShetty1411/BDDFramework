//Author: Smita
//Hybrid Framework
package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// this package is to invoke the driver 
public class DriverFactory {

	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver= new ThreadLocal<>(); // for the parallel testing purpose
	/*
	 * This Method is used to initialize the threadlocal driver on the basis of the given browser
	 * @param browser
	 * @return this will return tldriver
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("The Provided browser value is: "+browser);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Automation Software\\ProjectApril\\TestProject\\Software\\chromedriver.exe");
		    //using WebDriverManager, you avoid compatibility issues and the hassle of manually managing driver binaries.
			tldriver.set(new ChromeDriver()); //Each thread running the test will have its own isolated instance of ChromeDriver, avoiding conflicts and ensuring thread safety
			
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup(); //using WebDriverManager, you avoid compatibility issues and the hassle of manually managing driver binaries.
			tldriver.set(new FirefoxDriver()); //Each thread running the test will have its own isolated instance of ChromeDriver, avoiding conflicts and ensuring thread safety
			
		}
		else if(browser.equals("safari"))
		{
			tldriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser value");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
		
	}
	
	/*
	 * This method is to get the driver with ThreadLocal
	 * 
	 */
	public static WebDriver getDriver() {
		return tldriver.get(); // this will return the webdriver whenever we call it 
	}
}
