package cpsat.mock.scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.Set3_Question3_cii_PageObject;
import com.testing.base.TestBase;

public class Set3_Question3_cii extends TestBase {
	
	
	@BeforeTest
	public void initiatebrowser(){
		init("Chrome", "https://www.cii.in/");
	}

	@Test
	public void maintest() throws Exception{
		Set3_Question3_cii_PageObject pg = new Set3_Question3_cii_PageObject(d);
		checkPageReady();
		
		if(d.findElements(By.xpath("//div[@id='videoModel-new']")).size()>0){
			d.findElement(By.xpath("//span[contains(@class,'cross-btn')]")).click();
			//b.	Print all the Icon names of social media (right top corner)
			pg.listOfIcons();
			scrollIntoView(d.findElement(pg.contact));
			pg.contact();
			checkPageReady();
			String webelement = "//div[@class='phone']//child::span[4]";
			scrollIntoView(d.findElement(By.xpath("//div[@class='phone']//child::span[4]")));
			pg.assertparticularElement("//div[@class='phone']//child::span[4]", "1800 103 1244 ");
			
			
		//b.	Print all the Icon names of social media 
		
	
	}
		pg.listOfIcons();
		pg.contact();
		checkPageReady();
		String webelement = "//div[@class='phone']//child::span[4]";
		scrollIntoView(d.findElement(By.xpath("//div[@class='phone']//child::span[4]")));
		pg.assertparticularElement("//div[@class='phone']//child::span[4]", "1800 103 1244 ");
		
		
}
	
	@AfterTest
	public void terminatebrowser(){
		terminate();
	}
}
