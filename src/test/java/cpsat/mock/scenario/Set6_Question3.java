package cpsat.mock.scenario;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.pageobjects.Set6_Question3_Maps;
import com.testing.base.TestBase;

public class Set6_Question3 extends TestBase {

	
	
	@Before
	public void initate(){
		init("Chrome", "http://maps.google.com");
	}
	
	@Test
	public void maintest() throws InterruptedException  {
		Set6_Question3_Maps map = new Set6_Question3_Maps(d);
	    checkPageReady();
	  //  d.findElement(map.search()).sendKeys("Madura Nagar, Tirupati, Andhra Pradesh");
		map.search.sendKeys("Madura Nagar, Tirupati, Andhra Pradesh");
		map.searchButton.click();
	}
}
