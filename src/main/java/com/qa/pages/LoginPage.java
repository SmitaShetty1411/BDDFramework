package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
 /*
  * By Locator
  * Constructor
  * PageActions
  */
	
	private WebDriver driver;
	
	//1. By Locator - Object Repository
	private By SignUpORLogin=By.xpath("//a[@href='/login']");
	private By LoginPageText=By.xpath("//h2[text()='Login to your account']");
	private By EmailAddress=By.xpath("//input[@data-qa='login-email']");
	private By Password=By.xpath("//input[@data-qa='login-password']");
	private By LoginButton=By.xpath("//button[@data-qa='login-button']");
	private By LoggedInUser=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
			
	//2.Constructor of the page class
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//3. Page Action
	public String VerifyUserisOnHomePage() 
	{
		return driver.getTitle();
	}
	
	public void NavigateToLoginPage()
	{
		 driver.findElement(SignUpORLogin).click();
		
		
	}
	
	public String VerifyTheLoginPageHeading()
	{
		return driver.findElement(LoginPageText).getText();
	}
	
	public void EnterTheEmailAddress(String username)
	{
		driver.findElement(EmailAddress).sendKeys(username);
	}
	public void EnterThePassword(String password)
	{
		driver.findElement(Password).sendKeys(password);
	}
	public void ClickOnLoginButton()
	{
		driver.findElement(LoginButton);
	}
	
	public String VerificationOfLoggedInUser() {
		
		return driver.findElement(LoggedInUser).getText();
	}
	
	public ProductPage doLogin(String un, String pwd)
	{
		driver.findElement(SignUpORLogin).click();
		driver.findElement(EmailAddress).sendKeys(un);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(LoginButton);
		return new ProductPage(driver);
	}
	
	
}
