package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Set6_Question2_Wiki {

	WebDriver d;
	 public Set6_Question2_Wiki(WebDriver d){
		 this.d=d;
	 }
	 
	 public String articlesCount = "//Strong[contains(text(),'English')]//following-sibling::small/bdi[@dir='ltr']";
	 public String englishLink = "//Strong[contains(text(),'English')]//parent::a";
	 public String search = "//input[contains(@title,'Search Wikipedia')]";
	 public String searchButton = "//input[contains(@id,'searchButton')]";
	 public By Motto(){
		 return By.xpath("//div[contains(text(),'Motto')]//following::td[1]");
	 }
	 
	 public By Motto1(){
		 return By.xpath("//div[contains(text(),'Motto')]//following::td[1]");
	 }
	 
}
