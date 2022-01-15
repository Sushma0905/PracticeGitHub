package cpsat.mock.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LIST2_POM {
	WebDriver d;
	public LIST2_POM(WebDriver d) {
		// TODO Auto-generated constructor stub
		this.d =d;
	}
	
	By list = By.xpath("//*[@id='menu-main-menu']/li/a[contains(.,'Lists')]");
	  By List2 = By.xpath("//*[contains(@id,'menu-item')]/a[text()='List 2']");
	  By search =By.xpath("//*[@type='text']");
	  public void clickList()
		{
			Actions act = new Actions(d);
			act.moveToElement(d.findElement(list)).moveToElement(d.findElement(List2)).click().build().perform();
			
		}

}
