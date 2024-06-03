package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	
	private WebDriver driver;
	//Page Object Repository
	private By Product=By.xpath("//a[@href='/products']");
	private By CategoryList=By.xpath("//div[@class='panel-group category-products']");
	
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public String VerifyUserisOnHomePage() {
		return driver.getTitle();
	}
	public void ClickOnProduct() {
		driver.findElement(Product).click();
	}
	public String verifyUserInOnProductPage() {
		return driver.getTitle();
	}
	
	public int NumberofCategory() {
		return driver.findElements(CategoryList).size();
	}
	
	public List<String> verifyCategoryList()
	{
		List<String> Category= new ArrayList<>();
		List<WebElement> productcategory= driver.findElements(CategoryList);
		
		for(WebElement e:productcategory)
		{
			String text=e.getText();
			Category.add(text);
		}
		return Category;
	}
	
}
