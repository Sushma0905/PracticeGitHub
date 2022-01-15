package cpsat.mock.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class practice_july extends TestBase {
	int counter =0;
	@BeforeTest
	public void initiate(){
		init("Chrome", "https://examjuly2021.agiletestingalliance.org/");
		
	}
	
	

	
	@Test(dataProvider = "searchproducts" )
	public void maintest(String FullName, String LastName, String Email, String Language, String subject) throws Exception{
		
		checkPageReady();
		WebElement forms = d.findElement(By.xpath("//ul[@id='menu-main-menu']//a[text()='Forms']"));
		Actions act = new Actions(d);
		act.moveToElement(forms).perform();
		d.findElement(By.xpath("//ul[@id='menu-main-menu']//a[text()='Form 1']")).click();
		
		if(d.findElements(By.xpath("//div[@class='dialog-message dialog-lightbox-message']")).size()>0){
			d.findElement(By.xpath("//div[@class='dialog-close-button dialog-lightbox-close-button']")).click();
		}
		
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//input[@id='ff_1_names_first_name_']")));
		d.findElement(By.xpath("//input[@id='ff_1_names_first_name_']")).sendKeys(FullName);
		d.findElement(By.xpath("//input[@id='ff_1_names_last_name_']")).sendKeys(LastName);
		d.findElement(By.xpath("//input[@id='ff_1_email']")).sendKeys(Email);
		Select se = new Select(d.findElement(By.xpath("//select[@id='ff_1_department']")));
		se.selectByVisibleText(Language);
		d.findElement(By.xpath("//input[@id='ff_1_subject']")).sendKeys(subject);
		d.findElement(By.xpath("//button[@type='submit']")).click();
		
	/*	String ErrorMessage = d.findElement(By.xpath("//*[contains(text(),'error')]")).getText();
		System.out.println("Error Message :" +ErrorMessage);*/
	
		List<WebElement> Error = d.findElements(By.xpath("//*[contains(text(),'error')]"));
		System.out.println(Error.size());
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet1", counter, 0, FullName);
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet1", counter, 1, LastName);
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet1", counter, 2, Email);
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet1", counter, 3, Language);
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet1", counter, 4, subject);
		if(Error.size()>0){
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet1", counter, 5, "pass");
		}
	else{
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet1", counter, 5, "fail");
	}
		counter++;
	}
	@DataProvider(name = "searchproducts")
	public Object[][] excel() throws Exception{
		
		Object[][] data = readData("src/test/resources/TestData/Pratice_july.xlsx", "Sheet1");
		System.out.println(data);
		return data;
		
	}
	
	@AfterTest
	public void closebrow(){
		close();
	}
}
