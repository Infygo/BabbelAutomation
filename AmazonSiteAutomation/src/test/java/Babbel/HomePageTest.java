package Babbel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import Resources.BrowserInitialization;

public class HomePageTest extends BrowserInitialization {
	/* 
	 * Test description - "changeLanguage"  
	 * Driver navigates to home page changes the site language from German to English 
	 * Asserts if the translation has worked fine with an element translation text 
	 */
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest
	public void driverSetUp() throws IOException {
		driver = initialiseDriver();
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void changeLanguage() throws IOException {

		HomePage hp = new HomePage(driver);
		Actions act = new Actions(driver);
		String newrelease = "New Releases";
		Assert.assertTrue("Checking DE Version", hp.getNeurScheinung().isEnabled());

		act.moveToElement(hp.getSiteLanguage()).build().perform();
		hp.getEnglishLanguage().click();
		Assert.assertEquals("Checking English translated version of Site", newrelease, hp.getNewRelease().getText());
		log.info("Home page translated to English");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
