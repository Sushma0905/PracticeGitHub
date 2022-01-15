package cpsat.mock.scenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.Set7_Question3_FirstCry_PF;
import com.testing.base.TestBase;

public class Set7_Question3_FirstCry extends TestBase{

	@BeforeTest
	public void openBrowser(){
		init("Chrome", "http://www.firstcry.com/");
	}
	@Test
	public void mainTest() throws Exception{
		List<Double>listprice= new ArrayList<Double>();
		List<Double>sortedprice= new ArrayList<Double>();
		 boolean flag = false;
		Set7_Question3_FirstCry_PF fc = new Set7_Question3_FirstCry_PF(d);
		checkPageReady();
		for(int i =0;i<1;i++){
			String productsdata = readData("src\\test\\resources\\TestData\\FirstCry.xlsx", "Products", i, 0);
			System.out.println(productsdata);
			WebElement search = d.findElement(By.xpath(fc.searchField));
			search.clear();
			search.sendKeys(productsdata);
			search.sendKeys(Keys.ENTER);
			Actions act = new Actions(d);
			act.moveToElement(d.findElement(By.xpath(fc.sortBy)));
			act.moveToElement(d.findElement(By.xpath(fc.pricesortBy))).click().build().perform();
			wait(2);
			//List<WebElement> Elements = d.findElements(By.xpath("//div[contains(@class,'rupee')]//child::span[1]/a"));
			for(int j =1;j<=8;j++){
				String products = d.findElement(By.xpath("(//div[contains(@class,'rupee')]//child::span[1]/a)["+j+"]")).getText();
				System.out.println(products);
				listprice.add(Double.parseDouble(products));
				System.out.println(listprice);
				sortedprice.add(Double.parseDouble(products));
				System.out.println(sortedprice);
				Collections.sort(listprice);
				Collections.sort(listprice, Collections.reverseOrder());
				System.out.println("After:"+listprice);
				System.out.println("After:"+sortedprice);
			}
					
			 for(int m=0;m<=sortedprice.size()-1;m++) {
				if((listprice.get(m)).equals(sortedprice.get(m)))
						  flag = true;
				}
		
		if(flag==true)
			System.out.println("The first 8 products are displayed in descending order of the price for "+productsdata);  
	  else
		System.out.println("The first 8 products are not displayed in descending order of the price for "+productsdata);
		
	}}
	@AfterTest
	public void closebrowser(){
		close();
	}
	
}
