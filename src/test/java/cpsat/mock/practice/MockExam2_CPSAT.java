package cpsat.mock.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class MockExam2_CPSAT extends TestBase {
	
	@Parameters({"browser"})
	@BeforeTest
	public void intiate(String browser) throws Exception{
		init(browser, "https://mockexam2cpsat.agiletestingalliance.org/");
		checkPageReady();
		//close();
		if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
			d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		}
	}
	
	@Test
	public void maintest() throws Exception{
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//div[@class='site-footer']")));
		wait(1);
		List<WebElement> socialIcons = d.findElements(By.xpath("//span[@class='elementor-grid-item']//a"));
		System.out.println("Size:" +socialIcons.size());
		for(WebElement icon: socialIcons){
		//	waitForElementToVisible(icon);
			System.out.println("Social Icons: " +icon.getAttribute("href"));
			scrollIntoView(icon);
			Actions act = new Actions(d);
			act.moveToElement(icon);
			act.contextClick(icon).build().perform();
			wait(1);
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
			String mainWindow = d.getWindowHandle();
			System.out.println("MainWindow:" +mainWindow);
			Set<String>windowHandles = d.getWindowHandles();
			for(String win :windowHandles){
				if(!(win.equalsIgnoreCase(mainWindow))){
					d.switchTo().window(win);
					checkPageReady();
					System.out.println("Switching to child window : ");
					System.out.println(d.getTitle());
					d.close();
				}
				d.switchTo().window(mainWindow);
			}
			
		}
		
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//div[contains(@class,'countdown--label')]")));
		List<WebElement> dayElements = d.findElements(By.xpath("//div[contains(@class,'countdown--label')]//div[@class='elementor-countdown-item']"));
		for(int i =1; i<=dayElements.size();i++){
			WebElement digit = d.findElement(By.xpath("(//span[contains(@class,'elementor-countdown-digits')])["+i+"]"));
			WebElement Label = d.findElement(By.xpath("(//span[contains(@class,'elementor-countdown-label')])["+i+"]"));
			System.out.println("Days Left:" +digit.getText() +Label.getText());
			String cont= digit.getText()+" " +Label.getText();
			if(cont.contains("Hours")){
			String[] c = cont.split(" ");
			System.out.println();
			int day = Integer.parseInt(c[0]);
			Assert.assertTrue(day<24);
			//System.out.println(day);
			/*if(day<24){
				System.out.println(day+ "is  less than 24 hours");
			}
			else{
				System.out.println(day+ "is  less than 24 hours");
			}*/
			//System.out.println("Days Left :" +day+Label.getText());
		}
			else if(cont.contains("Minutes")){
				String[] c = cont.split(" ");
				System.out.println();
				int day = Integer.parseInt(c[0]);
				Assert.assertTrue(day<60);
				//System.out.println(day);
				/*if(day<60){
					System.out.println(day+ "is  less than 24 hours");
				}
				else{
					System.out.println(day+ "is  less than 24 hours");
				}*/
			}
			
			else if(cont.contains("Seconds")){
				String[] c = cont.split(" ");
				System.out.println();
				int day = Integer.parseInt(c[0]);
				Assert.assertTrue(day<60);
				//System.out.println(day);
				/*if(day<60){
					System.out.println(day+ "is  less than 24 hours");
				}
				else{
					System.out.println(day+ "is  less than 24 hours");
				}*/
			}
			
			else if(cont.contains("Days")){
				System.out.println("Displaying in days: " +cont);
			}
			
		}
}
	@AfterTest
	public void closebrow(){
		close();
	}

}
