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
import pageObjects.WelcomePage;
import resources.Initialization;

public class WelcomePageTest extends Initialization {
	public AndroidDriver<AndroidElement> adriver;
	private static Logger log = LogManager.getLogger(WelcomePageTest.class.getName());
	HomePage hp;
	LoginPage lp;

	/*
	 * This test validates Welcome toast message on Welcome page 
	 * that is visible on clicking the button Click Me 
	 */

	@Test
	public void welcomePageConfirmation() {
		adriver = capabilities();
		adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp = new LoginPage(adriver);
		hp = lp.toHomePageProcess(adriver);
		WelcomePage wp = hp.homeClickMeWelcome();
		String toastMessage = "Capture me while you can!";
		wp.getWelClickMe().click();
		Assert.assertEquals(wp.getToastMessage().getAttribute("name"), toastMessage);
		log.info("Message captured");

	}

}
