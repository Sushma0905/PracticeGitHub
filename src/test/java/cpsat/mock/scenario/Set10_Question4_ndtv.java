package cpsat.mock.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set10_Question4_ndtv extends TestBase{
	
	@BeforeTest
	public void initiate(){
		init("Chrome", "https://www.ndtv.com/business");
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		d.switchTo().frame(1);
		//. Click on SITE and take screenshot at this instance
	   // assert if the value initially shown in the dropdown is Site
		WebElement type = d.findElement(By.xpath("//select[@id='type']"));
		waitForElementToClickable(type);
		type.click();
		takeScreenShotTip("set10", "question4");
		Select sel = new Select(type);
		Assert.assertEquals(sel.getFirstSelectedOption().getText(),"Site");
		//Select “STOCK” from dropdown and take screenshot
		sel.selectByValue("Stock");
		takeScreenShotTip("set10", "question42");
		//Search for “Infosys” 
		WebElement search = d.findElement(By.xpath("//input[@id='search']"));
		search.sendKeys("Infosys");
		search.sendKeys(Keys.ENTER);
		wait(3);
		scrollIntoView(d.findElement(By.xpath("(//span[contains(text(),'Video Result')])[1]")));
		String videoText=d.findElement(By.xpath("(//span[contains(text(),'Video Result')])[1]")).getText();
		System.out.println(videoText);
		
		String VideoCount=videoText.replaceAll("[^0-9]", "");
		int count=Integer.valueOf(VideoCount);
		System.out.println("Total video results are : "+count);
		takeTheScreenShot("cpsatTestNG.Set10_Question4");
		
		//Assert that the video results number fetched is greater than 1 (one) 
		Assert.assertTrue(count>1);

		//to print 1st video's link
		String link=d.findElement(By.xpath("((//ul[@id='Related'])[2]/ul/li/p[2]/a)[1]")).getAttribute("href");
		System.out.println("First video's link is : "+link);
		
		//Navigate to the video URL 
		d.navigate().to(link);
		
		
		
		
	}

}
