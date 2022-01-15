package cpsat.mock.scenario;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.pageobjects.Set7_Question1_Shopper_PF;
import com.testing.base.TestBase;

public class Set7_Question1_Shopperstop extends TestBase{

	
	@Before
	public void initiate(){
		init("Chrome", "http://www.shoppersstop.com");
	}
	
	@Test
	public void maintest() throws Exception{
		Set7_Question1_Shopper_PF pF = new Set7_Question1_Shopper_PF(d);
		checkPageReady();
		Actions act = new Actions(d);
	act.moveToElement(d.findElement(pF.getBrand())).build().perform();
	wait(3);
	act.moveToElement(d.findElement(pF.getStop())).build().perform();
	wait(3);
	act.moveToElement(d.findElement(pF.getHauteCurry())).click().build().perform();
	checkPageReady();
	//takeScreenShot("cpSat_set7Question1");
	
Assert.assertTrue(d.getTitle().contains("Haute Curry"));
	System.out.println(d.getTitle());
	//Verify the text “Start Something New”
	
	/*if(d.findElement(By.xpath("//p[contains(text(),'start something new')]")).isDisplayed()){
		System.out.println("Start Something New is dispalyed");
	}
	else{
		System.out.println("Start Something New is not dispalyed");
	}*/
	
	//In the “FOLLOW US” section, print the URL that the Pinterest logo points to.
    scrollDown();
    wait(1); 
	scrollIntoView(d.findElement(pF.getinstagram()));
	if(d.findElement(pF.getinstagram()).isDisplayed()){
		String uRL = d.findElement(pF.getinstagramUrl()).getAttribute("href");
		System.out.println("Instagram url :" +uRL);
	}
	
	}
}
