package cpsat.mock.scenario;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.pageobjects.Set6_Question5_Portal_PageObject;
import com.testing.base.TestBase;

public class Set6_Question5_Portal extends TestBase{
	
	@Before
	public void initiate(){
		init("Chrome", "http://mu.ac.in/portal");
	}
	
	@Test
	public void maintest() throws Exception{
		Set6_Question5_Portal_PageObject pg = new Set6_Question5_Portal_PageObject(d);
		
		checkPageReady();
		//Under “Faculties”, select “Science”, and then select “Department of Information Technology”. 
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(pg.aCademics())).build().perform();
		wait(1);
		act.moveToElement(d.findElement(pg.fAculty())).build().perform();
		wait(1);
		act.moveToElement(d.findElement(pg.sCience())).click().build().perform();
		wait(1);
		act.moveToElement(d.findElement(pg.tEchnology())).click().build().perform();
		checkPageReady();
		String mainWindow = d.getWindowHandle();
		Set<String> handles = d.getWindowHandles();
		for(String han : handles){
			if(!(d.getWindowHandle().contains(han))){
				d.switchTo().window(han);
				wait(2);
				System.out.println(d.getCurrentUrl());
				//Print the Text Present under “Vision” in the console 
				scrollIntoView(d.findElement(By.xpath("//a[text()='Vision, Mission & Goal']")));
				String visionText = d.findElement(pg.vision()).getText();
				System.out.println("Text in the Vision:" +visionText);
				scrollIntoView(d.findElement(pg.contactUsAddress()));
				String ContactUs = d.findElement(pg.contactUsAddress()).getText();
				System.out.println("Contact:" +ContactUs);   
				
			
			}
		}
		
		/*d.switchTo().window(mainWindow);
		//Click on “Contact Us” and print the Address in the console. 
		d.findElement(pg.contact()).click();
		checkPageReady();*/
		
	}

}
