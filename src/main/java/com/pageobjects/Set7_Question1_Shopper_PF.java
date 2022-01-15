package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Set7_Question1_Shopper_PF {
	
	WebDriver d;
	
	public Set7_Question1_Shopper_PF(WebDriver d){
		this.d=d;
	}
	
	public By getBrand(){
		return By.xpath("//a[@title='BRANDS']");
		
	}
	
	public By getHauteCurry(){
		return By.xpath("//a[text()='HauteCurry']");
		
	}
	
	public By getStop(){
		return By.xpath("//a[text()='Brands of Shoppers Stop']");
		
	}
	
	public By getinstagram(){
		return By.xpath("//li[contains(@class,'instagram-icon')]");
		
	}
	
	public By getinstagramUrl(){
		return By.xpath("//li[contains(@class,'instagram-icon')]/a");
		
	}
	
	
	
}
