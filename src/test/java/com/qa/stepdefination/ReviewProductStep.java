package com.qa.stepdefination;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import com.qa.pages.ReviewPage;
import com.qa.util.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReviewProductStep {

	LoginPage loginpage=new LoginPage(DriverFactory.getDriver()); //This is creating a new instance of the LoginPage class and passing a WebDriver instance to its constructor.
	ProductPage productdetail=new ProductPage(DriverFactory.getDriver());
	ReviewPage reviewPage=new ReviewPage(DriverFactory.getDriver());
	
	@Given("User has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable LoginCredential) {
	  
		List<Map<String,String>> LoginCred=LoginCredential.asMaps(); // you are taking the username and pwd from the datable of the fetaure file
		String un=LoginCred.get(0).get("Username"); //based on the index get the value given for both username and pwd
		String pwd=LoginCred.get(0).get("Password");
		DriverFactory.getDriver().get("https://automationexercise.com/"); //call the url
		productdetail= loginpage.doLogin(un, pwd);
	}

	
	@Given("User has selected product to review")
	public void user_has_selected_product_to_review() {
		reviewPage.ClickOnProduct();
	}

	@When("user fills the review given from the sheetname {string} and rowNumber {int}")
	public void user_fills_the_review_given_from_the_sheetname_and_row_number(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	  ExcelReader excelreader=new ExcelReader();
	  List<Map<String,String>> testdata= excelreader.getData("C:\\Users\\Dell\\Automation Software\\ProjectApril\\TestProject\\Excel\\Automation.xlsx", SheetName);
	 
	}

	@When("clicks on submitt button")
	public void clicks_on_submitt_button() {
	   
	}

	@Then("user should see the message {string} on the page")
	public void user_should_see_the_message_on_the_page(String string) {
	    
	}

}
