package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

/**
 * @author magmukherjee
 * Using TestNG, go to http://www.cii.in.
 *	a)	Go to CII Services -> Sectoral Portfolio -> Food & Agriculture -> Agriculture.
 *	b)	Print page Title.
 *	c)	Check for the social network icons at the bottom right panel and print their tooltips.
 *	d)	Take a screenshot at this instance.
 */
public class Question3 extends TestBase{

	public static final String URL_CII = "https://www.cii.in/";

	@BeforeTest
	public void setUp() {
		init("Chrome",URL_CII);
	}

	@Test
	public void ciiAgriculturePageTester() throws Exception {
		WebElement ciiServices = d.findElement(By.xpath("(//a[contains(text(),'CII Services')])[2]")); 
		waitForElementToClickable(ciiServices);
		Actions action = new Actions(d); 
		action.moveToElement(ciiServices).build().perform();

		WebElement sectoralPortfolio = d.findElement(By.xpath("//a[contains(text(),'Sectoral Portfolio')]"));
		waitForElementToClickable(sectoralPortfolio);
		action.moveToElement(sectoralPortfolio).build().perform();

		WebElement foodAndAgriculture = d.findElement(By.xpath("//a[contains(text(),'Food & Agricultural')]"));
		waitForElementToClickable(foodAndAgriculture);
		action.moveToElement(foodAndAgriculture).build().perform();

		WebElement agriculture = d.findElement(By.xpath("//a[contains(text(),'Agriculture')]"));
		waitForElementToClickable(agriculture);
		jsClick(agriculture);
		checkPageReady();

		System.out.println("Page Title: "+d.getTitle());

		List<WebElement> list = d.findElements(By.xpath("//div[@class='new-socila-icons']")); 
		for (int i = 0 ; i<list.size(); i++) {
			
			waitForElementToVisible(list.get(i));
			//scrollIntoView(list.get(i));
			wait(2);
			action.moveToElement(list.get(i)).clickAndHold().build().perform();
			wait(2);
			takeScreenShotTip("Q3_tool_tip_", String.valueOf((i+1)));
			System.out.println(list.get(i).getAttribute("title"));		
			
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
