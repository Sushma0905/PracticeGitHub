package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set1A_Question4_rediff extends TestBase {

	@Before
	public void initiatebrowser(){
		init("Chrome", "https://www.rediff.com/");
	}
	@Test
	public void maintest() throws Exception{
		// Find out href of all the TopStories on the Rediff.com page using findElements 
		checkPageReady();
		d.findElement(By.xpath("//div[text()='TOP STORIES']")).click();
		List<WebElement> link = d.findElements(By.xpath("(//div[contains(@id,'topdiv')])[1]/h2/a"));
				
		for(int i =0;i<link.size();i++){
			String href = link.get(i).getText();
			System.out.println(" List of href under TopStories:" +href);
			setData("src\\test\\resources\\TestData\\Rediff.xlsx", "Rediff_Question4", i, 0, href);
			
		}
		
		//Store all the href’s in either a Text file, or an Excel file (You have to submit the file created) 
		
	}
	@After
	public void closeBrowser(){
		terminate();
	}
}
