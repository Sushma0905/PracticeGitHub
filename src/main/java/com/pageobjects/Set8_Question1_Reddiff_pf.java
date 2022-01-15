package com.pageobjects;

import org.openqa.selenium.WebDriver;

public class Set8_Question1_Reddiff_pf {
	WebDriver d;
	
	public Set8_Question1_Reddiff_pf(WebDriver d){
		this.d=d;
	}

	
	public String GetAheadMenu = "//li[@class='getahead']/a";
	public String submenu = "//div[contains(@class,'getahead')]//a";
	public String home = "//a[contains(text(),'HOME')]";
	public String realTime ="//ul[@class='navbarul']//a[text()='REALTIME NEWS']";
	public String businessEmail ="//a[contains(@href,'businessemail')]";
	
	public String news = "//li[@class='news']";
	public String newSubmenu = "//div[contains(@class,'subnavbar news')]";
	public String GetAheadbackMenu = "//div[@class='subnavbar getahead']";
	
	
}
