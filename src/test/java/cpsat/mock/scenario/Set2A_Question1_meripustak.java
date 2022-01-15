package cpsat.mock.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2A_Question1_meripustak extends TestBase{
	@BeforeTest
	public void initiateborwser(){
		init("Chrome", "https://www.meripustak.com");
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		
		//Print the height and width of the logo
		WebElement logo = d.findElement(By.xpath("//img[@title='Meripustak Online bookstore']"));
		Dimension LogoDimension = logo.getSize();
		System.out.println(" Logo Dimensions:" +logo.getSize());
		int HeightLogo = LogoDimension.height;
		System.out.println("Logo Height: " +HeightLogo);
		int WidthLogo = LogoDimension.width;
		System.out.println(" Logo Width: " +WidthLogo);
		
		//Print the pinterest target url under follow us
		scrollDown();
		wait(2);
		scrollIntoView(d.findElement(By.xpath("(//div[contains(@class,'social links')]//a)[4]")));
		WebElement pinterestLogo = d.findElement(By.xpath("(//div[contains(@class,'social links')]//a)[4]"));
		String pinterestTargeturl = pinterestLogo.getAttribute("href");
		System.out.println("TragetUrl:" +pinterestTargeturl);
		wait(3);
		scrollUp();
		//Click on the shopping cart. Verify the message "No Item is Added In Cart yet.Cart is Empty!!!” in cart table
		WebElement cart = d.findElement(By.xpath("//a[text()='Shopping Cart']"));
		scrollIntoView(d.findElement(By.xpath("//a[text()='Shopping Cart']")));
		
		cart.click();
		wait(2);
		WebElement verifyEmptyCart = d.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvCartTable']//h4"));
		System.out.println("Empty cart Message:" +verifyEmptyCart.getText());
		Assert.assertEquals(verifyEmptyCart.getText(), "No Item is Added In Cart yet.Cart is Empty!!!");
		
		//Search and add any cricket book in cart and verify the “no items is added .. 
		//“message no longer appears in table.
		
		WebElement searchTextField = d.findElement(By.xpath("//input[@id='txtsearch']"));
		searchTextField.sendKeys("cricket");
		d.findElement(By.xpath("//a[@id='btnsearch']")).click();
		
		WebElement firstproduct = d.findElement(By.xpath("(//*[@id='book_list']/ul/li)[1]//p[contains(@class,'btn-add')]"));
		firstproduct.click();
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//a[text()='Shopping Cart']")));
		d.findElement(By.xpath("//a[text()='Shopping Cart']")).click();
		wait(2);
		Assert.assertNotEquals(d.findElement(By.xpath("(//*[@id='ContentPlaceHolder1_gvCartTable']//td/a)[1]")).getText(), "No Item is Added In Cart yet.Cart is Empty!!!");
		System.out.println("Cart Message after adding items: " +d.findElement(By.xpath("(//*[@id='ContentPlaceHolder1_gvCartTable']//td/a)[1]")).getText());
		
	}
	
	@AfterTest
	public void close(){
		terminate();
		
	}

}
