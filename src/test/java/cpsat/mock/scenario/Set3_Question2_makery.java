package cpsat.mock.scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set3_Question2_makery extends TestBase {
	
	@BeforeTest
	public void initiatebrowser(){
		init("Chrome", "https://code.makery.ch/library/dart-drag-and-drop/");
	}
	
	@Test
	public void maintest() throws Exception{
		checkPageReady();
		
		//a.	Scroll to view “Custom Drag Avatar” heading
		WebElement dragAvatar = d.findElement(By.xpath("//*[@id='custom-drag-avatar']"));
		scrollIntoView(dragAvatar);
		d.switchTo().frame(1);
		//b.	Drag all the docs to bin and take screenshot before each drag
		List<WebElement> Documents = d.findElements(By.xpath("//a[contains(@href,'example/custom_avatar')]//following-sibling::img"));
		WebElement trash = d.findElement(By.xpath("//a[contains(@href,'example/custom_avatar')]//following-sibling::div"));
		Actions act = new Actions(d);
		for(int i =0; i<Documents.size();i++){
			takeTheScreenShot("cpsatJunitSet3_Question4");
			act.dragAndDrop(Documents.get(i), trash).build().perform();
			wait(3);
			
		}
	}

}
