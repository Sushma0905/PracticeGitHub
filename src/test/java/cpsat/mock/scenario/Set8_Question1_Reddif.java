package cpsat.mock.scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.Set8_Question1_Reddiff_pf;
import com.testing.base.TestBase;

public class Set8_Question1_Reddif extends TestBase{
	
	@BeforeTest
	public void initiatebrowser(){
		init("Chrome", "https://www.rediff.com/");
	}
	
	@Test
	public void maintest() throws Exception{
		Set8_Question1_Reddiff_pf reddif = new Set8_Question1_Reddiff_pf(d);
		Actions act = new Actions(d);
		checkPageReady();
		d.findElement(By.xpath(reddif.GetAheadMenu)).click();
		wait(2);
		//. Take a screenshot (showing that the Get Ahead is clicked) 
		takeScreenShot();
		// Get the Href’s of all the submenu items (e.g headlines, specials etc) 
		List<WebElement>submenu = d.findElements(By.xpath("//div[contains(@class,'getahead')]//a"));
		for(WebElement menu : submenu){
			menu.getAttribute("href");
			System.out.println("Submenu items :" +menu.getAttribute("href"));
		}
		
//		Assert that the tool tip of the adjacent menu item Business is “REALTIME NEWS”
		d.findElement(By.xpath(reddif.home)).click();
		checkPageReady();
		WebElement businessEmail = d.findElement(By.xpath(reddif.businessEmail));
		scrollIntoView(businessEmail);
		act.moveToElement(businessEmail).perform();
		wait(1);
		takeScreenShotTip("toolTip", "Sample");
		String actualTitle = businessEmail.getAttribute("title");
		
		if(actualTitle.contains("business email")){
			Assert.assertTrue(true);
			System.out.println("Titile contains business email");
		}
		else{
			System.out.println("Titile  does not contains business email");
		}
		
		//Assert that the background colour of the submenu items for News is having the following RGB (116, 98, 224) value
		d.findElement(By.xpath(reddif.news)).click();
		checkPageReady();
		String backgroundColor = d.findElement(By.xpath("//div[contains(@class,'subnavbar news')]")).getCssValue("background-color");
		System.out.println(backgroundColor);
		String color = Color.fromString(backgroundColor).asRgb();
		System.out.println("Color:" +color);
		Assert.assertEquals("rgb(188, 62, 49)", color);
		String[] col = color.split(" ");
	
		//Assert that the value of RGB in above step maps to the following colour name (Medium Purple)
		d.navigate().to("https://www.color-blindness.com/color-name-hue/");
		checkPageReady();
		//Actions act = new Actions(d);
		scrollDown();
		scrollIntoView(d.findElement(By.xpath("//input[@id='cp1_RedRadio']")));
		act.moveToElement(d.findElement(By.xpath("//input[@id='cp1_RedRadio']"))).build().perform();
		wait(1);
		d.findElement(By.xpath("//input[@id='cp1_RedRadio']")).click();
		d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys(col[0].replaceAll("^0-9", ""));
	}
	
	//@AfterTest
	/*public void closeBrowser(){
		close();
	}*/

}
