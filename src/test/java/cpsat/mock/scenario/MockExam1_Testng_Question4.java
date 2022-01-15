package cpsat.mock.scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class MockExam1_Testng_Question4 extends TestBase {
	
@BeforeTest
public void initiate(){
	init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");
}

@Test
public void test1() throws Exception{
	checkPageReady();
	jsClick(d.findElement(By.xpath("//button[@class='menu-toggle']")));
	d.findElement(By.xpath("//a[text()='Challenge 1']")).click();
	checkPageReady();
	if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
	}
	
	List<WebElement> plus = d.findElements(By.xpath("//div[@class='eael-accordion-list']//i[contains(@class,'fa-plus')]"));
	//boolean flag = false;
	for(int i =1; i<=plus.size();i++){
	WebElement sign = 	d.findElement(By.xpath("(//div[@class='eael-accordion-list']//i[contains(@class,'fa-plus')])["+i+"]"));
	String beforeColor = sign.getCssValue("color");
	
	String before = Color.fromString(beforeColor).asRgb();
	System.out.println("Before:" +before);
	sign.click();
	wait(1);
	scrollIntoView(sign);
	takeScreenShotTip("Testng", "Sign"+i);
	String afterColor = sign.getCssValue("color");
	String after = Color.fromString(afterColor).asRgb();
	System.out.println("after:" +after);
	if(before.contains(after)){
		System.out.println(" Matching ");
	}
	else{
		System.out.println("Not Matching ");
	}
	
	}}
	
	@Test
	public void test2() throws Exception{
		checkPageReady();
		jsClick(d.findElement(By.xpath("//button[@class='menu-toggle']")));
		d.findElement(By.xpath("//a[text()='Challenge 2']")).click();
		checkPageReady();
		List<WebElement>Speakers = d.findElements(By.xpath("//div[@class='elementor-row']//h6[contains(@class,'heading-title')]//a"));
		for(WebElement sp : Speakers){
			scrollIntoView(sp);
			System.out.println("Speaker name :" +sp.getText());
		}
	
}
	
	@Test
	public void test3() throws Exception{
		checkPageReady();
		jsClick(d.findElement(By.xpath("//button[@class='menu-toggle']")));
		d.findElement(By.xpath("//a[text()='Challenge 4']")).click();
		checkPageReady();
		List<WebElement>bullet = d.findElements(By.xpath("//div[contains(@class,'swiper-pagination')]//span"));
		for(int i =1;i<=bullet.size();i++){
			d.findElement(By.xpath("(//div[contains(@class,'swiper-pagination')]//span)["+i+"]")).click();
			wait(2);
			WebElement paragraph = d.findElement(By.xpath("(//div[contains(@class,'eael-twitter-feed-item-content')]//p)["+i+"]"));
			scrollIntoView(paragraph);
			System.out.println("Speaker name :" +paragraph.getText());
		}
	
}}

