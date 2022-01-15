package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Set7_Question5_Letterboxd_PF {
	
	WebDriver d;
	
	public Set7_Question5_Letterboxd_PF(WebDriver d){
		this.d = d;
	//PageFactory.initElements(d, Set7_Question5_Letterboxd_PF.class);	
	}

	public String reviewers = "(//td[@class='table-person']//following::h3)";
	public String members = "//a[text()='Members']";
	public String firstReview = "(//td[@class='table-person']//a[contains(text(),'reviews')])[1]";
	
	
}
