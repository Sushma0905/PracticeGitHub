package cpsat.mock.practice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Practice_Aug_Question1 extends TestBase {
	
	@BeforeTest
	public void initiateBrowser(){
		init("Chrome", "https://www.agiletestingalliance.org/agile-testing/");
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		scrollIntoView(d.findElement(By.xpath("//div[@class='elementor-grid-item']//a")));
		List<WebElement> socialicons = d.findElements(By.xpath("//div[@class='elementor-grid-item']//a"));
		for(WebElement e : socialicons ){
			System.out.println("Href's :" +e.getAttribute("href"));
			if(e.getAttribute("href").toLowerCase().contains("agile")){
				System.out.println("with Href:" +e.getAttribute("href"));
				e.click();
				String mainWindow = d.getWindowHandle();
				
				Set<String>childWindow = d.getWindowHandles();
				
				for(String c : childWindow){
					if(!c.equals(mainWindow)){
						d.switchTo().window(c);
						wait(2);
						System.out.println("Title:" +d.getTitle());
						takeScreenShotTip("Aug_Pratice", "Question1");
						wait(1);
						d.close();
						
					
					}
					d.switchTo().window(mainWindow);
					
				}
				
				
			}
		}
		
		List<WebElement> agile = d.findElements(By.xpath("//*[contains(text(),'Agile')]"));
		System.out.println("Count:" +agile.size());
	
		for(WebElement e : socialicons ){
			Actions act = new Actions(d);
			scrollIntoView(e);
			act.moveToElement(e).perform();
			wait(1);
			takeScreenShotTip("Aug_Pratice", "SocialIcon");
			
		}
	}

	@AfterTest
	public void closebr(){
		close();
	}
}
