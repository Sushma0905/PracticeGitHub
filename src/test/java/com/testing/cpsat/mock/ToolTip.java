package com.testing.cpsat.mock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class ToolTip extends TestBase{
	
	@BeforeTest
	public void setUp() {
		init("Chrome","https://www.demoqa.com/tool-tips/");
	}

	@Test
	public void takeScreenShotToolTip() throws Exception {
		
		checkPageReady();
		WebElement toolTipButton=d.findElement(By.id("toolTipButton"));
		WebElement toolTipBox=d.findElement(By.id("toolTipTextField"));

		Actions action=new Actions(d);
		action.moveToElement(toolTipButton).build().perform();
		wait(2);		
		takeScreenShotTip("ToolTip","toolTipButton");
		
		action.moveToElement(toolTipBox).build().perform();
		wait(2);		
		takeScreenShotTip("ToolTip","toolTipsearchBox");

	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
