package cpsat.mock.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.ExcelUtility;
import com.testing.base.TestBase;

public class MockExam1_Question2 extends TestBase {
	ExcelUtility util = new ExcelUtility();
	@BeforeMethod
	public void initiate(){
		init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");
		if(d.findElements(By.xpath("//div[@data-elementor-type='popup']")).size()>0){
			d.findElement(By.xpath("//div[contains(@class,'dialog-lightbox-close-button')]")).click();
		}
	}

	@Test(dataProvider ="pro")
	public void test1(String Name,String Designation,String Organization) throws Exception{
		/*HashMap<String,String>Data = new HashMap<String,String>();
		Data.put("Name", Name);
		Data.put("Designation", Designation);
		Data.put("Organization", Organization);
		boolean resultflag = false;
		checkPageReady();
		jsClick(d.findElement(By.xpath("//button[@class='menu-toggle']")));
		d.findElement(By.xpath("//a[text()='List of Participants']")).click();
		//List<WebElement> next = d.findElements(By.xpath("//ul[@class='pagination']//li[@data-page='next']"));
		checkPageReady();
		scrollIntoView(d.findElement(By.xpath("//a[text()='List of Participants']")));
		List<WebElement>Rows = d.findElements(By.xpath("(//table[contains(@aria-label,'List of Participants')]//tbody//tr)"));
		
		
		if(Rows.size()>0){
			for(WebElement sea:Rows){
				String getName=d.findElement(By.xpath("//tbody//tr[@style='display: table-row;']["+j+"]//td[1]")).getText();
			if(getName.trim().equalsIgnoreCase(Name)){
				resultFlag=true;
				break;
			}
			if(d.findElements(By.xpath("//ul[@class='pagination']//li[@data-page='next']")).size()>0){
				String nextButton = d.findElement(By.xpath("//ul[@class='pagination']//li[@data-page='next']")).getAttribute("class");
				while(!(nextButton.contains("disabled"))){
					wait(1);
					//next.findElement(By.tagName("a")).c
					d.findElement(By.xpath("//ul[@class='pagination']//li[@data-page='next']//a")).click();
					wait(2);
					List<WebElement>searchList  = d.findElements(By.xpath("(//table[contains(@aria-label,'List of Participants')]//tbody//tr)"));
					for(WebElement sea:searchList){
						Data.add(sea.getText());
					}
					 nextButton = d.findElement(By.xpath("//ul[@class='pagination']//li[@data-page='next']")).getAttribute("class");
				}
			}
			else{
				System.out.println("No Next page");
				}
			System.out.println(Data);
			}
			else{
				System.out.println(d.findElement(By.xpath("//tr[@class='footable-empty']//td")).getText());
			}
		*/
		
		
	}
		
	@DataProvider
	public Object[][] pro(){
		Object[][] data = util.getTestDataFromExcel("Sheet1");
		return data;
		
		
	}

}
