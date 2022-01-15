package cpsat.mock.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Practice_July_list  extends TestBase {
	HashMap<Integer,ArrayList<String>>hm = new HashMap<Integer,ArrayList<String>>();
	HashMap<String,String> actual = new HashMap<String, String>();
	
	ArrayList<String> ar = new ArrayList<String>();
	
	@BeforeTest
	public void initiate(){
		init("Chrome", "https://examjuly2021.agiletestingalliance.org/");
		
	}
	
	@Test (dataProvider = "List")
	public void maintest(String number, String Candidate , String Certification) throws Exception{
		checkPageReady();
		actual.put("Sr.No", number);
		actual.put("Candidate", Candidate);
		actual.put("Certification", Certification);
		System.out.println("Actual :" +actual);
		
		WebElement Lists = d.findElement(By.xpath("//ul[@id='menu-main-menu']//a[text()='Lists']"));
		Actions act = new Actions(d);
		act.moveToElement(Lists).perform();
		d.findElement(By.xpath("//ul[@id='menu-main-menu']//a[text()='List 1']")).click();
	/*	
		if(d.findElements(By.xpath("//div[@class='dialog-message dialog-lightbox-message']")).size()>0){
			d.findElement(By.xpath("//div[@class='dialog-close-button dialog-lightbox-close-button']")).click();
		}*/
		
		waitForElementToVisible(d.findElement(By.xpath("//table[contains(@data-footable_id,'14207')]")));
		WebElement table = d.findElement(By.xpath("//table[contains(@data-footable_id,'14207')]"));
		scrollIntoView(table);
		List<WebElement>rows = table.findElements(By.xpath("//tr[contains(@class,'ninja_table_row')]//td"));
		//for(int )
		/*for(WebElement row: rows){
			System.out.println(row.getText());
		}*/
		
		List<WebElement> row1 = table.findElements(By.xpath("(//tr[contains(@class,'ninja_table_row')])"));
		//System.out.println("Table row:" +row1.size());
		//System.out.println("Row Data: " +row1);
		for(int i =0; i<row1.size();i++){
			//System.out.println("Row Data: " +row1.get(i).getText());
			List<WebElement> columns = row1.get(i).findElements(By.tagName("td"));
			int count=0;
			//System.out.println("Table columns: " +columns.size());
			for(int j =0;j<columns.size();j++){
				//System.out.println("column data :" +columns.get(j).getText());
				ar.add(columns.get(j).getText());
			}
			hm.put(count, ar);
			count++;
			
			
		}
		System.out.println("HashMap: " +hm);
		if(hm.equals(actual)){
			System.out.println("Data are equal");
		}else{
			System.out.println("Data are not equal");
		}
	}
	
	
	@DataProvider (name = "List")
	public Object[][] excelData() throws Exception{
		Object[][] data = readData("C:/Users/sparalapalle/Documents/CPSAT/CP-SAT Framework_V2.1/CPSATExam/src/test/resources/TestData/July_List.xlsx", "Sheet1");
		return data;
		
	}
	}
