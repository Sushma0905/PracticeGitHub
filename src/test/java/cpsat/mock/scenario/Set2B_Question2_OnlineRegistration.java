package cpsat.mock.scenario;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Set2B_Question2_OnlineRegistration extends TestBase{
	
	@BeforeTest
	public void initiatebrowser(){
		init("Chrome", "https://www.cii.in/OnlineRegistration.aspx");
	}

	@Test
	public void maintest() throws Exception{
		checkPageReady();
		scrollUp();
		WebElement NA= d.findElement(By.id("drpAttendee"));
		Select sel = new Select(NA);
		sel.selectByValue("3");
		List<WebElement> tableRows = d.findElements(By.xpath("//*[@id='Gridview1']//select"));
		Assert.assertEquals(3,tableRows.size());
		//Select 1st-row title as ‘Admiral’
Select firstValue = new Select(tableRows.get(0));
firstValue.selectByIndex(1);
wait(1);
Select SecondValue = new Select(tableRows.get(1));
SecondValue.selectByValue("CA");
wait(1);
Select ThirdValue = new Select(tableRows.get(2));
ThirdValue.selectByVisibleText("CS");
wait(1);

//Print all the options that are available in the title 
Select title = new Select(d.findElement(By.xpath("//*[@id='Gridview1_ctl02_drpTitle']")));
List<WebElement> values = d.findElements(By.xpath("//*[@id='Gridview1_ctl02_drpTitle']/option"));
for(WebElement val : values){
	System.out.println("Values in the dropdown: " +val.getText());
}



		

	}
}
