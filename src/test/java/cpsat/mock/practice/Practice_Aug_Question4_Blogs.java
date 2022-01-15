package cpsat.mock.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Practice_Aug_Question4_Blogs extends TestBase {
	
	@BeforeTest
	public void initiateBrowser(){
		init("Chrome", "https://www.agiletestingalliance.org/agile-testing/");
	}

	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		d.findElement(By.xpath("//div[@id='primary-menu']//a[contains(text(),'Blogs')]")).click();
		checkPageReady();
		
		List<WebElement> blogs = d.findElements(By.xpath("//div[contains(@class,'elementor-posts--skin-cards')]//h3[@class='elementor-post__title']//a"));
		for(WebElement b :blogs){
			
			System.out.println("Text: " +b.getText());
			System.out.println(" Href : " +b.getAttribute("href"));
		}
		
		
	}
}
