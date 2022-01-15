package cpsat.mock.scenario;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;



public class Set5_Question2_GoogleMaps extends TestBase{

	SoftAssert assertion = new SoftAssert();
	
	@BeforeTest
	public void InitiateBrow(){
	init("Chrome", "https://www.google.com/maps/");	
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		
		//b.	Search for “Wankhede Stadium” and then click on Maps 
		d.findElement(By.xpath("//*[@id='searchboxinput']")).sendKeys("Wankhede Stadium");
		d.findElement(By.xpath("//*[@id='searchbox-searchbutton']")).click();
		//c.	Save the screen shot image at this test execution instant 
		takeTheScreenShot("Wankhede");
		
		d.findElement(By.xpath("//canvas[@class = 'widget-scene-canvas']"));
		wait(2);
		//d.	Verify the Text Present “Stadium” in the left frame 
		String text = d.findElement(By.xpath("(//h1[contains(@class ,'x3AX1-LfntMc-header-title-title gm2-headline-5')]/span)[1]")).getText();
		System.out.println(text);
		assertion.assertTrue(text.contains("Stadium"));
		//e.	Verify the Title “Wankhede Stadium - Google Maps” 
		
		String Title = d.getTitle();
		System.out.println(Title);
		assertion.assertTrue(Title.contains("Wankhede Stadium - Google Maps"));
		//f.	Print the ratings point and number of reviews in the console. 
		String rating =d.findElement(By.xpath("//ol[contains(@class,'section-star-array')]//parent::span//span")).getText();
		System.out.println("Rating:"+rating);
		String reviews = d.findElement(By.xpath("//button[@jsaction='pane.rating.moreReviews']")).getText();
		System.out.println("Reviews:" +reviews);
		//g.	Verify that link is Present “mumbaicricket.com” on the left frame
		String Website = d.findElement(By.xpath("//button[@data-item-id='authority']/div[@class='AeaXub']/div[2]/div[1]")).getText();
		System.out.println(Website);
		Assert.assertTrue(Website.equalsIgnoreCase("mumbaicricket.com"));
		//i.	Verify that the phone number “022 2279 5500” is present 
		
	}
}
