package cpsat.mock.scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

import org.junit.Assert;

public class Set1a_Rediff extends TestBase{
	//WebDriver driver;
	
	@BeforeMethod
	public void method1(){
		 /*DesiredCapabilities cap = new DesiredCapabilities().chrome();
		   ChromeOptions chrome = new ChromeOptions();
		   chrome.addArguments("incognito");
		   chrome.addArguments("--disable-notifications");
			    System.setProperty("webdriver.chrome.driver",  "C://chromedriver//chromedriver.exe");
			     driver = new ChromeDriver();
			    driver.manage().window().maximize();
			    driver.navigate().to("https://www.rediff.com/");*/
		//a. Open the website https://www.rediff.com/ 
		init("Chrome", "https://www.rediff.com/");
	}
	
	@Test
	public void test() throws InterruptedException{
		/*b. Click on the menu for News (1/2 mark)*/
		
		//driver.findElement(By.xpath("//a[text()='NEWS']")).click();
		
		//waitForElementToVisible(d.findElement(By.xpath("/html/body/div[5]/ul/li[2]/a")));
		//waitForElementToClickable(d.findElement(By.xpath("/html/body/div[5]/ul/li[2]/a")));
		waitForElementToClickable(d.findElement(By.xpath("//a[text()='NEWS']"))).click();
		
		//Take a screenshot (showing that the News is clicked) (1/2 mark)
		takeTheScreenShot("News_Question1");
		wait(2);
		//. Get the Href’s of all the submenu items 
		List<WebElement> submenu = d.findElements(By.xpath("//div[contains(@class,'news')]/ul[contains(@class,'navbarul')]/li/a"));
		for(int i =0; i<submenu.size();i++){
			System.out.println(submenu.get(i).getText()+ " - "+ submenu.get(i).getAttribute("href"));
		}
		
		
		//Asserting that the tool tip of the adjacent menu item Business is “Business Headlines” 
		Assert.assertEquals(d.findElement(By.xpath("//a[text()='BUSINESS']")).getAttribute("title"), "Business headlines");
	
		//Hover the mouse on the adjacent menu item (Business) showing the tool tip “Business Headlines”. Take a screenshot showing the tooltip (4 marks)
		//Hovering the mouse on the adjacent menu item (Business) showing the tool tip “Business Headlines”. 
		WebElement business = d.findElement(By.xpath("/html/body/div[5]/div[1]/ul/li[3]/a"))	;
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView(true);", business);
		Actions act=new Actions(d);
				act.moveToElement(business).build().perform();
				
				Thread.sleep(15000);
				//Taking a screenshot showing the tooltip. 
				takeScreenShotTip("Question1A_ToolTip","Question1");
				
				//Assert that the background colour
				//of the submenu items for News is having the following RGB (188, 62, 49) value. ( 2 Marks)
				
				
				
				String bgcolor = waitForElementToClickable(d.findElement(By.xpath("//li[text()='NEWS']"))).getCssValue("background-color");
				System.out.println("BgColor:" +bgcolor);
				String color = Color.fromString(bgcolor).asRgb();
				System.out.println("Color:" +color);
				Assert.assertEquals(color,"rgb(188, 62, 49)" );
				
				//Assert that the value of RGB in above step maps to the following colour name (Grenadier) – 
				//Hint use the following website to get the colour name from RGB values https://www.color-blindness.com/color-name-hue/ 
				d.navigate().to("https://www.color-blindness.com/color-name-hue/");
				checkPageReady();
				d.switchTo().frame(d.findElement(By.xpath("//iframe[@src='/color-name-hue-tool/color-name-hue.html']")));
				String[] clr = color.split(",");
				d.findElement(By.xpath("//input[@id='cp1_Red']")).click();
				System.out.println("split:" +clr[0].replaceAll("[^0-9]", ""));
				d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys("-");
				wait(3);
				d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys(clr[0].replaceAll("[^0-9]", ""));
				d.findElement(By.xpath("//input[@id='cp1_Green']")).click();
				System.out.println("before:" +clr[1]);
				System.out.println("split:" +clr[1].replaceAll("[^0-9]", ""));
				d.findElement(By.xpath("//input[@id='cp1_Green']")).sendKeys("-");
				wait(3);
				d.findElement(By.xpath("//input[@id='cp1_Green']")).sendKeys(clr[1].replaceAll("[^0-9]", ""));

				d.findElement(By.xpath("//input[@id='cp1_Blue']")).click();
				System.out.println("split:" +clr[1].replaceAll("[^0-9]", ""));
				d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys("-");
				wait(3);
				d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys(clr[2].replaceAll("[^0-9]", ""));
				
				Assert.assertEquals(d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText(), "Grenadier");

				
				
	}

}
