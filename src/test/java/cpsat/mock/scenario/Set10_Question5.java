package cpsat.mock.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set10_Question5 extends TestBase {
	
	@BeforeTest
	public void intiate(){
		init("Chrome", "http://www.ndtv.com/business");
	}

	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		//print the Sensex and Nifty Values
		//d.switchTo().frame(1);
		
		d.switchTo().frame(d.findElement(By.xpath("//iframe[contains(@src,'market-embedded')]")));
		WebElement Nifty = d.findElement(By.xpath("(//div[@class='indicator-inner']//a[contains(@href,'nifty')]//following-sibling::span)[3]"));
		//WebElement N = d.findElement(By.xpath("//*[@id='header']/div/div[1]/div[2]/div/div"));
		String niftyColor = Nifty.getCssValue("color");
		String color = Color.fromString(niftyColor).asRgb();
		System.out.println("Color:" +color);
		
		System.out.println("Nifty Value : " +niftyColor);
		
		WebElement Sensex = d.findElement(By.xpath("(//div[@class='indicator-inner']//a[contains(@href,'sensex')]//following-sibling::span)[3]"));
		String sensexColor = Nifty.getCssValue("color");
		System.out.println("Sensex Value : " +sensexColor);
		String color1 = Color.fromString(sensexColor).asRgb();
		System.out.println("Color:" +color1);
		
	}
}
