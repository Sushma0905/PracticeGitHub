package cpsat.mock.scenario;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set2B_Question4_PremierLeague extends TestBase {
	
	@Before
	public void initiatebriwser(){
		init("Chrome", "https://www.premierleague.com/");
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		String MainWindow = d.getWindowHandle();
		
		if(d.findElements(By.xpath("//div[contains(@class,'btn-primary cookies-notice-accept')]")).size()>0){
			d.findElement(By.xpath("//div[contains(@class,'btn-primary cookies-notice-accept')]")).click();
		}
		//d.findElement(By.partialLinkText("https://www.premierleague.com/home")).click();
		d.navigate().to("https://www.premierleague.com/home");
		checkPageReady();
		//wait(2);
		//WebElement closeButton = d.findElement(By.xpath("//a[@id='advertClose']"));
		if(d.findElements(By.xpath("//a[@id='advertClose']")) != null){
			d.findElement(By.xpath("//a[@id='advertClose']")).click();
		}
		
		d.findElement(By.xpath("//a[text()='Tables']")).click();
		wait(3);
		if(d.findElements(By.xpath("//a[@id='advertClose']")) != null){
			d.findElement(By.xpath("//a[@id='advertClose']")).click();
			Actions act = new Actions(d);
			//WebElement arsenal=	d.findElement(By.xpath("//tbody[contains(@class,'tableBodyContainer isPL')]//td[@class='team']/a/span[text()='Arsenal']"));
			wait(2);	
			//scrollIntoView(arsenal);
			act.moveToElement(d.findElement(By.xpath("//tbody[contains(@class,'tableBodyContainer isPL')]//td[@class='team']/a/span[text()='Arsenal']")));
			act.contextClick(d.findElement(By.xpath("//tbody[contains(@class,'tableBodyContainer isPL')]//td[@class='team']/a/span[text()='Arsenal']"))).build().perform();
			Robot r = new Robot();
			r.delay(1500);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.delay(1500);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.delay(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			r.delay(2000);
			switchWindow();
			checkPageReady();
			String WebsiteUrl = d.findElement(By.xpath("//span[text()='Official Website:']/following-sibling::a")).getText();
			System.out.println("Official url :" +WebsiteUrl);
			System.out.println("Child Page Title:" +d.getTitle());
			d.switchTo().window(MainWindow);
			System.out.println("Main Page Title:" +d.getTitle());
		}
		else{
			
			Actions act = new Actions(d);
		WebElement arsenal=	d.findElement(By.xpath("//tbody[contains(@class,'tableBodyContainer isPL')]//td[@class='team']/a/span[text()='Arsenal']"));
		wait(2);
		act.moveToElement(arsenal);
		act.contextClick(arsenal).build().perform();
		}
		
	}

	@After
	public void close(){
		terminate();
	}
}
