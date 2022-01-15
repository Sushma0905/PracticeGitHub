package Java.Practice.Questions;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testing.util.Constants;

public class SeleniumPractice {
	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_EXE);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	//driver.getCurrentUrl();
	driver.navigate().to(driver.getCurrentUrl());
	//driver.
	//driver.navigate().forward();
	//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	/*WebElement em=driver.findElement(By.id("email"));*/
	Thread.sleep(5);
	WebDriverWait wait = new WebDriverWait(driver, 500);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
	driver.findElement(By.id("email")).sendKeys(Keys.F5);
	driver.findElement(By.id("email")).sendKeys("Deepika");
	Thread.sleep(10);
	System.out.println(driver.findElement(By.id("email")).getText());
	
	/*FluentWait<WebDriver>w = new FluentWait<WebDriver>(driver);
	w.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.id("eil")));
	//w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("eil"))));
	driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();
	
	*/
	//em.sendKeys("Deepika");
	Set<String> windows = driver.getWindowHandles();
	System.out.println(windows.size());
	for(String h : windows){
		
		driver.switchTo().window(h);
		System.out.println("An exceptional case");
		
	}
	 
	
	driver.close();
	

}
}