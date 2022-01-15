package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set5_Question1_meripustak extends TestBase {

	
	@BeforeTest
	public void initiatebrowser(){
		init("Chrome", "http://www.meripustak.com/");
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		//”. These keywords are saved in an Excel file, read the search keywords from this file
		for(int i =0; i<3;i++){
		String data =readData("src\\test\\resources\\TestData\\meripustak.xlsx", "Books", i, 0);
		System.out.println("Data:" +data);
		d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys(data);
		d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys(Keys.ENTER);
		wait(3);
		//Check the price of the books and print the new price of 
		//only those books which has discounted price in the eclipse log
		
//List<WebElement> ListOfBooks = d.findElements(By.xpath("//div[@id='book_list']/ul/li/div[@itemprop='offers']"));
		for(int j =1;j<=10;j++){
			String BookName = d.findElement(By.xpath("(//span[@itemprop='name'])["+j+"]")).getText();
			//System.out.println("BookName is :" +BookName);
			String ActualPrice = d.findElement(By.xpath("(//div[contains(@class,'price left')])["+j+"]")).getText();
			//System.out.println("Actual Price:" +ActualPrice);
			String ac = ActualPrice.replaceAll("/-", "").replace("Rs.", "");
			int actual = Integer.parseInt(ac);
			//System.out.println("Actual Price:" +actual);
			String DiscountPrice = d.findElement(By.xpath("(//div[contains(@class,'price right')])["+j+"]")).getText();
			//System.out.println("Discount Price:" +DiscountPrice);
			String dc = DiscountPrice.replaceAll("/-", "").replace("Rs. ", "");
			int Discount = Integer.parseInt(dc);
			//System.out.println("Actual Price:" +Discount);
			if(actual>Discount){
			System.out.println("BookName is :" +BookName +"and " + "Discount Price:" +DiscountPrice);
			}
			}
		}
		}
	
	@AfterTest
	public void closeBrowser(){
		terminate();
	}
}
