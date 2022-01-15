package cpsat.mock.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Practice_July_CPSAT extends TestBase{
	
	@BeforeTest
	public void intiate(){
		init("Chrome", "https://examjuly2021.agiletestingalliance.org/");
	}

	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		WebElement iCons = d.findElement(By.xpath("(//div[contains(@id,'eael-section-tooltip')])[1]"));
		//scrollIntoView(toolTip);
		Actions act = new Actions(d);
		act.moveToElement(iCons).build().perform();
		wait(1);
		WebElement toolTiptext1= d.findElement(By.xpath("//*[contains(@id,'eael-section-tooltip-e51da28')]/script"));
		String text = toolTiptext1.getAttribute("content");
		System.out.println("toolTiptext1:" +text);
		
	}
}
