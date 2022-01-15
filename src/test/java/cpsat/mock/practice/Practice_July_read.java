package cpsat.mock.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Practice_July_read extends TestBase {
	
	@BeforeTest
	public void initiate(){
		init("Chrome", "https://examjuly2021.agiletestingalliance.org/");
		
	}
	
	

	
	@Test
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
		for(int i =1; i<5;i++){
			for (int j =0;j<5;j++){
				String data = readData("src/test/resources/TestData/July_practice.xlsx", "Form", i, j);
				scrollIntoView(d.findElement(By.xpath("//input[@id='ff_1_names_first_name_']")));
				d.findElement(By.xpath("//input[@id='ff_1_names_first_name_']")).sendKeys(FullName);
				d.findElement(By.xpath("//input[@id='ff_1_names_last_name_']")).sendKeys(LastName);
				d.findElement(By.xpath("//input[@id='ff_1_email']")).sendKeys(Email);
				Select se = new Select(d.findElement(By.xpath("//select[@id='ff_1_department']")));
				se.selectByVisibleText(Language);
				d.findElement(By.xpath("//input[@id='ff_1_subject']")).sendKeys(subject);
			}
		}
		
		
	}
	
	
}