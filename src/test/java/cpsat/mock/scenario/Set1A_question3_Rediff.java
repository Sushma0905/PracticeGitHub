package cpsat.mock.scenario;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageobjects.Set1A_Question3_PageObject;
import com.testing.base.TestBase;

public class Set1A_question3_Rediff extends TestBase{
	Set1A_Question3_PageObject pg = new Set1A_Question3_PageObject();
	
	
	@Before
	public void initiatebrowser(){
		init("Chrome", "https://www.rediff.com/");
	}

	@Test
	public void maintest() throws Exception{
		//printing the BSE Index Value, NSE Index Value
		Set1A_Question3_PageObject pg = new Set1A_Question3_PageObject();
		checkPageReady();
		String mainWin=d.getWindowHandle();
		d.switchTo().frame(d.findElement(pg.getFrame()));
		String BSEvalue = d.findElement(pg.BSE).getText();
		wait(3);
		System.out.println("BSEValue: " +BSEvalue);
		String NSEValue = d.findElement(pg.NSE).getText();
		System.out.println("NSE value: " +NSEValue);
		
		//Enter company “Reliance Industries” in the company or MF Input field
		d.findElement(pg.MFinputField).sendKeys("Reliance Industries");
		wait(4);
		d.findElement(pg.MFinputField).sendKeys(Keys.ENTER);
		wait(2);
		
		Set<String> windowHandles = d.getWindowHandles();
		
		for(String w : windowHandles){
			if(!(w.equalsIgnoreCase(mainWin))){
				d.switchTo().window(w);
				String ActualTitle = d.getTitle();
				Assert.assertEquals(ActualTitle.contains("RELIANCE"),true);
				System.out.println("Child window:" +d.getTitle());
			}
		}
	
		d.switchTo().window(mainWin);
		String mainWindTitle = d.getTitle();
		System.out.println("Main window Title: " +d.getTitle());
		Assert.assertTrue(mainWindTitle.contains("Rediff.com:"), "Mainwindow title contians Rediff");
	}
	@After
	public void closeBrowser(){
		terminate();
	}
}
