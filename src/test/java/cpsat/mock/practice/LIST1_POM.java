package cpsat.mock.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class LIST1_POM extends TestBase{
	TestBase tb = new TestBase();
 WebDriver d;
  By list = By.xpath("//*[@id='menu-main-menu']/li/a[contains(.,'Lists')]");
  By List1 = By.xpath("//*[contains(@id,'menu-item')]/a[text()='List 1']");
  By search =By.xpath("//input[@type='text']");
	public LIST1_POM(WebDriver d) {
		// TODO Auto-generated constructor stub
		this.d =d;
	}
	
	public void clickList() throws Exception {
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(list)).moveToElement(d.findElement(List1)).click().build().perform();
		tb.checkPageReady();
		
	}
	public boolean searchName(String name) {
		tb.scrollIntoView(d.findElement(search));
		wait(1);
		d.findElement(search).sendKeys(name);
		wait(1);
		return false;
		
	}
}
