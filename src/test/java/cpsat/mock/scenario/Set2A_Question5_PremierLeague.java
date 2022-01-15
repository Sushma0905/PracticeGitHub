package cpsat.mock.scenario;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set2A_Question5_PremierLeague extends TestBase{
	
	@Before
	public void initiateBrowser(){
		init("Chrome", "https://www.premierleague.com/");
	}

	@Test
	public void maintest() throws Throwable{
		checkPageReady();
		if(d.findElements(By.xpath("//div[contains(@class,'btn-primary cookies-notice-accept')]")).size()>0){
			d.findElement(By.xpath("//div[contains(@class,'btn-primary cookies-notice-accept')]")).click();
		}
		
		wait(2);
		//WebElement closeButton = d.findElement(By.xpath("//a[@id='advertClose']"));
		if(d.findElements(By.xpath("//a[@id='advertClose']")) != null){
			d.findElement(By.xpath("//a[@id='advertClose']")).click();
			
		}
		
		//Click on Tables from the menu.
		d.findElement(By.xpath("//ul[contains(@class,'showMoreEnabled')]//a[text()='Tables']")).click();
		wait(2);
		if(d.findElements(By.xpath("//a[@id='advertClose']")) != null){
			d.findElement(By.xpath("//a[@id='advertClose']")).click();
		}
		//. Click on Everton from the list
		d.findElement(By.xpath("//li[text()='First Team']")).click();
		scrollIntoView(d.findElement(By.xpath("//tbody[contains(@class,'tableBodyContainer isPL')]")));
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//tbody[contains(@class,'tableBodyContainer isPL')]//td[@class='team']/a/span[text()='Everton']"))).click().build().perform();
		//d.findElement(By.xpath("//tbody[contains(@class,'tableBodyContainer isPL')]//td[@class='team']/a/span[text()='Everton']")).click();
	     checkPageReady();
	//Print the official website in the new page and the page title.
	     String MainWindow = d.getWindowHandle();
	     WebElement OfficialWebsite = d.findElement(By.xpath("//span[text()='Official Website:']/following-sibling::a"));
	     OfficialWebsite.click();
	     checkPageReady();
	     Set<String> WindowHandles = d.getWindowHandles();
	     for(String ChildWin : WindowHandles){
	    	 if(!(ChildWin.contains(MainWindow))){
	    		 d.switchTo().window(ChildWin);
	    		 wait(2);
	    		 String title = d.getTitle();
	    		 System.out.println("Child Title :" +title);
	    		 
	    	 }
	    	
	     }
	     d.switchTo().window(MainWindow);
    	 wait(1);
    	 System.out.println("Main window Title :" +d.getTitle());
	    
	}
	
	@After
	public void terminate(){
		terminate();
	}
}
