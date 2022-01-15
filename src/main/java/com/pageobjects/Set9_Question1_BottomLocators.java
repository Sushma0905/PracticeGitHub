package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Set9_Question1_BottomLocators {
WebDriver d;
	
	public By gettopNews(){
	return By.xpath("//li[@class='more']//a[contains(text(),'NEWS')]");
	}
	
	public By gettopLive(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Live')]");
		}
	public By gettopCrypto(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Crypto')]");
		}
	
	public By getMarket(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Market')]");
	}
	
	public By getMoney(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Money')]");
	}
	
	public By getCorporate(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Corporate')]");
	}
	public By getEconomy(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Economy')]");
	}
	public By getIndustry(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Industry')]");
	}
	
	public By getOpinion(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Opinion')]");
	}
	
	public By getVideo(){
		return By.xpath("//div[@class='topnav_cont']//a[contains(text(),'Video')]");
	}
	

}
