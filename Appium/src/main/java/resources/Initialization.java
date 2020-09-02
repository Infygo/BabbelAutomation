package resources;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Initialization {
	public AndroidDriver<AndroidElement> adriver;

	public AndroidDriver<AndroidElement> capabilities() {
		// TODO Auto-generated method stub
		try {
			Properties props = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
			props.load(fis);

			String mobileApk = props.getProperty("mobileApk");
			String emulator = props.getProperty("deviceName");
			String uiAutomator = props.getProperty("automatorName");
			String url = props.getProperty("url");

			File f = new File("src\\main\\java\\resources");
			File fs = new File(f, mobileApk);

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulator);
			cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, uiAutomator);
			adriver = new AndroidDriver<>(new URL(url), cap);
		} catch (Exception e) {
			System.out.println("Cause:" + e.getCause());
			System.out.println("Message:" + e.getMessage());
			e.printStackTrace();
		}
		return adriver;

	}

}
