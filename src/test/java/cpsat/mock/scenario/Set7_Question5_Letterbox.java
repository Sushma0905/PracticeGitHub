package cpsat.mock.scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.Set7_Question5_Letterboxd_PF;
import com.testing.base.TestBase;

public class Set7_Question5_Letterbox extends TestBase{
	
	@BeforeTest
	public void initiate(){
		init("Chrome", "https://letterboxd.com/");
	}
	
	@Test
	public void maintest() throws Exception{
		Set7_Question5_Letterboxd_PF Let = new Set7_Question5_Letterboxd_PF(d);
		checkPageReady();
		//Verify the page heading contains ‘Letterboxd’.
		String ActualTitle = d.getTitle();
		System.out.println(ActualTitle);
		if(ActualTitle.contains("Letterboxd")){
			System.out.println("The page heading contains ‘Letterboxd’.");
		}
		else{
			System.out.println("The page heading is "+ActualTitle);
		}
		//Click on ‘PEOPLE’ from the top menu and capture a screenshot of the resulting page.
		
		//takeScreenShot("Set7_Question5");
		//Print the names of the reviewers under the ‘Popular this week’ section
		d.findElement(By.xpath(Let.members)).click();
		List<WebElement> reviewers = d.findElements(By.xpath(Let.reviewers));
		for(WebElement rev : reviewers){
			rev.getText();
			System.out.println("Top 	Reviewers: " +rev.getText());
		}
		//In the ‘Popular this week’ section, print the total number of reviews that the first reviewer has.
		String firstUserRev = d.findElement(By.xpath(Let.firstReview)).getText();
		System.out.println("First user reviewers :" +firstUserRev);
		
		
	}
	@AfterTest
	public void closebrowser(){
		close();
	}

}
