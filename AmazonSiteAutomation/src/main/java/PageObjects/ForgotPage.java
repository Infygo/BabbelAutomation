package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPage {
	public WebDriver driver;
	public ForgotPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By pwdAssitance = By.xpath("//h1[contains(text(),'Password assistance')]");
	private By emailMobile = By.xpath("//input[@id='ap_email']");
	private By continuPwdAssitance = By.xpath("//input[@id='continue']");
	private By alertMessage = By.xpath("//p[contains(text(),'identify you')]");
	private By alertHeader = By.xpath("//h4[@class='a-alert-heading']");
	
	public WebElement getPwdAssitance() {
		return driver.findElement(pwdAssitance);
	}
	
	public WebElement getEmailMobile(){
		return driver.findElement(emailMobile);
	}
	
	public WebElement getContinuPwdAssitance() {
		return driver.findElement(continuPwdAssitance);
	}
	
	public WebElement getAlertMessage() {
		return driver.findElement(alertMessage);
	}
	
	public WebElement getAlertHeader() {
		return driver.findElement(alertHeader);
	}

}
