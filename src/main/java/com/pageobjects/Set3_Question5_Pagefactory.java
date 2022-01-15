package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testing.base.TestBase;

public class Set3_Question5_Pagefactory extends TestBase {
	
	 WebDriver d;

	public Set3_Question5_Pagefactory(WebDriver d){
		this.d=d;
		PageFactory.initElements(d, this);
		
	}

	@FindBy(how = How.XPATH,using = "(//a[text()='CII Services'])[2]")
	public WebElement CIIServices;
	
	
	@FindBy(how = How.XPATH,using = "//a[text()='Sectoral Portfolio']")
	public WebElement SectoralPortfolio;
	
	
	
	@FindBy(xpath = "//a[text()='Food & Agricultural']")
	public WebElement FoodAgricultural;
	
	@FindBy(xpath = "//a[text()='Agriculture']")
	private WebElement Agriculture;
	
	//Go to CII Services -> Sectoral Portfolio -> Food & Agriculture -> Agriculture
	
	public WebElement getAgriculture() {
		return Agriculture;
	}

	public void setAgriculture(WebElement agriculture) {
		Agriculture = agriculture;
	}

	public void clickAgriculture() throws InterruptedException{
		Actions act = new Actions(d);
		act.moveToElement(CIIServices).build().perform();
		Thread.sleep(1000);
		act.moveToElement(SectoralPortfolio).build().perform();
		Thread.sleep(1000);
		act.moveToElement(FoodAgricultural).build().perform();
		Thread.sleep(1000);
		act.moveToElement(Agriculture).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void screenshotTooltip(){
		List<WebElement> lis = d.findElements(By.xpath("//div[@class='new-socila-icons']//img"));
		for(int i =0; i<lis.size();i++){
			System.out.println("Tool Tip :" +lis.get(i).getAttribute("title").trim());
			Actions act = new Actions(d);
			act.moveToElement(lis.get(i)).perform();
			takeScreenShotTip("Question3", "Cii_ToolTip");
		}
	}
}
