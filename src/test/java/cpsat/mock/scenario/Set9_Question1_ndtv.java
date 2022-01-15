package cpsat.mock.scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.Set9_Question1_TopLocators;
import com.testing.base.TestBase;



public class Set9_Question1_ndtv extends TestBase{

	
@BeforeTest
public void initiateBrwser(){
	init("Chrome", "https://www.ndtv.com/business");
}


@Test
public void maintest() throws Exception{
	checkPageReady();
	Set9_Question1_TopLocators top = new Set9_Question1_TopLocators();
	System.out.println(d.findElement(top.getArt()).getAttribute("href"));
	System.out.println(d.findElement(top.getAuto()).getAttribute("href"));
	System.out.println(d.findElement(top.getCricket()).getAttribute("href"));
	System.out.println(d.findElement(top.getCrypto()).getAttribute("href"));
	System.out.println(d.findElement(top.getEducation()).getAttribute("href"));
	System.out.println(d.findElement(top.getFOOD()).getAttribute("href"));
	System.out.println(d.findElement(top.getBusiness()).getAttribute("href"));
	System.out.println(d.findElement(top.getMovies()).getAttribute("href"));
	System.out.println(d.findElement(top.getShopping()).getAttribute("href"));
	System.out.println(d.findElement(top.getStyle()).getAttribute("href"));
	
	List<WebElement> toplocators = d.findElements(By.xpath("//div[@class='nglobalnav']//a"));
	for(WebElement loc : toplocators){
		System.out.println("Attributes:" +loc.getAttribute("href"));
	}
	
	List<WebElement> bottomLocators = d.findElements(By.xpath("//li[@class='more']/a"));
	for(WebElement loc : bottomLocators){
		System.out.println("Attributes:" +loc.getAttribute("href"));
	}
	
	
	//Assert that the business href in the top and bottom locators are same. 
	String topBusiness = d.findElement(top.getBusiness()).getAttribute("href");
	String footBusiness = d.findElement(By.xpath("//li[@class='more']/a[contains(text(),'Business')]")).getAttribute("href");
	
	if(topBusiness.equalsIgnoreCase(footBusiness)){
		System.out.println("Both Top and foot business links are same");
	}
	else{
		Assert.fail("Both are not same");
	}
	
	
}
}
