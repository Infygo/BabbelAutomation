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

import PageObjects.ForgotPage;
import PageObjects.HomePage;
import PageObjects.SignInPage;
import Resources.BrowserInitialization;

public class ForgotPageTest extends BrowserInitialization {
	public WebDriver driver;
	SignInPage sp;
	HomePage hp;
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	/* 
	 * Test description - "getEmailMobileAssitance"  
	 * Driver navigates to Forgot password page 
	 * Enters the email from data provider for the forgot password recovery  
	 * Asserts if the email was valid for the password to be reset 
	 */

	@Test(dataProvider = "getEmailMobileData")
	public void emailMobileAssistance(String emailMobile, String text) throws IOException {
		driver = initialiseDriver();
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sp = new SignInPage(driver);
		ForgotPage fpage_email = sp.forgotPageProcess(driver);
		fpage_email.getEmailMobile().sendKeys(emailMobile);
		fpage_email.getContinuPwdAssitance().click();
		Assert.assertTrue(fpage_email.getAlertMessage().isDisplayed());
		log.info(text);
	}

	@DataProvider
	public Object[][] getEmailMobileData() {
		Object[][] data_email = new Object[1][2];
		data_email[0][0] = "abc@gmail.com";
		data_email[0][1] = "Emailid Assistance ";

		return data_email;
	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}

}
