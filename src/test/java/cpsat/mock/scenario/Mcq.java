package cpsat.mock.scenario;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.base.TestBase; 

public class Mcq extends TestBase {

	@Test
	public void maintest(){
		init("Chrome", "http://www.google.com");
		WebDriverWait wait = new WebDriverWait(d, 30); 
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/input[@name=’name_1’")));
	
	new Actions(d).clickAndHold(d.findElement(By.name("name1"))) 
    .moveToElement(d.findElement(By.name("name2")))  
    .release() 
    .build().perform(); 
		        } 

		} 
	
