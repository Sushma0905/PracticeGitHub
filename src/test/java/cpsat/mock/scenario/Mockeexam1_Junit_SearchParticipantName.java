package cpsat.mock.scenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pageobjects.MockExam1_Junit_PageObject_searchParticipant;
import com.testing.base.TestBase;

public class Mockeexam1_Junit_SearchParticipantName extends TestBase {
	
	@Before
	public void initiate(){
		init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");
		if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
			d.findElement(By.xpath("//div[contains(@class,'dialog-lightbox-close-button')]")).click();
		}
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		MockExam1_Junit_PageObject_searchParticipant junit = new MockExam1_Junit_PageObject_searchParticipant(d);
		jsClick(d.findElement(junit.Menu));
		scrollIntoView(d.findElement(junit.Participant));
		wait(1);
		junit.clickParticipant();
		scrollIntoView(d.findElement(junit.Name));
		checkPageReady();
		junit.searchParticipantName("test");
		junit.searchParticipantName("capgemini");
		junit.searchParticipantName("ffess");
		
		
	}
	
	@After
	public void closeBrowser(){
		close();
	}

}
