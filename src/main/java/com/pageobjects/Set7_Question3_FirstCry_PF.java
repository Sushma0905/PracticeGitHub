package com.pageobjects;

import org.openqa.selenium.WebDriver;

public class Set7_Question3_FirstCry_PF {

	WebDriver d;
	public Set7_Question3_FirstCry_PF(WebDriver d){
		this.d=d;
	}
	
	public String searchField = " //input[@id='search_box']";
	public String sortBy = "//span[text()='Sort by:']";
	public String pricesortBy = "//li[@data-val='Price']/a[contains(text(),'Price')]";
	
	
	
}
