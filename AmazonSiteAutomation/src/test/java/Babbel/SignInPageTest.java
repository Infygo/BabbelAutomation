package Babbel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SignInPage;
import Resources.BrowserInitialization;

public class SignInPageTest extends BrowserInitialization {
	public WebDriver driver;
	HomePage hp;
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	/* 
	 * Test description - "signInWithEmail"  
	 * Driver navigates to sign page and checks for login 
	 * with the users given in the data provider
	 * Asserts on the login failed message  
	 */

	@Test(dataProvider = "getEmailData")
	public void signInWithEmail(String email, String password, String text) throws IOException {

		driver = initialiseDriver();
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		hp = new HomePage(driver);
		SignInPage sp_Email = hp.signInPageProcess(driver);
		sp_Email.getEmail().sendKeys(email);
		sp_Email.getContinue().click();
		sp_Email.getPassword().sendKeys(password);
		sp_Email.getSignInSubmit().click();
		Assert.assertTrue(sp_Email.getemailMessage().isDisplayed());
		log.info(text);
		driver.close();

	}

	@DataProvider
	public Object[][] getEmailData() {
		Object[][] data_email = new Object[2][3];
		data_email[0][0] = "xyz@gmail.com";
		data_email[0][1] = "xyz";
		data_email[0][2] = "Test data emailid 1 ";

		data_email[1][0] = "ABC@gmail.com";
		data_email[1][1] = "999";
		data_email[1][2] = "Test data emailid 2";
		return data_email;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
