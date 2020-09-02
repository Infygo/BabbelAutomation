	package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserInitialization {
	public Properties props;
	public WebDriver driver;

	public WebDriver initialiseDriver() throws IOException {
		props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		props.load(fis);

		String browserName = props.getProperty("browser");
		System.out.println("Choosen browser driver:" + browserName);

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\chromedriver.exe");
			ChromeOptions chOptions = new ChromeOptions();
			if (browserName.contains("headless")) {
				chOptions.addArguments("headless");
			}
			driver = new ChromeDriver(chOptions);
		} else if (browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\geckodriver.exe");

		}
		return driver;

	}

}
