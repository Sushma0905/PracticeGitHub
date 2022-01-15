package cpsat.mock.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LIST3_POM {
 WebDriver d;
 By list = By.xpath("//*[@id='menu-main-menu']/li/a[contains(.,'Lists')]");
 By List3 = By.xpath("//*[contains(@id,'menu-item')]/a[text()='List 3']");
 By search =By.xpath("//*[@type='text']");
	public LIST3_POM(WebDriver d) {
		// TODO Auto-generated constructor stub
		this.d=d;
	}
	public void clickList()
	{
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(list)).moveToElement(d.findElement(List3)).click().build().perform();
		
	}

}
