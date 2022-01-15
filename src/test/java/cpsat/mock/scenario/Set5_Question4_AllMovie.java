package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set5_Question4_AllMovie extends TestBase{

	
	@Before
	public void Initiatebrow(){
		init("Chrome", "http://www.allmovie.com/");
	}
	
	@Test
	public void maintest() throws InterruptedException{
		checkPageReady();
		d.findElement(By.xpath("//input[@type='search']")).sendKeys("The Godfather");
		//a.	Print number of search results items found in eclipse console 
		d.findElement(By.xpath("//input[@type='submit']")).click();
		checkPageReady();
		List<WebElement> searchResults = d.findElements(By.xpath("//ul[contains(@class,'search-results')]//li[@class='movie']"));
		System.out.println(searchResults.size());
		
		for(int i =1; i<searchResults.size();i++){
			WebElement Element = d.findElement(By.xpath("(//ul[contains(@class,'search-results')]//li[@class='movie']//h4[text()='Movie']//following-sibling::div)["+i+"]"));
			String text = Element.getText();
			if(text.contains("1972")){
				Element.click();
				checkPageReady();
				System.out.println(d.getCurrentUrl());
				break;
			}
		}
			//c.	Verify that the movie’s genre is “Crime” and MPAA rating is “A”. 
			WebElement genre = d.findElement(By.xpath("//span[contains(@class,'header-movie-genres')]//child::a"));
			if(genre.getText().equals("Crime")){
				System.out.println("Movie genre is " +genre.getText());
			}
			else {
				System.out.println("Movie genre is not crime but " +genre.getText());
			}
			
			WebElement rating = d.findElement(By.xpath("//span[contains(text(),'MPAA Rating')]//child::span"));
			if(rating.getText().equals("A")){
				System.out.println("MPAA rating of the movie is " +rating.getText());
			}
			else{
				System.out.println("MPAA rating of the movie is not 'A' but  " +rating.getText());
			}
			WebElement castCrew = d.findElement(By.xpath("//li[contains(@class,'tab cast-crew')]"));
			castCrew.click();
			
			//d.	Verify on Cast & Crew page that the movie’s director’s name is “Francis Ford Coppola” 
			 WebElement director = d.findElement(By.xpath("//h2[contains(text(),'Director')]//following::dt//a[1]"));
			 if(director.getText().equals("Francis Ford Coppola")){
				 System.out.println("Director of the movies is " +director.getText());
			 }
			 else{
				 System.out.println("Director of the movies is not as expected but " +director.getText()); 
			 }
			 //e.	Verify on Cast & Crew page that the Al Pacino’s character’s name is Michael Corleone 
			 WebElement cast = d.findElement(By.xpath("(//a[contains(text(),'Al Pacino')]//following::div)[1]"));
			 if(cast.getText().equals("Michael Corleone")){
				 System.out.println("Al Pacino’s character’s name is " +cast.getText());
			 }
			 else{
				 System.out.println("Al Pacino’s character’s name is not as expected but " +cast.getText());
			 }
			
		}
	@After
	public void cl(){
		terminate();
	}
	}

