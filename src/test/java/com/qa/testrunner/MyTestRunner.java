package com.qa.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\Dell\\Automation Software\\ProjectApril\\TestProject\\src\\test\\resources\\com\\qa\\feature"},
		glue= {"com.qa.stepdefination","com.qa.hooks"},
		 plugin = {
			        "pretty",
			        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			       
			    }
			)

public class MyTestRunner {

}  

