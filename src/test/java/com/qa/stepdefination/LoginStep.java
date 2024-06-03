package com.qa.stepdefination;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

	
	LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on HomePage {string}")
	public void VerifyUserisOnHomePage(String ExpectedTitle) {
		
		DriverFactory.getDriver().get("https://automationexercise.com/");
		   // Explicit wait for the title to contain the expected text
	    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains(ExpectedTitle));

	    // Verify the page title
	    String HomePageTitle = loginpage.VerifyUserisOnHomePage();
	    System.out.println("Title of the Homepage: "+HomePageTitle);
	    Assert.assertTrue(HomePageTitle.contains(ExpectedTitle));
	}

	@Given("Click on Login button")
	public void click_on_login_button_from_HomePage() {
	    loginpage.NavigateToLoginPage();
	    System.out.println("Succesfully clicked on Login/Signin button");
	}

	@When("Verify {string} is visible")
	public void verify_the_navigation_to_loginPage(String ExpectedHeading) {
	 
	  String LoginPageHeading=loginpage.VerifyTheLoginPageHeading();
	  System.out.println("Heading of the LoginPage: "+LoginPageHeading);
	  Assert.assertTrue(LoginPageHeading.contains(ExpectedHeading));
	}

	@When("Enter correct {string} and {string}")
	public void enter_correct_email_and_password(String email, String pwd) {
	   loginpage.EnterTheEmailAddress(email);
	   loginpage.EnterThePassword(pwd);
	   
	}

	@When("Click login button")
	public void click_login_button() {
		
		loginpage.ClickOnLoginButton();
	   
	}

	@Then("Verify that {string} is visible")
	public void verify_that_is_visible(String Expectedusername) {
	  String username=  loginpage.VerificationOfLoggedInUser();
	   Assert.assertTrue(username.contains(Expectedusername));
	}

	@Then("Verify error {string} is visible")
	public void verify_error_is_visible(String string) {
	  
	}

	


}
