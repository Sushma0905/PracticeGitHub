package cpsat.mock.scenario;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pageobjects.Set7_Question2_imdb_pf;
import com.testing.base.TestBase;

public class Set7_Question2_imdb extends TestBase{

	
	@Before
	public void initiate(){
		init("Chrome", "https://www.imdb.com/");
	}
	
	@Test
	public void maintest() throws Exception{
		Set7_Question2_imdb_pf pf = new Set7_Question2_imdb_pf(d);
		checkPageReady();
		d.findElement(By.xpath("//input[contains(@placeholder,'Search IMDb')]")).sendKeys("Gangs of New York");
		d.findElement(By.xpath(pf.searchButton)).click();
		d.findElement(By.xpath(pf.gangResult)).click();
		checkPageReady();
		//Verify that the movie’s run time is less than 180 min
		WebElement movieTime = d.findElement(By.xpath("(//ul[contains(@class,'TitleBlockMetaData__MetaDataList')]/li)[3]"));
		System.out.println("Movie Time :" +movieTime.getText());
		String Time = movieTime.getText();
		String[] sp =Time.split(" ");
		String[]  hours =sp[0].split("h");
		int ActualHours = Integer.parseInt(hours[0]);
		int Minutes = ActualHours*60;
		System.out.println(Minutes);
		String[]  min =sp[1].split("min");
		int ActualMins = Integer.parseInt(min[0]);
		int ExpectedMinutes = Minutes+ActualMins;
		System.out.println("Actual movie time :" +ExpectedMinutes);
		if(ExpectedMinutes>180){
			System.out.println("Movie time is more than 180 minutes");
		}
		else
			System.out.println("Movie time is less than 180 minutes");
		//Verify that the movie’s genre contains “Crime” (2 points)
		String Genre = d.findElement(By.xpath(pf.genre)).getText();
		if(Genre.contains("Crime")){
			System.out.println("the Genre of the film is :" +Genre);
		}
		else{
			System.out.println("the Genre of the film is not crime but :" +Genre);
		}
		
		//Verify that the MPAA rating of the movie is “R” (2 points)
		
		String MPAARating = d.findElement(By.xpath(pf.mpaaRating)).getText();
		if(MPAARating.contains("R")){
			System.out.println("Movie MPAA rating is R " );
		}
		else
			System.out.println("Movie MPAA Rating is not R");
		
		//Go to the User Reviews section of the movie and display the name of the Reviewer on the Eclipse console 
		
		d.findElement(By.xpath(pf.UserReviewsLink)).click();
		checkPageReady();
		List<WebElement> Usernames = d.findElements(By.xpath(pf.userNames));
		
		for(WebElement User: Usernames){
			System.out.println("List of top user names :" +User.getText());
		}
		
		
}}
