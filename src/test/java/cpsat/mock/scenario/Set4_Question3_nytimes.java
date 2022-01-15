package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set4_Question3_nytimes extends TestBase{
	
	
	@Before
	public void initiatebrowser(){
		init("Chrome", " http://www.nytimes.com/");
	}

	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		//Print the available languages in which the site can be viewed.
		List<WebElement> Languages = d.findElements(By.xpath("//ul[@data-testid='masthead-edition-menu']//a"));
		for(WebElement lan : Languages){
			String language = lan.getText();
			System.out.println("Languages available :" +language);
		}
		//Print the url to which the link Politics is pointing to.
		
	String politicalLink=d.findElement(By.xpath("//div[@data-testid='masthead-mini-nav']//a[text()='Politics']")).getAttribute("href");
		System.out.println("Link of political :" +politicalLink);
		//Take screenshot.
		//takeScreenShot("Nytimes");
		//Verify page title
		if(d.getTitle().contains("The New York Times")){
			System.out.println("Page titile contains The New York Times");
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Page titile does not contains The New York Times");
			Assert.assertTrue(false);
		}
		//Go to Search, enter “arts” and from the result page, search how many result items are there.
		d.findElement(By.xpath("//span[text()='SEARCH']//parent::button[@data-test-id='search-button']")).click();
		d.findElement(By.xpath("//input[@data-testid='search-input']")).clear();
		d.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("arts");
		d.findElement(By.xpath("//button[@data-test-id='search-submit']")).click();
		checkPageReady();
		List<WebElement> artsize = d.findElements(By.xpath("//ol[@data-testid='search-results']//li[@data-testid='search-bodega-result']"));
		System.out.println("Results:" +artsize.size());
	}
	
	@After
	public void closeBrowser(){
		terminate();
	}
}
