package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By siteLogo = By.xpath("//span[@class='nav-sprite nav-logo-base']"); // logo xpath
	private By siteLanguage = By.xpath("//span[@class='icp-nav-link-inner']"); // site language
	private By englishLanguage = By.xpath("//span[contains(@class,'nav-text')][contains(text(),'English - EN')]");
	private By neurScheinung = By.xpath("//div[@id='nav-main']//a[5]"); // neurscheingung
	private By newReleases = By.xpath("//a[contains(text(),'New Releases')]");
	private By signIn = By.xpath("//span[contains(@class,'nav-action-inner')]"); // sign in actual element
	private By signInHover = By.xpath("//a[@id='nav-link-accountList']"); // sign in hover action

	public WebElement getSiteLogo() {
		return driver.findElement(siteLogo);

	}

	public WebElement getSiteLanguage() {
		return driver.findElement(siteLanguage);
	}

	public WebElement getNeurScheinung() {
		return driver.findElement(neurScheinung);
	}

	public WebElement getNewRelease() {
		return driver.findElement(newReleases);
	}

	public WebElement getEnglishLanguage() {
		return driver.findElement(englishLanguage);
	}

	public SignInPage getSignIn(WebDriver driver) { // page transition happens here
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		WebElement signInHoverElement = driver.findElement(signInHover);
		actions.moveToElement(signInHoverElement).build().perform();
		driver.findElement(signIn).click();
		SignInPage sp = new SignInPage(driver);
		return sp;
	}
	
	
	public SignInPage signInPageProcess(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.moveToElement(getSiteLanguage()).build().perform();
		getEnglishLanguage().click();

		SignInPage sp_process = getSignIn(driver);
		return sp_process;

	}
	

}
