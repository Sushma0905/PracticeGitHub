package cpsat.mock.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Practice_July_Tables_Ticks extends TestBase{
	@Parameters({"browser"})
	@BeforeTest
	public void initiate(String browser) throws Exception{
		init(browser, "https://examjuly2021.agiletestingalliance.org/");
		checkPageReady();
	}
	
	@Test
	public void maintest() throws Exception{
		 WebElement table = d.findElement(By.xpath("//ul[@id='menu-main-menu']//a[text()='Tables']"));
		  Actions act = new Actions(d);
		  act.moveToElement(table).moveToElement(d.findElement(By.xpath("//ul[@id='menu-main-menu']//a[text()='Table 1']"))).click().build().perform();
		 checkPageReady();
		 scrollIntoView(d.findElement(By.xpath("//section[contains(@class,' elementor-section-content-middle')]")));
		 List<WebElement> titles = d.findElements(By.xpath("//h2[@class='title']"));
		for(int i =1; i<=titles.size()+1;i++){
			 WebElement price = d.findElement(By.xpath("(//span[@class='original-price'])"+"["+i+"]"));
			 System.out.println(price);
			 WebElement currency =titles.get(i).findElement(By.xpath("(//span[@class='price-currency'])"+"["+i+"]"));
			 WebElement Period = titles.get(i).findElement(By.xpath("(//span[@class='price-period'])"+"["+i+"]"));
			 System.out.println(price.getText()+currency.getText()+Period.getText());
			 List<WebElement> items = d.findElements(By.xpath("//span[@class='li-icon']"));
			 System.out.println("n" +items.size());
			 List<WebElement> item = titles.get(i).findElements(By.xpath("//i[@class='fas fa-check']"));
			 System.out.println("P" +item.size());
			 
			 ////h2[text()='Basic']//parent::div[@class='header']//following-sibling::div//span[@class='original-price']
		 }
		 
	}
	

}
