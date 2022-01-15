package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set3_Question1_jQuery extends TestBase{
	
	@BeforeMethod
	public void method1()
	{
		//open url https://jqueryui.com/checkboxradio/ 
		init("Chrome","https://jqueryui.com/checkboxradio/");
	}
	
	@Test
	public void Test1() throws InterruptedException
	{
		wait(3);
		//verify whether Paris radio button is selected. If not, select it
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement parisButton = d.findElement(By.xpath("//label[@for='radio-2']"));
		scrollIntoView(parisButton);
		if(parisButton.isSelected()){
			System.out.println(parisButton +"is selected ");
		
		}
		else{
			wait(2);
			parisButton.click();
			//takeScreenShot("cpsatJunitSet3_Question3");
		}
		
		/*//select all checkboxes for RadioGroup
		List<WebElement> radiocheckboxes = d.findElements(By.xpath("//legend[text()='Select a Location: ']/../label"));
		scrollIntoView(d.findElement(By.xpath("(//legend[text()='Select a Location: ']/../label)[1]")));
		for(WebElement radio: radiocheckboxes){
			if(radio.isSelected()){
				System.out.println("Checkbox under radiogroup already checked :" +radio.getText());
			}else{
				radio.click();
				System.out.println("Checkbox under radiogroup checked:" +radio.getText());
			}
		}
		takeTheScreenShot("cpsatJunitSet3_Question3");
		
		List<WebElement> Hotelcheckboxes = d.findElements(By.xpath("//legend[text()='Hotel Ratings: ']/../label"));
		scrollIntoView(d.findElement(By.xpath("(//legend[text()='Hotel Ratings: ']/../label)[1]")));
		for(WebElement hotel: Hotelcheckboxes){
			if(hotel.isSelected()){
				System.out.println("Checkbox under radiogroup already checked :" +hotel.getText());
			}else{
				hotel.click();
				System.out.println("Checkbox under radiogroup checked:" +hotel.getText());
			}
		}
		takeTheScreenShot("cpsatJunitSet3_Question3");
		
		List<WebElement> Bedcheckboxes = d.findElements(By.xpath("//legend[text()='Bed Type: ']/../label"));
		scrollIntoView(d.findElement(By.xpath("(//legend[text()='Bed Type: ']/../label)[1]")));
		for(WebElement bed: Bedcheckboxes){
			if(bed.isSelected()){
				System.out.println("Checkbox under radiogroup already checked :" +bed.getText());
			}else{
				bed.click();
				System.out.println("Checkbox under radiogroup checked:" +bed.getText());
			}
		}
		takeTheScreenShot("cpsatJunitSet3_Question3");
		wait(4);*/
		
		
		
		wait(2);
		//Select all the checkboxes. 
		List<WebElement>Checkboxes = d.findElements(By.xpath("//label[contains(@class,'checkboxradio-label')]"));
		System.out.println(Checkboxes.size());
		for(int i =0;i<Checkboxes.size();i++){
			if(Checkboxes.get(i).isSelected()){
				System.out.println(Checkboxes.get(i).getText() +" checkbox is already selected");
			}
			else{
				Checkboxes.get(i).click();
				System.out.println(Checkboxes.get(i).getText() +" checkbox is selected");
			
			}
		}
		//takeTheScreenShot("cpsatJunitSet3_Question3");
		wait(3);
	}
	
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}

}

