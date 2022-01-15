package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.testing.base.TestBase;



public class Set2A_Question6_OnlineRegistration extends TestBase{

	@Before
	public void initiatebrowser(){
		init("Chrome", "https://www.cii.in/OnlineRegistration.aspx");
	}
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		//Select number of attendees to be 7. 
		scrollUp();
		scrollUp();
		scrollIntoView(d.findElement(By.xpath("//select[@id='drpAttendee']")));
		WebElement NumberAttendee = d.findElement(By.xpath("//*[@id='drpAttendee']"));
		scrollIntoView(NumberAttendee);
		Select Attendee = new Select(NumberAttendee);
		Attendee.selectByValue("7");
		//Verify a table with 7 rows are displayed
		wait(2);
		//WebElement table = d.findElement(By.xpath("//*[@id='Gridview1']/tbody"));
		List<WebElement> rows = d.findElements(By.xpath("//*[@id='Gridview1']//tr//select"));
		System.out.println("rows:" +rows.size());
		Assert.assertEquals(7, rows.size());
		
		//Select different options for Title for 3 rows in the table using different select options
		Select firstTitle = new Select(rows.get(0));
		firstTitle.selectByIndex(1);
		System.out.println("Display the first value selected:" +rows.get(0).getText());
		
		Select secondTitle = new Select(rows.get(1));
		secondTitle.selectByValue("Air Chief");
		System.out.println("Display the Second value selected:" +rows.get(1).getText());
		
		Select thirdTitle = new Select(rows.get(2));
		thirdTitle.selectByVisibleText("Ambassador");
		System.out.println("Display the Second value selected:" +rows.get(2).getText());
		
		//Display all the options present in the title drop down.
	List<WebElement> titleDropdown =d.findElements(By.id("//*[@id ='Gridview1_ctl02_drpTitle']/option"));
	for(WebElement dp : titleDropdown){
		System.out.println("Dropdown values in Title element :" +dp.getText());
	}
	
	
	
	
	
	}
	
	@After
	public void terminate(){
		terminate();
	}
}
