package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testing.base.TestBase;

public class Set3_Question3_cii_PageObject extends TestBase{
	
	WebDriver d;
	
	public Set3_Question3_cii_PageObject(WebDriver d){
		this.d=d;
		
	}
	
	public By contact=By.xpath("//a[contains(text(),'Contact Us')]");
	By icons=By.xpath("//div[@class='icons-container']//a/span");
	
	 public void  listOfIcons(){
		 List<WebElement> Icons = d.findElements(icons);
		 System.out.println(Icons.size());
		 for(int i =0;i<Icons.size();i++){
			 Icons.get(i).getText();
			 //System.out.println("Icon Name:" + Icons.get(i).getText());
			String[] part = Icons.get(i).getText().split("/");
			 System.out.println(part[1]);
		 }
		 
		 }
	
	public void contact() {
		d.findElement(contact).click();
	}
	
	/*public void assertparticularElement(String Element, String Expected){
		String Actual =d.findElement(By.xpath(Element)).getText();
		Assert.assertTrue(Actual.equals(Expected));
	}*/

	public void assertparticularElement(String element, String expected) {
		// TODO Auto-generated method stub
		String Actual =d.findElement(By.xpath(element)).getText();
		Assert.assertTrue(Actual.equals(expected));
	}

	
	
		// return Icons.get(i).getText();
		 
	 }


