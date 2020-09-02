package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignInPage {
	public WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	private By siginHeader = By.xpath("//h1[@class='a-spacing-small']");
	private By email = By.xpath("//input[@id='ap_email']");
	private By continu = By.xpath("//input[@id='continue']");
	private By forgotPassword = By.xpath("//a[@id='auth-fpp-link-bottom']");
	private By iconArrow = By.xpath("//i[@class='a-icon a-icon-expand']");
	private By passWord = By.xpath("//input[@id='ap_password']");
	private By signInSubmit = By.xpath("//input[@id='signInSubmit']");
	private By emailMessage = By.xpath("//span[@class='a-list-item']");
	private By mobileMessage = By.xpath("//h4[@class='a-alert-heading']");

	public WebElement getSignInHeader() {
		return driver.findElement(siginHeader);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getContinue() {
		return driver.findElement(continu);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passWord);
	}
	
	public WebElement getSignInSubmit() {
		return driver.findElement(signInSubmit);
	}
	
	public WebElement getemailMessage() {
		return driver.findElement(emailMessage);
	}
	
	public WebElement getmobileMessage() {
		return driver.findElement(mobileMessage);
	}

	public ForgotPage getForgotPwd() { // page transition to Forgot password page happens here
		//Actions actions = new Actions(driver);
		driver.findElement(iconArrow).click();
		//actions.moveToElement(signInHoverElement).build().perform();
		driver.findElement(forgotPassword).click();
		ForgotPage fp = new ForgotPage(driver);
		return fp;
	}
	
	public ForgotPage forgotPageProcess(WebDriver driver) {
		HomePage hp = new HomePage(driver);

		Actions act = new Actions(driver);
		act.moveToElement(hp.getSiteLanguage()).build().perform();
		hp.getEnglishLanguage().click();

		SignInPage sp_process = hp.getSignIn(driver);
		ForgotPage fp = sp_process.getForgotPwd();
		return fp;

	}

	public WebElement getIconArrow() {  
		return driver.findElement(iconArrow);
	}

}
