package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class MockExam2_Question_PageObject extends TestBase{
	
	WebDriver d;
	public MockExam2_Question_PageObject(WebDriver d){
		this.d=d;
	}
	
	By About = By.xpath("//div[@id='primary-menu']//a[contains(@href,'about')]");
	By table = By.xpath("//table[@data-footable_id='483']");
	By searchText = By.xpath("//input[@aria-label='Search in Table']");
	By tableData = By.xpath("//tbody//tr//td[@style='display: table-cell;']");
	//By searchResult=By.xpath("//tbody//tr[@style='display: table-row;']//td");
	By noData = By.xpath("//tr[@class='footable-empty']/td");
	
	
	
	public void clickLink() throws Exception{
		d.findElement(About).click();
	}
	
	//table[@data-footable_id='483']
	
	public List<String>searchYearWiseParticipants(String year){
		ArrayList<String> searchData = new ArrayList<String>();
	//waitForElementToVisible( d.findElement(table));
		//scrollIntoView(d.findElement(searchText));
		wait(1);
		d.findElement(searchText).sendKeys(year);
		List <WebElement> results=d.findElements(tableData);
		System.out.println("Size:" +results.size());
		if(results.size()>0){
		for(WebElement res: results){
			String data = res.getText();
			searchData.add(data);
		}
		
		System.out.println("Searched data: " +searchData);}
		else{
			
			System.out.println(d.findElement(noData).getText());
		}
		
		return searchData;
		
	}


	
	
}
