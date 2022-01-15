package cpsat.mock.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Practice_Aug_Chapters extends TestBase{
	
	@BeforeTest
	public void initiate() throws Exception{
		init("Chrome", "https://www.agiletestingalliance.org/");
		checkPageReady();
		if(d.findElements(By.xpath("//div[@class='dialog-message dialog-lightbox-message']")).size()>0){
			d.findElement(By.xpath("//div[@class='dialog-close-button dialog-lightbox-close-button']")).click();
		}
	}

	
	@Test
	public void maintest() throws Exception{
		WebElement chapter = d.findElement(By.xpath("//ul[@id='menu-main-1']//a[text()='Chapters']"));
		wait(1);
		Actions act = new Actions(d);
		act.moveToElement(chapter).perform();
        wait(1);
        WebElement All = d.findElement(By.xpath("//ul[@id='menu-main-1']//a[text()='All']"));
      All.click();
       checkPageReady();
       d.findElement(By.xpath("//a[text()='South Africa']//preceding-sibling::span")).click();
       // act.click(All);
	}
}
