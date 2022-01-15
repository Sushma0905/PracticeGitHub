package cpsat.mock.scenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.testing.base.TestBase;

public class Set4_Question5_OnlineComversion extends TestBase {
	
	@Before
	public void Initiatebrowser(){
		init("Chrome", "http://www.onlineconversion.com/length_common.htm");
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		int value =5;
		//Enter value 5.
		d.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("5");
		//Select feet from From list.
		Select selFrom = new Select(d.findElement(By.xpath("//*[@name='from']")));
		selFrom.selectByVisibleText("feet");
		//Select inch from To list.
		Select selTo = new Select(d.findElement(By.xpath("//*[@name='to']")));
		selTo.selectByVisibleText("inch");
		//Click on Convert button.
		d.findElement(By.xpath("//input[@type='button']")).click();
		//Verify the result follows the formula (value*12).
		waitForElementToVisible(d.findElement(By.xpath("//input[@name='answer']")));
		String actualValue = d.findElement(By.xpath("//input[@name='answer']")).getAttribute("value");
		System.out.println("Result:" +actualValue);
		int ExpectedValue = value*12;
		if(actualValue.contains(Integer.toString(ExpectedValue))){
			System.out.println("Actual value equals to Expected Value");
		}
		else{
			System.out.println("Actual value does not equal to Expected Value");
		}
	}

	
	@After
	public void closeBrowser(){
		terminate();
	}
}
