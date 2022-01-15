package cpsat.mock.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set1A_Question2_DataProvider extends TestBase{
	@BeforeTest
	public void initiateBrowser() throws Exception{

		init("Chrome", "http://www.pepperfry.com/");
		checkPageReady();
		wait(1);
		if (d.findElements(By.xpath("//div[@class='popup-box gb-modal reg_modal']/a")).size() > 0) {
			//if (d.findElements(By.xpath("//div[@class='popup-box gb-modal reg_modal']/a")).get(0).isDisplayed()) {
			d.findElement(By.xpath("//div[@class='popup-box gb-modal reg_modal']//a[@class='popup-close']")).click();
		}
		d.switchTo().frame(d.findElement(By.xpath("//iframe[contains(@id,'notification-frame')]")));
		if(d.findElements(By.xpath("//div[@id='webklipper-publisher-widget-container-notification-container']")).size()>0){
			d.findElement(By.xpath("//div[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		}
		d.switchTo().defaultContent();
	}
	//}
	
	@DataProvider(name = "searchproducts")
	public Object[][] products() throws Exception{
		Object[][] data = readData("src/test/resources/TestData/PepperFry_pratice.xlsx", "Sheet1");
	//	System.out.println(data);
		return data;
		
	}
	
	@Test(dataProvider = "searchproducts" )
	public void Menu(String searchproducts) throws Exception{
		checkPageReady();
		//Object[][] data = readData("src/test/resources/TestData/PepperFry_pratice.xlsx", "Sheet1");
		//System.out.println(data);
		//System.out.println(data.length);
		//for(int i =1; i<=data.length;i++){
			WebElement search = d.findElement(By.xpath("//input[@id='search']"));
			search.clear();
			search.sendKeys(searchproducts);
			d.findElement(By.xpath("//input[@id='searchButton']")).click();
			if(d.findElements(By.xpath("//span[contains(text(),'No results found for')]")).size()>0){
				System.out.println("No Results found for :" +searchproducts);
				takeScreenShotTip("Question6", "PepperFry");
			}
			
			else{
				
				d.findElement(By.xpath("//li[@class='drpdwn-price-htol']")).click();
				wait(1);
			waitForElementToClickable(d.findElement(By.xpath("//li[@class='drpdwn-price-htol']")));
			//d.findElement(By.xpath("//li[@class='drpdwn-price-htol']")).click();
			wait(1);
			waitForElementToClickable(d.findElement(By.xpath("//a[text()='Price Low to High']")));
			wait(1);
			d.findElement(By.xpath("//a[text()='Price Low to High']")).click();
			checkPageReady();
			takeScreenShotTip("Question6", "PepperFry");
			}
		}
		
	//}
	
	@AfterTest
	public void closeBrowser(){
		close();
	}
}
