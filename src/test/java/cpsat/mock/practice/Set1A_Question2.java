package cpsat.mock.practice;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Set1A_Question2 extends TestBase{
	
	@BeforeTest
	public void initiateBrowser() throws Exception{

		init("Chrome", "https://www.rediff.com/");
	}
	
	@Test
	public void Menu() throws Exception{
		checkPageReady();
		d.findElement(By.xpath("//li[@class='news']//a[contains(@href,'news')]")).click();
		checkPageReady();
		for(int i =1; i<5;i++){
				String excelData = readData("src/test/resources/TestData/Rediff_practice.xlsx", "Sheet1", i, 0);
				System.out.println("Excel data : "+excelData);
				Object[][] dataProviderData = readData("src/test/resources/TestData/Rediff_practice.xlsx", "Sheet1");
				System.out.println("Data Provider: " +dataProviderData);
				WebElement newsMenu = d.findElement(By.xpath("//li[@class='news']"));
				String expectedMenu = newsMenu.getText();
				System.out.println("ExpectedMenu:" +expectedMenu);
				Assert.assertTrue(excelData.equalsIgnoreCase(expectedMenu));
			}
	}

	
	@Test
	public void subMenu() throws Exception{
		//d.findElement(By.xpath("//li[@class='news']//a[contains(@href,'news')]")).click();
		//checkPageReady();
		List<String>ActualSubmenu = new ArrayList<String>();
		List<String>ExpectedSubmenu = new ArrayList<String>();
		
		List<WebElement> newssubMenu = d.findElements(By.xpath("//div[@class='subnavbar news']//li//a"));
		for(int j =0; j<4;j++){
			ActualSubmenu.add(newssubMenu.get(j).getText().toLowerCase());
		}
		//System.out.println("Actual submenu:" +ActualSubmenu);
		for(int i =1; i<5;i++){
				String excelData = readData("src/test/resources/TestData/Rediff_practice.xlsx", "Sheet1", i, 1);
			//	System.out.println("Excel data : "+excelData);
				ExpectedSubmenu.add(excelData.toLowerCase());
			}
		System.out.println("ExpectedSubmenu:" +ExpectedSubmenu);
		Assert.assertTrue(ActualSubmenu.equals(ExpectedSubmenu));
	}
	@Test
	public void subhref() throws Exception{
		//d.findElement(By.xpath("//li[@class='news']//a[contains(@href,'news')]")).click();
		//checkPageReady();
		List<String>Actualhref = new ArrayList<String>();
		List<String>Expectedhref = new ArrayList<String>();
		
		List<WebElement> newssubMenu = d.findElements(By.xpath("//div[@class='subnavbar news']//li//a"));
		for(int j =0; j<4;j++){
			Actualhref.add(newssubMenu.get(j).getAttribute("href").trim());
		}
		System.out.println("Actual  submenu:" +Actualhref);
		for(int i =1; i<5;i++){
				String excelData = readData("src/test/resources/TestData/Rediff_practice.xlsx", "Sheet1", i, 2);
			//	System.out.println("Excel data : "+excelData);
				Expectedhref.add(excelData.trim());
			}
		System.out.println("ExpectedSubmenu:" +Expectedhref);
		//Assert.assertEquals(Actualhref,Expectedhref);
		
		if(Actualhref.equals(Expectedhref)){
			System.out.println("Actual href and Expected href are matching");
		}
		else{
			System.out.println("Actual href and Expected href are not matching");
		}
		
	}
	
	@Test
	public void subMenuLink() throws Exception{
		d.findElement(By.xpath("//li[@class='news']//a[contains(@href,'news')]")).click();
		checkPageReady();
		List<WebElement> newssubMenu = d.findElements(By.xpath("//div[@class='subnavbar news']//li//a"));
		for(int j =0; j<4;j++){
			newssubMenu.get(j).click();
			checkPageReady();
			takeScreenShotTip("Set1A_Rediff", "Question2");
			d.navigate().back();
			checkPageReady();
		}
	}
		
	@AfterTest
	public void closebrowser(){
		close();
	}
}
