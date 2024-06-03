package com.qa.stepdefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsStep {

	LoginPage loginpage=new LoginPage(DriverFactory.getDriver()); //This is creating a new instance of the LoginPage class and passing a WebDriver instance to its constructor.
	private ProductPage productdetail;
	
	@Given("User has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable LoginCredential) {
	  
		List<Map<String,String>> LoginCred=LoginCredential.asMaps(); // you are taking the username and pwd from the datable of the fetaure file
		String un=LoginCred.get(0).get("Username"); //based on the index get the value given for both username and pwd
		String pwd=LoginCred.get(0).get("Password");
		DriverFactory.getDriver().get("https://automationexercise.com/"); //call the url
		productdetail= loginpage.doLogin(un, pwd);
	}

	@Given("User is on HomePage with Title {string}")
	public void user_is_on_home_page_with_Title(String Expected) {
		String HomePageTitle=productdetail.VerifyUserisOnHomePage();
		 Assert.assertTrue(HomePageTitle.contains(Expected));
	}

	@When("User clicks on {string} button")
	public void user_clicks_on_button(String string) {
		productdetail.ClickOnProduct();
	}

	@Then("Verify user is navigated to ALL PRODUCTS page successfully with {string}")
	public void verify_user_is_navigated_to_all_products_page_successfully_with(String ExpectedProductPageTitle) {
		String ActualProductPageTitle=productdetail.verifyUserInOnProductPage();
		 Assert.assertTrue(ActualProductPageTitle.contains(ExpectedProductPageTitle));
	}

	@Then("The products list should be visible")
	public void the_products_list_should_be_visible(DataTable sectionTable) {
	  
		List<String> ExpectedProductList=sectionTable.asList();
		System.out.println("ExpectedProductList"+ExpectedProductList);
		List<String> ActualProductList=productdetail.verifyCategoryList();
		System.out.println("ActualProductList"+ActualProductList);
		
		Assert.assertTrue(ExpectedProductList.containsAll(ActualProductList));
		
	}

	@Then("category list count should be {int}")
	public void category_list_count_should_be(Integer ExpectedCategoryListCount) {
		int NumberOfCategoryShownOnPage=productdetail.NumberofCategory();
		Assert.assertTrue(NumberOfCategoryShownOnPage==ExpectedCategoryListCount);
		
		
	}
}
