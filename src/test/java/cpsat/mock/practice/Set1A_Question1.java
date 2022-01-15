package cpsat.mock.practice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;



public class Set1A_Question1 extends TestBase {
	
	@BeforeTest
	public void initiatebrowser(){
		init("Chrome", "https://www.rediff.com/");
	}

	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		WebElement news = d.findElement(By.xpath("//ul[@class='navbarul']//li[@class='news']"));
		news.click();
		wait(2);
		takeTheScreenShot("Set1aQuestion1");
		
		List<WebElement> submenu = d.findElements(By.xpath("//div[@class='subnavbar news']//li"));
		for(int i = 0; i< submenu.size();i++){
			System.out.println("Href of all submenus: "  +submenu.get(i).getText());
		}
		//Assert that the tool tip of the adjacent menu item Business is “Business Headlines” 
		
		WebElement Business = d.findElement(By.xpath("//ul[@class='navbarul']//a[contains(@href,'business')]"));
		String Actualtooltip = Business.getAttribute("title");
		System.out.println("Actual:" +Actualtooltip);
		Assert.assertTrue(Actualtooltip.equalsIgnoreCase("Business Headlines"));
		
		//Hover the mouse on the adjacent menu item (Business) showing the tool tip “Business Headlines”. 
		//Take a screenshot showing the tooltip (4 marks)
		
		Actions Act = new Actions(d);
		Act.moveToElement(Business).build().perform();
		//wait(1);
		//takeScreenShotTip("set1A", "Question1");
		
		//. Assert that the background colour of the submenu items for News is having the following RGB (188, 62, 49) value
		String newsColor = d.findElement(By.xpath("//li[text()='NEWS']")).getCssValue("background-color");
		System.out.println("News color:" +newsColor);
		String cl = Color.fromString(newsColor).asRgb();
		System.out.println("Background:" +cl);
		Assert.assertTrue(cl.equalsIgnoreCase("RGB(188, 62, 49)"));
		String[] s = cl.split(",");
		for(String t :s){
			System.out.println(t);
		}
		
		
		d.get("https://www.color-blindness.com/color-name-hue/ ");
		checkPageReady();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[contains(@src,'color-name-hue-tool')]")));
		//d.findElement(By.xpath("//input[@id='cp1_RedRadio']")).click();
		d.findElement(By.xpath("//input[@id='cp1_Red']")).click();
		d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys("-");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys(s[0].replaceAll("[^0-9]", ""));
		d.findElement(By.xpath("//input[@id='cp1_Green']")).click();
		d.findElement(By.xpath("//input[@id='cp1_Green']")).sendKeys("-");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='cp1_Green']")).sendKeys(s[1].replaceAll("[^0-9]", ""));
		d.findElement(By.xpath("//input[@id='cp1_Blue']")).click();
		d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys("-");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys(s[2].replaceAll("[^0-9]", ""));
		String actualColor = d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText();
		System.out.println("actualColort:" +actualColor);
		Assert.assertTrue(actualColor.equalsIgnoreCase("Grenadier"));
		
		
	}
	
	@AfterTest
	public void closebrow(){
		close();
	}
}
