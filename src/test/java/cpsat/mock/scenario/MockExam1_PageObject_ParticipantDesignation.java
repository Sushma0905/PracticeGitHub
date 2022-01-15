package cpsat.mock.scenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.pageobjects.MockExam1_Junit_PageObject_Searchdesignation;
import com.pageobjects.MockExam1_Junit_PageObject_searchParticipant;
import com.testing.base.TestBase;

public class MockExam1_PageObject_ParticipantDesignation extends TestBase {
	
	@Before
	public void initiate(){
		init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");
		if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
			d.findElement(By.xpath("//div[contains(@class,'dialog-lightbox-close-button')]")).click();
		}
	}

	@Test
	public void miantest() throws Exception{
		checkPageReady();
		MockExam1_Junit_PageObject_searchParticipant junit = new MockExam1_Junit_PageObject_searchParticipant(d);
		jsClick(d.findElement(junit.Menu));
		scrollIntoView(d.findElement(junit.Participant));
		d.findElement(junit.Participant).click();
		scrollIntoView(d.findElement(junit.Designation));
		checkPageReady();
		junit.searchDesignation("consultant");
		junit.searchDesignation("Test");
	}
	
	@After
	public void closebrow(){
		close();
	}
}
