package com.pageobjects;

import org.openqa.selenium.WebDriver;

public class Set5_Question5_Appspot_PF {

	
	WebDriver d;
	
	public Set5_Question5_Appspot_PF(WebDriver d){
		this.d=d;
		
	}
	
	public String firstXpath = "//td[contains(text(),'first number')]//following::input[1]";
	public String secondXpath = "//td[contains(text(),'second number')]//following::input[1]";
	public String CalculateButton = "//button[contains(text(),'Calculate')]";
	public String Result = "//td[contains(text(),'Result')]//following::input[1]";
	public String checkbox = "//label[contains(text(),'Euclid(-)')]//preceding-sibling::input[1]";
	
	
}
