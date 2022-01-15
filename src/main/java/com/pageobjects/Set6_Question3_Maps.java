package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Set6_Question3_Maps {

	
	WebDriver d;
	public Set6_Question3_Maps(WebDriver d){
		this.d=d;
		PageFactory.initElements(d, this);
		
	}
	
	@FindBy(how = How.XPATH,using ="//input[@id='searchboxinput']")
	public WebElement search;
	
	
	@FindBy(how = How.XPATH,using ="//button[@id='searchbox-searchbutton']")
	public WebElement searchButton;
}
