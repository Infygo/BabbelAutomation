package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage {
	public AndroidDriver<AndroidElement> adriver;

	public LoginPage(AndroidDriver<AndroidElement> adriver) {
		this.adriver = adriver;

	}

	private By email = By.id("com.github.fgoncalves.qa:id/email");
	private By password = By.id("com.github.fgoncalves.qa:id/password");
	private By signIn = By.id("com.github.fgoncalves.qa:id/email_sign_in_button");

	public AndroidElement getEmail() {
		return adriver.findElement(email);
	}

	public AndroidElement getPassword() {
		return adriver.findElement(password);
	}

	public HomePage getSignIn() { // page transition happens here
		adriver.findElement(signIn).click();
		HomePage hp = new HomePage(adriver);
		return hp;

	}

	public HomePage toHomePageProcess(AndroidDriver<AndroidElement> adriver) {
		LoginPage lp = new LoginPage(adriver);
		String validUser1 = "percival@gmail.com";
		String validPwd1 = "123456";
		lp.getEmail().sendKeys(validUser1);
		lp.getPassword().sendKeys(validPwd1);
		HomePage hp_process = lp.getSignIn();
		return hp_process;

	}

}
