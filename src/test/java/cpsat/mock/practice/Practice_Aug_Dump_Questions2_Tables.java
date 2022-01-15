package cpsat.mock.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Practice_Aug_Dump_Questions2_Tables extends TestBase {
	  @Test
	  public void f() throws Exception {
		  WebElement table = d.findElement(By.xpath("//ul[@id='menu-main-menu']//a[text()='Tables']"));
		  Actions act = new Actions(d);
		  act.moveToElement(table).moveToElement(d.findElement(By.xpath("//ul[@id='menu-main-menu']//a[text()='Table 1']"))).click().build().perform();
		  String win = d.getWindowHandle();
		  System.out.println("Main Window:" +win);
		  
		  scrollIntoView(d.findElement(By.className("eael-toggle-text")));
		  wait(2);
		 jsClick(d.findElement(By.xpath("//span[@class='eael-toggle-text']")));
		  //d.findElement(By.className("eael-toggle-text")).click();
		  wait(3);
		  //switchWindow(d);
		  System.out.println(d.findElement(By.className("eael-offcanvas-widget-title")).getText());
		  System.out.println(d.findElement(By.xpath("//*[@class='eael-offcanvas-widget-content']/p")).getText());
		  d.findElement(By.xpath("//span[@class='fas fa-times']")).click();
		  //d.switchTo().window(win);
		  scrollIntoView(d.findElement(By.className("eael-twitter-feed-item-inner")));
		  List<WebElement> tweets= d.findElements(By.xpath("//*[@class='eael-twitter-feed-item-content']/p"));
		 List<WebElement> text = d.findElements(By.xpath("//*[@class='eael-twitter-feed-item-content']/p[contains(text(),'#ATAGTR2021')]"));
		  List<WebElement>pagination = d.findElements(By.xpath("(//span[@class='swiper-pagination-bullet'])"));
		  System.out.println("Pagination size:" +pagination.size());
		  for(int k =1; k<pagination.size()-1;k++){
			  WebElement pag = d.findElement(By.xpath("(//span[@class='swiper-pagination-bullet'])"+"["+k+"]"));
			  pag.click();
			  wait(2);
			  List<WebElement> text1 = d.findElements(By.xpath("//div[@class='eael-twitter-feed-item swiper-slide swiper-slide-active' or @class ='eael-twitter-feed-item swiper-slide swiper-slide-next']//p"));
			 System.out.println("slide size:" +text1.size());
			  for(WebElement t :text1){
				  wait(2);
				 String paragraph = t.getText();
				 wait(1);
				 //System.out.println(paragraph);
				  System.out.println("Para:" +paragraph);
				  if(paragraph.contains("#ATAGTR2021"))
					{
						 System.out.println("#ATAGTR2021 text exists in tweet");
					}
					else {
						System.out.println("#ATAGTR2021 text is not present tweet ");
					}
			  }
			  
		  }
		}
		  
		  
		  
	  
	  
	  @BeforeMethod
	 
	  public void beforeMethod() throws InterruptedException {
		  init("Chrome","https://examjuly2021.agiletestingalliance.org/");
		  checkPageReady();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  terminate();
	  }

	}