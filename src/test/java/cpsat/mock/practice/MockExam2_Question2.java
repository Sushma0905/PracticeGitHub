package cpsat.mock.practice;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.ExcelUtility;
import com.testing.base.TestBase;

public class MockExam2_Question2 extends TestBase{
	ExcelUtility util = new ExcelUtility();
	int counter=1;
	@BeforeMethod
	@Parameters({ "browser" })
	  public void beforeMethod(String browser) throws Throwable {
		init(browser, "https://mockexam2cpsat.agiletestingalliance.org/");
		//close();
				if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
					d.findElement(By.xpath("//i[@class='eicon-close']")).click();
				}
				d.findElement(By.xpath("//div[@id='primary-menu']//a[contains(@href,'about')]")).click();
				wait(2);
				//scrollIntoView(d.findElement(By.xpath("(//div[@class='elementor-text-editor elementor-clearfix']//li[contains(@class,'footable-page visible')]//a)[2]")));
				
				
	}
	

	@Test(dataProvider = "datapro")
	public void f(String city, String Year, String Candidates) throws Exception {
	scrollIntoView(d.findElement(By.xpath("//input[@type='text']")));
	HashMap<String,String> act= new HashMap<String, String>();
		act.put("CITY", city);
		act.put("YEAR ESTABLISHED", Year);
		act.put("No.Candidates Appeared", Candidates);
		boolean resultFlag=false;
		int count=1;
		int pageSize=d.findElements(By.xpath("(//div[@class='footable-pagination-wrapper']//li[contains(@class,'footable-page visible')]//a)")).size();
		
		System.out.println("size: "+pageSize);
		int pagecount=1;
		boolean flag=false;
		for(int j=1;j<=5;j++) {
			count =j;
			String getCity=d.findElement(By.xpath("//tbody//tr["+j+"]//td[@style='display: table-cell;'][1]")).getText();
			if(getCity.trim().equalsIgnoreCase(city)){
				//System.out.println("Website:" +getCity + " excel : " +city);
			resultFlag=true;
			break;
		}
			
			if (count==5) {
				d.findElement(By.xpath("(//div[@class='elementor-text-editor elementor-clearfix']//li[contains(@class,'footable-page visible')]//a)["+pageSize+"]")).click();
				System.out.println(pagecount);
				pagecount++;
				System.out.println(pagecount);
			}	
			j=1;
		
			System.out.println(pagecount);
			if(pageSize==pagecount +1) {
				//System.out.println("Enter to break loop");
				break;
			}
			
			//System.out.println("Website:" +getCity + " excel : " +city);
		}
		
		String getcity=null;
		String getYear=null;
		String getCandidates=null;
		
		
		if(resultFlag) {
			System.out.println("PASS");
			getcity=d.findElement(By.xpath("//tbody//tr["+count+"]//td[@style='display: table-cell;'][1]")).getText();
			getYear=d.findElement(By.xpath("//tbody//tr["+count+"]//td[@style='display: table-cell;'][2]")).getText();
			getCandidates=d.findElement(By.xpath("//tbody//tr["+count+"]//td[@style='display: table-cell;'][3]")).getText();
						
			HashMap<String,String> exp=new HashMap<String,String>();
			exp.put("CITY", getcity);
			exp.put("NAME", getYear);
			exp.put("Candidates", getCandidates);
			
			
			flag=exp.equals(act);
			
		}
		String result="";
		if(flag) {
			result="PASS";
		}
		else
		{
			result="FAIL";
		}
		//setData(fileName, sheetName, rowIndex, cellIndex, data);
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet2", counter, 0, getcity);
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet2", counter, 1, getYear);
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet2", counter, 2, getCandidates);
		setData("src/test/resources/TestData/set_data.xlsx", "Sheet2", counter, 3, result);
		counter++;
		
	}

	@DataProvider
	public Object[][] datapro() throws Exception {
		
		//String data1 = readData("C:/Users/sparalapalle/Documents/CPSAT/CP-SAT Framework_V2.1/CPSATExam/src/test/resources/TestData/MockExam2.xlsx", "Sheet1", 1, 1);
		Object[][] data = util.getTestDataFromExcel("Sheet1");
		
		return data;
	}

	@AfterMethod
	public void afterMethod() {
		d.quit();
	}

}


