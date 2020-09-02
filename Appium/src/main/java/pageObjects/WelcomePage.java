package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WelcomePage {
	public AndroidDriver<AndroidElement> adriver;

	public WelcomePage(AndroidDriver<AndroidElement> adriver) {
		this.adriver = adriver;

	}
	
    private By welcome = By.id("com.github.fgoncalves.qa:id/randomTextView");
    private By wel_ClickMe = By.id("com.github.fgoncalves.qa:id/clickMeBtn");
    private By toastMessage = By.xpath("//android.widget.Toast[1]");
    
    public AndroidElement getWelcome() {
    	return adriver.findElement(welcome);
    }
    
    public AndroidElement getWelClickMe() {
    	return adriver.findElement(wel_ClickMe);
    }
    
    public AndroidElement getToastMessage() {
    	return adriver.findElement(toastMessage);
    }

}
