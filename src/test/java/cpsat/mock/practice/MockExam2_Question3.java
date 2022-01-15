package cpsat.mock.practice;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageobjects.MockExam2_Question_PageObject;
import com.testing.base.TestBase;

public class MockExam2_Question3 extends TestBase{

	@Parameters({"browser"})
	@BeforeTest
	public void initate(String browser){
		init(browser, "https://mockexam2cpsat.agiletestingalliance.org/");
		//close();
				if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
					d.findElement(By.xpath("//i[@class='eicon-close']")).click();
				}
				
	}
	
	
	@Test
	public void maintest() throws Exception{
		MockExam2_Question_PageObject pg = new MockExam2_Question_PageObject(d);
		pg.clickLink();
		//checkPageReady();
		pg.searchYearWiseParticipants("199");
		pg.searchYearWiseParticipants("das");
		
		
	}
	
	@AfterTest
	public void closebrow(){
		close();
	}
	
}
