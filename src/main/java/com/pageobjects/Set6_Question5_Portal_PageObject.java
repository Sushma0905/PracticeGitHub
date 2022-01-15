package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Set6_Question5_Portal_PageObject {

	
	WebDriver d ;
	public Set6_Question5_Portal_PageObject(WebDriver d){
		this.d=d;
		
	}
	
	
	public By aCademics(){
		return By.xpath("(//a[text()='ACADEMICS'])[1]");
		
	}
	
	public By fAculty(){
		return By.xpath("(//a[text()='FACULTY'])[1]");
	}
	public By sCience(){
		return By.xpath("(//a[text()='SCIENCE & TECHNOLOGY'])[1]");
	}
	
	public By tEchnology(){
		return By.xpath("(//a[text()='DEPARTMENT OF INFORMATION TECHNOLOGY'])[1]");
	}
	
	public By vision(){
		return By.xpath("//a[contains(text(),'Vision, Mission & Goal')]//following::p[1]");
	}
	
	public By contact(){
		return By.xpath("(//a[text()='CONTACT US'])[1]");
	}

	public By contactUsAddress(){
		return By.xpath("//span[text()='Contact US']//following::div[contains(@class,'details')]");
	}
	
	
}
