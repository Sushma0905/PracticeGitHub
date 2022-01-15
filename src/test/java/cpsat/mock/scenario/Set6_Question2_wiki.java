package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pageobjects.Set6_Question2_Wiki;
import com.testing.base.TestBase;

public class Set6_Question2_wiki extends TestBase{
	
	@Before
	public void init(){
		init("Chrome","https://www.wikipedia.org/");
	}
	
	@Test
	public void maintest() throws Exception{
		Set6_Question2_Wiki qu = new Set6_Question2_Wiki(d);
		
		checkPageReady();
		//Display on console the number of articles in English and click on “English” link 
		String articles = d.findElement(By.xpath(qu.articlesCount)).getText();
		System.out.println("Article count :" +articles);
		d.findElement(By.xpath(qu.englishLink)).click();
		//Search for Anna University. 
		checkPageReady();
		d.findElement(By.xpath(qu.search)).sendKeys("Anna University");
		wait(2);
		waitForElementToClickable(d.findElement(By.xpath(qu.searchButton)));
		d.findElement(By.xpath(qu.searchButton)).click();
		//Print the 'Motto in English' part in the console and ensure it has the word 'Knowledge' in it
		String Motto = d.findElement(qu.Motto()).getText();
		if(Motto.contains("Knowledge")){
			System.out.println(Motto + " contains Knowledge");
		}
		else{
			System.out.println(Motto + " does not contains Knowledge");
		}
		
		List<WebElement> alumini = d.findElements(By.xpath("//table[contains(@class,'box-Alumni')]//following-sibling::ul/li/a[1]"));
		for(WebElement s : alumini){
			System.out.println(s.getText());
			if(s.getText().contains("Shiv Nadar")){
				System.out.println("Shiv Nadar is in the list");
			}
		}
		
	}
	
	@After
	public void close(){
		terminate();
	}

}
