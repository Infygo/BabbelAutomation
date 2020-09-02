package BabbelMobileApp;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Initialization;

public class LoginPageTest extends Initialization {
	public AndroidDriver<AndroidElement> adriver;
	private static Logger log = LogManager.getLogger(LoginPageTest.class.getName());

	/* 
	 * Test description - "validUserLoginTest"  
	 * Android Driver loads the app and enters the user id and password from the data provider  
	 * Asserts if the login was success based on the Home image display
	 */

	@Test(dataProvider = "getValidUserData")
	public void validUserLoginTest(String validUser, String validPwd, String text) {
		adriver = capabilities();
		adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(adriver);
		lp.getEmail().sendKeys(validUser);
		lp.getPassword().sendKeys(validPwd);
		HomePage hp = lp.getSignIn();
		Assert.assertTrue("Checking if Home image is displayed on Login success", hp.getHomeImage().isDisplayed());
		log.info(text);

	}

	@DataProvider
	public Object[][] getValidUserData() {
		Object[][] data_email = new Object[2][3];
		data_email[0][0] = "Arthur@gmail.com";
		data_email[0][1] = "98765";
		data_email[0][2] = "Arthur-User-Login Successful";

		data_email[1][0] = "percival@gmail.com";
		data_email[1][1] = "123456";
		data_email[1][2] = "Percival-User-Login Successful";
		return data_email;
	}

}
