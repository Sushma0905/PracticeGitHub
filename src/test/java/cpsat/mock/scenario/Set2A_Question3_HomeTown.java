package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.testing.base.TestBase;

public class Set2A_Question3_HomeTown extends TestBase {
	
	@Before
	public void inititateBrowser(){
		init("Chrome", "https://www.hometown.in/");
	}

	@Test
	public void maintest() throws Exception{
		checkPageReady();
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//div[text()='More']"))).build().perform();
		d.findElement(By.xpath("//a[@title='Gifting Ideas']")).click();
		wait(2);
		//Under filter by , click on ‘color’ drop down and select ‘Red’.
		
		WebElement colorDropDown = d.findElement(By.xpath("//div[@class='dropparent']//p[contains(text(),'Color')]"));
		act.moveToElement(colorDropDown).click().build().perform();
		wait(2);
		WebElement colorFilter = d.findElement(By.xpath("(//div[contains(@class,'dropparent')]//li[@unbxdparam_facetvalue='Black'])/label"));
		
		waitForElementToVisible(colorFilter);
		jsClick(colorFilter);
		wait(2);
		//Verify if the first product displayed has ‘Red’ in the product name.
		
		WebElement firstProduct = d.findElement(By.xpath("//section[contains(@class,'listwrapper')]/div[contains(@class,'listing')]/div[1]"));
		scrollIntoView(firstProduct);
		wait(1);
		/*d.findElement(By.xpath("//div[@class='product' and contains(@unbxd_skuid,'LI889TE03VSMHTFUR')]"));
*/	
		
		WebElement firstProduct2 =d.findElement(By.xpath("//*[@id='hometown_1573910556']/section[2]/div[1]/div[1]/div/div[1]/div[1]/p/a"));
		firstProduct2.getText();
		System.out.println(firstProduct2.getText());
		
		//Verify if the first product displayed has ‘Red’ in the product name.
		Assert.assertTrue((firstProduct2.getText().contains("Black")));
		
		
		//Check if Red is present in Applied filters.
		
		scrollUp();
		WebElement AppliedFilters = d.findElement(By.xpath("//div[@class='tags']/ul/li/p"));
		scrollIntoView(AppliedFilters);
		wait(1);
		List<WebElement> filters = d.findElements(By.xpath("//div[@class='tags']/ul/li/p"));
		wait(2);
		for(WebElement fil : filters){
			if(fil.getText().contains("black")){
				System.out.println("Applied filters contains :" +fil.getText());
			}
			else {
				System.out.println("Applied filters does not contains : " +fil.getText());
			}}
		}
		@After
		public void close(){
			terminate();
		}
		
		//d.findElement(By.xpath("//*[@id='color_uFilter_Black']")).click();
		
		//d.findElement(By.xpath("//a[@title='Hometown Blog']")).click();
	}

