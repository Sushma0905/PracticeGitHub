package cpsat.mock.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set3_Question4_mptourism extends TestBase {

	@BeforeTest
	public void before(){
		init("Chrome", "http://www.mptourism.com/");
	}
	
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		for(int i =0; i<3;i++){
			String data =readData("src\\test\\resources\\TestData\\MpTourism.xlsx", "MpTourism", i, 0);
			System.out.println(data);
			
			d.findElement(By.xpath("//a[text()='Search']")).click();
			wait(2);
			d.findElement(By.xpath("//input[@id='keyword']")).sendKeys(data);
			d.findElement(By.xpath("//input[@id='keyword']")).sendKeys(Keys.ENTER);
			String searchResults =d.findElement(By.xpath("//span[contains(text(),'Search Result for:')]")).getText();
			System.out.println("Search Results:" +searchResults);
		}
		
	}
	
	@AfterTest
	public void terminatebrowser(){
		terminate();
	}
}
