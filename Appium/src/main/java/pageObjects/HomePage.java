package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage {
	
	public AndroidDriver<AndroidElement> adriver;

	public HomePage(AndroidDriver<AndroidElement> adriver) {
		this.adriver = adriver;

	}
	
	private By hp_ClickMe = By.xpath("//android.widget.Button");
	private By hp_HomeImage = By.xpath("//android.widget.ImageView");
	
	public AndroidElement getHomeImage() {
		return adriver.findElement(hp_HomeImage);
	}
	
	public AndroidElement getHomeClickMe() {
		return adriver.findElement(hp_ClickMe);
	}
	
	public  WelcomePage homeClickMeWelcome() { // page transition happens here
		adriver.findElement(hp_ClickMe).click();
		WelcomePage wp = new WelcomePage(adriver);
		return wp;
	}

}
