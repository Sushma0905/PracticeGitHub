package cpsat.mock.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.Set3_Question5_Pagefactory;
import com.testing.base.TestBase;



public class Set4_Question1_cii_Pagefactory extends TestBase {
	
	@BeforeTest
	public void startbrowser(){
		init("Chrome", "https://www.cii.in/");
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		Set3_Question5_Pagefactory pg = new Set3_Question5_Pagefactory(d);
		pg.clickAgriculture();
		wait(2);
		Assert.assertEquals(d.getTitle(), "Sectors");
		
		//Take Screenshot
		pg.screenshotTooltip();
		//Take a screenshot at this instance.
		//takeTheScreenShot("Question 3");
		
	}

	@AfterTest
	public void terminatebrowser(){
		terminate();
	}
}
