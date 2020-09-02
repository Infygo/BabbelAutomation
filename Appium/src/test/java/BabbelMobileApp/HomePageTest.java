package BabbelMobileApp;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Initialization;

public class HomePageTest extends Initialization {
	public AndroidDriver<AndroidElement> adriver;
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	LoginPage lp;

	/*
	 * Test description - "homePageConfirmationTest" Android Driver navigates to
	 * home page Asserts home page navigation success on visibility of Click Me
	 * element in the Home page
	 */

	@Test
	public void homePageConfirmationTest() {

		adriver = capabilities();
		adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		lp = new LoginPage(adriver);
		HomePage hp = lp.toHomePageProcess(adriver);
		Assert.assertTrue("Checking if Click me element is in Homepage", hp.getHomeClickMe().isDisplayed());
		log.info("Navigation to HomePage successful");
	}

}
