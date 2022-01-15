package cpsat.mock.scenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2A_Question4_WoodLands extends TestBase{
	ArrayList<String> priceList = new ArrayList<String>();
	ArrayList<String> sortedprice = new ArrayList<String>();
	boolean flag;
	
	@BeforeTest
	public void initiatebrowser(){
		init("Chrome", "https://www.woodlandworldwide.com/");
	}

	@Test
	public void maintest() throws Exception{
		checkPageReady();
		for(int i =0;i<3;i++){
			String data = readData("src\\test\\resources\\TestData\\WoodLand.xlsx", "TestData", i, 0);
			System.out.println(data);
			WebElement search = d.findElement(By.xpath("//input[@id='searchKey']"));
			search.clear();
			//search.click();
			search.sendKeys(data);
			search.sendKeys(Keys.ENTER);
			wait(2);
			Actions act = new Actions(d);
			WebElement sortby =d.findElement(By.xpath("//div[contains(@class,'input-select sortcategory')]"));
			act.moveToElement(sortby).click().build().perform();
	 WebElement lowTohigh = d.findElement(By.xpath("//a[text()='Price: Low To High']"));
	 lowTohigh.click();
	 wait(2);
	 
	 //Verify the first 8 products are displayed in ascending order of price as per filter.
	List<WebElement> product = d.findElements(By.xpath("//div[contains(@class,'product-cards')]//div[contains(@class,'product-container')]//span[contains(@class,'price')]"));
	
	 for(int j =0; j<8;j++){
		 String value = product.get(j).getText();
		 String afterreplace =value.replaceAll("[^0-9]","");
		 priceList.add(afterreplace);
		// System.out.println("Price :" +product.get(j).getText());
		 System.out.println("After replacement:" +afterreplace);
		 Collections.sort(priceList); 
		 sortedprice.addAll(priceList);
		 Collections.sort(sortedprice, Collections.reverseOrder());
	 }
	 System.out.println("second sorting:" +priceList);
	 for(int m=0;m<=priceList.size()-1;m++) {
		  if((priceList.get(m)).equals(sortedprice.get(m)))
				  flag = false;
		}

 if(flag==true)
		System.out.print("The first 8 products are displayed in descending order of the price" +priceList); 
 
  else
	System.out.println("The first 8 products are displaying in ascending order of the price for "+priceList);

			
		}
	
		
	}
	@AfterTest
	public void terminatebrowser(){
		terminate();
	}
}
