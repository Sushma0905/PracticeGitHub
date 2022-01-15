package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Set9_Question1_TopLocators {

	WebDriver d;
	
	public By gettopNews(){
	return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'NDTV')]");
	}
	
	public By getBusiness(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'BUSINESS')]");
		}
	public By getMovies(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'MOVIES')]");
		}
	
	public By getCricket(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'CRICKET')]");
	}
	
	public By getTech(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'TECH')]");
	}
	
	public By getFOOD(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'FOOD')]");
	}
	public By getCrypto(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'CRYPTO')]");
	}
	public By getWebStories(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'WEB STORIES')]");
	}
	
	public By getEducation(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'EDUCATION')]");
	}
	
	public By getAuto(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'AUTO')]");
	}
	
	public By getSwasth(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'SWASTH')]");
	}
	
	public By getStyle(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'LIFESTYLE')]");
	}
	
	public By getHealth(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'HEALTH')]");
	}
	
	public By getShopping(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'SHOPPING')]");
	}
	
	public By getArt(){
		return By.xpath("//div[@class='nglobalnav']//a[contains(text(),'ART')]");
	}
	
	public void textTopLocators(){
		List<WebElement> toplocators = d.findElements(By.xpath("//div[@class='nglobalnav']//a"));
		for(WebElement loc : toplocators){
			System.out.println("Attributes:" +loc.getAttribute("href"));
		}
	}
}
