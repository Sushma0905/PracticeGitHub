package cpsat.mock.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;

public class practice_July_dump extends TestBase {
	  @Test
	  public void f() {
		  WebElement forms = d.findElement(By.xpath("//*[@id='menu-main-menu']/li[contains(.,'Forms')]"));
		  Actions act = new Actions(d);
		  act.moveToElement(forms).moveToElement(d.findElement(By.xpath("(//*[@id='menu-main-menu']/li[contains(.,'Forms')]/ul/li/a[text()='Form 1'])[1]"))).click().build().perform();
		  if(d.findElement(By.xpath("//*[@class='eicon-close']")).isDisplayed())
		  {
		  d.findElement(By.xpath("//*[@class='eicon-close']")).click();
		  }
		  scrollIntoView(d.findElement(By.id("fluentform_1")));
		  
		  WebElement lang = d.findElement(By.name("department"));
		  Select sel = new Select(lang);
		  List<WebElement> options = sel.getOptions();
		  List<String> expectedOptions = new ArrayList<String>();
		  List<String> actOptions = new ArrayList<String>();
		  for (WebElement wb : options) {
			  System.out.println(wb.getText());
			  actOptions.add(wb.getText());
		}
		  
		  actOptions.remove(0);
		  expectedOptions.add("CP-SAT (Java)");
		  expectedOptions.add("CP-SAT (Python)");
		  expectedOptions.add("CP-SAT (C@)");
		  SoftAssert st= new SoftAssert();
		  AssertJUnit.assertEquals(actOptions, expectedOptions);
		 /* if(expectedOptions.equals(actOptions)) {
			  System.out.println("Dropdown values match");
			  Assert.assertTrue(true);
			  
			 
		  }
		  else {
			  System.out.println("Dropdown values doen't match");
			  Assert.assertTrue(false);
		  }**/
		  
	  String DefMail = d.findElement(By.name("email")).getAttribute("placeholder");
	  String ExpDefMail = "you@domain.com";
	  
	  AssertJUnit.assertEquals(DefMail, ExpDefMail);
	  
	  String[] emailArr = new String[3];
	  emailArr[0]="Email";
	  emailArr[1]="email@";
	  emailArr[2]="email@.com";
	  
	  for(int j=0;j<emailArr.length;j++) {
		  d.findElement(By.id("ff_1_names_first_name_")).sendKeys("First");
		  d.findElement(By.id("ff_1_names_last_name_")).sendKeys("Last");
		  d.findElement(By.id("ff_1_email")).sendKeys(emailArr[j]);
		  //sel.selectByValue("CP-SAT (Java)");
		  selectFromDropDown(lang,"value","","","CP-SAT (Java)");
		  d.findElement(By.name("subject")).sendKeys("subject");
		  d.findElement(By.xpath("//button[text()='Submit Form']")).click();
		  wait(2);
		  takeTheScreenShot("Question1");
		  d.findElement(By.id("ff_1_email")).clear();
		  d.findElement(By.id("ff_1_email")).clear();
	  }
	  st.assertAll();
	  
	  }
	 /* @BeforeMethod
	  @Parameters("browser")
	  public void beforeMethod(String browser) throws InterruptedException {
		  init(browser,"https://examjuly2021.agiletestingalliance.org/");
		  checkPageReady();
	  }*/
	  
	  
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
