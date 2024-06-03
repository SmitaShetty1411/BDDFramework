package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ReviewPage {

	private WebDriver driver;
	private By viewProduct=By.xpath("//a[@href=\"/product_details/1\"]");
	private By YourName=By.id("name");
	private By EmailAddress=By.id("email");
	private By AddReview=By.id("review");
	private By Submitt=By.id("button-review");
	private By Message=By.xpath("(//div[@class='alert-success alert'])[1]");
	
	
	public ReviewPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	public void scrollintoViewofTheProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", viewProduct);
	}
	
	public void ClickOnProduct()
	{
	   driver.findElement(viewProduct).click();
	}
	public void AddYourReview(String name,String Email,String Review) {
		driver.findElement(YourName).sendKeys(name);
		driver.findElement(EmailAddress).sendKeys(Email);
		driver.findElement(Message).sendKeys(Review);
		
	}
	public void ClickOnSubmitt() {
		driver.findElement(Submitt).click();
	}
	public String validateSuccessMessage() {
		return driver.findElement(Message).getText();
	}
}
