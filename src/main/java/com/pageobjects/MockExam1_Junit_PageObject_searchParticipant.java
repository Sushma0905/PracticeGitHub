package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class MockExam1_Junit_PageObject_searchParticipant extends TestBase{
	WebDriver d; 
	public MockExam1_Junit_PageObject_searchParticipant(WebDriver d){
		this.d=d;
	}
	
	public By Menu = By.xpath("//button[@class='menu-toggle']");
	public By Participant = By.xpath("//a[text()='List of Participants']");
	public By Table = By.xpath("//table[contains(@aria-label,'List of Participants')]");
	public By Name = By.xpath("//tbody//tr//td[@style='display: table-cell;'][1]");
	public By Designation = By.xpath("//tbody//tr//td[@style='display: table-cell;'][3]");
	public By search = By.xpath("//input[@type='text']");
	public By footer = By.xpath("//ul[@class='pagination']//li[contains(@class,'footable-page visible')]");
	public By next = By.xpath("//ul[@class='pagination']//li[@data-page='next']");
	public By Empty = By.xpath("//tr[@class='footable-empty']//td");
	
	public void clickParticipant(){
		d.findElement(Participant).click();
	}
	
	public List<String>searchParticipantName(String Data) throws Exception{
		ArrayList<String> participant = new ArrayList<String>();
		d.findElement(search).sendKeys(Data);
		wait(2);
		List<WebElement> searchList = d.findElements(Name);
		System.out.println("Size of elements:" +searchList.size());
		if(searchList.size()>0){
		for(WebElement sea:searchList){
			participant.add(sea.getText());
		}
		if(d.findElements(next).size()>0){
			String nextButton = d.findElement(next).getAttribute("class");
			while(!(nextButton.contains("disabled"))){
				wait(1);
				//next.findElement(By.tagName("a")).c
				d.findElement(By.xpath("//ul[@class='pagination']//li[@data-page='next']//a")).click();
				wait(2);
				searchList  = d.findElements(Name);
				for(WebElement sea:searchList){
					participant.add(sea.getText());
				}
				 nextButton = d.findElement(next).getAttribute("class");
			}
		}
		else{
			System.out.println("No Next page");
			}
		System.out.println(participant);
		}
		else{
			System.out.println(d.findElement(Empty).getText());
		}
		d.findElement(search).clear();
		return participant;
		
			
			}
		
	public List<String>searchDesignation(String Data) throws Exception{
		ArrayList<String> DesignationEle = new ArrayList<String>();
		d.findElement(search).sendKeys(Data);
		wait(2);
		List<WebElement> searchList = d.findElements(Designation);
		System.out.println("Size of elements:" +searchList.size());
		if(searchList.size()>0){
		for(WebElement sea:searchList){
			DesignationEle.add(sea.getText());
		}
		if(d.findElements(next).size()>0){
			String nextButton = d.findElement(next).getAttribute("class");
			while(!(nextButton.contains("disabled"))){
				wait(1);
				//next.findElement(By.tagName("a")).c
				d.findElement(By.xpath("//ul[@class='pagination']//li[@data-page='next']//a")).click();
				wait(2);
				searchList  = d.findElements(Designation);
				for(WebElement sea:searchList){
					DesignationEle.add(sea.getText());
				}
				 nextButton = d.findElement(next).getAttribute("class");
			}
		}
		else{
			System.out.println("No Next page");
			}
		System.out.println(DesignationEle);
		}
		else{
			System.out.println(d.findElement(Empty).getText());
		}
		d.findElement(search).clear();
		return DesignationEle;
		
			
			}

		
		
		
	}
