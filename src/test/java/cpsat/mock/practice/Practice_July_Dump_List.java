package cpsat.mock.practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.ExcelUtility;
import com.testing.base.TestBase;

public class Practice_July_Dump_List extends TestBase {
	 ExcelUtility excel = new ExcelUtility();
	  @Test(dataProvider = "dp")
	  public void f(String s) throws Exception {
		  LIST1_POM ob1=new LIST1_POM(d);
		  ob1.clickList();
		  ob1.searchName(s);
		 /* LIST2_POM ob2=new LIST2_POM(d);
		  LIST3_POM ob3=new LIST3_POM(d);*/
		 
	  }
	  
	  @BeforeTest
	  public void beforeMethod() throws InterruptedException {
		  init("Chrome","https://examjuly2021.agiletestingalliance.org/");
		  checkPageReady();
	  }
	  @AfterTest
	  public void afterMethod() {
		  terminate();
	  }


	  @DataProvider
	  public Object[][] dp() {
	      Object[][] data = ExcelUtility.getTestDataFromExcel("Sheet1");
	      return data;
	  }
	}
