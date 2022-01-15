package cpsat.mock.scenario;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set4_Question6_MomentoFilm extends TestBase{
	
	@Before
	public void initiatebrowser(){
		init("Chrome", "https://en.wikipedia.org/wiki/Main_Page");
	}

	@Test
	public void maintest() throws Exception{
		checkPageReady();
		//Search for the film “Memento (film)”.
		d.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Memento (film)");
		d.findElement(By.xpath("//input[@id='searchButton']")).click();
		/*wait(2);
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//div[text()='Memento (film)']"))).click().build().perform();
*/		//d.findElement(By.xpath("//input[@id='searchInput']")).sendKeys(Keys.ENTER);
		wait(3);
		
		//Verify the runtime is 113 minutes in terms of hh:MM.
		String Time = d.findElement(By.xpath("(//div[text()='Running time']//following::td)[1]")).getText();
		System.out.println(Time);
		String[] sp = Time.split(" ");
		
		
		int Minutes = Integer.parseInt(sp[0]);
		int ActualHours = Minutes/60;
		System.out.println(ActualHours);
		int ActualMinutes = Minutes%60;
		System.out.println(ActualMinutes);
		if(ActualHours ==1 && ActualMinutes == 53){
			Assert.assertTrue(true);
			System.out.println("The running time is 113 as expected");
		}
		else{
			Assert.assertTrue(false);
			System.out.println("The running time is not as expected");
		}
		
		//Verify the director is Christopher Nolan.
		
		String director = d.findElement(By.xpath("(//th[text()='Directed by']//following::td)[1]")).getText();
		
		if(director.equals("Christopher Nolan")){
			Assert.assertTrue(true);
			System.out.println("Director of the film is :" +director);
		}
		else{
			System.out.println("Director of the film is not :" +director);
			Assert.assertTrue(false);
		}
		
		//Verify the box office collection is $39.7 million.
		String Boxoffice = d.findElement(By.xpath("(//th[text()='Box office']//following::td)[1]")).getText();
		if(Boxoffice.contains("$39.7 million")){
			System.out.println("Box office collection is equal to :" +Boxoffice);
		}
		else{
			System.out.println("Actual box office collection is :" +Boxoffice);
		}
		//Print the cast.
		List<WebElement> cast = d.findElements(By.xpath("//span[text()='Cast']//parent::h2//following-sibling::div/ul/li"));
		for(WebElement ca : cast){
			System.out.println("Cast People:" +ca.getText());
		}
	
	}
	
	@After
	public void closeBrowser(){
		terminate();
	}
}
