package cpsat.mock.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class MockExam2_Question4 extends TestBase{

	@Parameters({"browser"})
	@BeforeTest
	public void initiate(String browser){
		init(browser, "https://mockexam2cpsat.agiletestingalliance.org/");
		if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
			d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		}
		d.findElement(By.xpath("//div[@id='primary-menu']//a[contains(@href,'about')]")).click();
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		
		//scrollIntoView(d.findElement(By.xpath("//div[contains(@id,'eael-adv-accordion-98d6363')]")));
		List<WebElement> accordionList = d.findElements(By.xpath("//div[contains(@class,'elementor-tab-title eael-accordion-header')]"));
		scrollIntoView(d.findElement(By.xpath("//div[contains(@class,'elementor-widget-eael-adv-accordion')]")));
		System.out.println(accordionList.size());
		for(int i =1; i<=accordionList.size();i++){
		WebElement h = d.findElement(By.xpath("(//div[contains(@class,'elementor-tab-title eael-accordion-header')])["+i+"]"));
		
			//WebElement accordion = d.findElement(By.xpath("//div[@class='elementor-tab-title eael-accordion-header']"));
		String beforeColor =	h.getCssValue("background-color");
		jsClick(h);
		String afterColor =	h.getCssValue("background-color");
			wait(1);
			takeScreenShotTip("Mockexam2", "Accordion");
			String content = h.findElement(By.xpath("(//div[contains(@class,'eael-accordion-content')])["+i+"]")).getText();
			System.out.println(content);
			
			String beforecol =Color.fromString(beforeColor).asRgb();
			
			System.out.println(beforecol);
			System.out.println(afterColor);
			
			
		}
	}
	@Test
	public void maintest2() throws Exception{
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//div[@data-id='8c2adfc']")));
		wait(1);
		List<WebElement> speakers = d.findElements(By.xpath("//h3[@class='elementor-image-box-title']//a"));
		System.out.println("Number of speakers :" +speakers.size());
		for(int i =0; i<speakers.size();i++){
			wait(1);
			String speakerName =speakers.get(i).getText();
			String after = speakerName.replace(" ", "-");
			System.out.println("speakerName :" +speakerName);
			System.out.println(after.toLowerCase());
			String speakerHref = speakers.get(i).getAttribute("href");
			System.out.println("speakerName :" +speakerHref);
			Assert.assertTrue(speakerHref.contains(speakerName.replace(" ", "-").toLowerCase()));
			
		}
		
	}
	@Test
	public void maintest3() throws Exception{
		wait(2);
		scrollIntoView(d.findElement(By.xpath("//div[@class='eael-twitter-feed-item-content']//p")));
		List<WebElement> feed = d.findElements(By.xpath("//span[contains(@aria-label,'Go to slide')]"));
		System.out.println(feed.size());
		for(int i =1; i<feed.size()+1;i++){
			d.findElement(By.xpath("//span[contains(@aria-label,'Go to slide')]["+i+"]"));
			//feed.get(i).click();
			//wait(2);
			String f = d.findElement(By.xpath("(//span[contains(@aria-label,'Go to slide')]//preceding::div[@class='eael-twitter-feed-item-content']//p)["+i+"]")).getText();
			wait(2);
			System.out.println("Data:" +f);
		}
	}
	
	@Test
	public void maintest4() throws Exception{
		wait(2);
		List<WebElement> logos = d.findElements(By.xpath("//div[@class='elementor-image']"));
		System.out.println("Logo's Size :" +logos.size());
		for(int i =1; i<logos.size()+1; i++){
			Actions act = new Actions(d);
			WebElement logo1 = d.findElement(By.xpath("(//div[@class='elementor-image'])["+i+"]"));
			act.clickAndHold(logo1).perform();
			wait(1);
			takeScreenShotTip("Mockexam2", "Question5");
			wait(2);
			String toolTip = d.findElement(By.xpath("(//div[@class='tippy-content'])")).getText();
			System.out.println("Tool tip :" +toolTip);
		}
		}
		
	
	@AfterTest
	public void closeBrow(){
		close();
	}
}
