package testNG;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class MockExam1_Question1 extends TestBase{
	
	@Parameters({"browser"})
	@BeforeTest
	public void initiate(String browser){
		init(browser, "https://mockexam1cpsat.agiletestingalliance.org/");
		if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
			d.findElement(By.xpath("//div[contains(@class,'dialog-lightbox-close-button')]")).click();
		}
	}
	
	@Test
	public void test() throws Exception{
		checkPageReady();
		WebElement hamburgerMenu = d.findElement(By.xpath("//button[@class='menu-toggle']"));
		jsClick(hamburgerMenu);
		List<WebElement>menuItems = d.findElements(By.xpath("//ul[@id='menu-slideout-spacious']//li//a"));
		for(WebElement menu : menuItems){
			System.out.println(menu.getText());
		}
		
		List<WebElement>socialIcons = d.findElements(By.xpath("//ul[contains(@class,'lsi-social-icons')]//li//a"));
		for(WebElement social:socialIcons){
			System.out.println("url :" +social.getAttribute("href"));
			Actions act = new Actions(d);
			act.moveToElement(social);
			act.contextClick(social).build().perform();
			wait(2);
			Robot ro = new Robot();
			ro.delay(1500);
			ro.keyPress(KeyEvent.VK_DOWN);
			ro.keyRelease(KeyEvent.VK_DOWN);
			ro.delay(1500);
			ro.keyPress(KeyEvent.VK_DOWN);
			ro.keyRelease(KeyEvent.VK_DOWN);
			ro.delay(1500);
			ro.keyPress(KeyEvent.VK_ENTER);
			ro.keyRelease(KeyEvent.VK_ENTER);
			ro.delay(1500);
			
			String mainWin = d.getWindowHandle();
			Set<String>Windows = d.getWindowHandles();
			for(String w: Windows){
				if(!(w.equalsIgnoreCase(mainWin))){
					d.switchTo().window(w);
					System.out.println("Title: " +d.getTitle());
					//checkPageReady();
					d.close();
				}
				d.switchTo().window(mainWin);
			}
		}
	}

}
