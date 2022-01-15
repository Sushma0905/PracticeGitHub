package cpsat.mock.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class practice_MCQ extends TestBase{

		WebDriver driver;
	//	DemoAUTLogin objLogin;

	@BeforeTest
	public void setup(){
		init("Chrome", "http://newtours.demoaut.com");
	}
	@Test(priority=0)
	public void test_Home_page_Appear_correct(){
		//Assert.assertEquals(actual, expected);
	Assert.assertEquals(driver.getTitle(),"Find a Flight: Mercury tours:");
	}
	}






