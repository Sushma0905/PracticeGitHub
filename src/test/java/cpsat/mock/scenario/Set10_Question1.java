package cpsat.mock.scenario;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.Set9_Question1_TopLocators;
import com.testing.base.TestBase;

public class Set10_Question1 extends TestBase{
	
	@BeforeTest
	public void initiatebrowser(){
		init("Chrome", "https://www.ndtv.com/");
	}
	
	@Test
	public void mainTest() throws Exception{
		checkPageReady();
		Set9_Question1_TopLocators top = new Set9_Question1_TopLocators();
		List<WebElement> toplocators = d.findElements(By.xpath("//div[@class='nglobalnav']//a"));
		for(WebElement loc : toplocators){
			System.out.println("Attributes:" +loc.getAttribute("href"));
		}
		//Assert that the tool tip of the LATEST menu item is “Latest”
		takeScreenShotTip("Question10", "Question10");
		//.moveToElement(d.findElement(By.xpath("//div[@class='topnav_cont']//a[contains(text(),'LATEST')]")))
		
		Actions act = new Actions(d);
		act.contextClick(d.findElement(By.xpath("//div[@class='topnav_cont']//a[contains(text(),'LATEST')]"))).build().perform();
		
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);
		wait(1);
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
		wait(1);
		String main = d.getWindowHandle();
		Set<String> handles = d.getWindowHandles();
		for(String h: handles){
			if(!(h.equalsIgnoreCase(main))){
				d.switchTo().window(h);
				wait(1);
				System.out.println("Child Window Title: " +d.getTitle());
			}
		
			
		}
		
		List<WebElement>latestNews = d.findElements(By.xpath("(//h2[@class='newsHdng']//a)"));
		for(int i =1; i<4;i++){
			System.out.println(latestNews.get(i).getText());
			
		}
		
		
		d.switchTo().window(main);
		System.out.println("Main window titile : "+d.getTitle());
		
	}
	
	@AfterTest
	public void closebr(){
		close();
	}
	

}
