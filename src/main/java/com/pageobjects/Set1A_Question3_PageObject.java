package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.testing.base.TestBase;

public class Set1A_Question3_PageObject extends TestBase{

	public By BSE = By.xpath("//span[@id='bseindex']");
	public By NSE = By.xpath("//span[@id='nseindex']");
	public By MFinputField = By.xpath("//input[@class='getquoteinput']");
	public By getFrame(){
		return By.xpath("//iframe[@id='moneyiframe']");
	}
	
	
	
	
/*	@FindBy(how = How.XPATH,using ="//span[@id='bseindex']")
	public  WebElement BSE;*/
	
	/*@FindBy(how = How.XPATH,using ="//span[@id='nseindex']")
	public  WebElement NSE;*/
	
/*	
	@FindBy(how = How.XPATH,using ="//input[@class='getquoteinput']")
	public WebElement MFinputField;*/
	
	
}
