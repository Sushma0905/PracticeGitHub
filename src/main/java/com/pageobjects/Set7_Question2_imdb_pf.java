package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Set7_Question2_imdb_pf {

	WebDriver d;
	
	public Set7_Question2_imdb_pf(WebDriver d){
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	
	
	public String searchbox ="//input[contains(@placeholder,'Search IMDb')]";
	
	
	public String searchButton ="//button[@id='suggestion-search-button']";
	
	
	public String gangResult ="((//table[contains(@class,'findList')])[1]//td[contains(@class,'result')]//a)[1]";
	
	public String genre = "(//li[@data-testid ='storyline-genres']//following::a)[1]";
	
	public String mpaaRating = "(//a[contains(text(),'Motion Picture Rating')]//following ::span)[1]";
	
	public String userNames = " //span[@class='display-name-link']//a";
	
	public String UserReviewsLink =  "//h3[text()='User reviews']//parent::a";
	
	
	
}
