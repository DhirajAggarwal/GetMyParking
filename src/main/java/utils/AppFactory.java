package utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import pagefactory.Config;

/**
 * @author dhiraj.aggarwal
 *
 */
public class AppFactory implements Config {
	public static AppiumDriver<MobileElement> driver;
	DesiredCapabilities desiredCaps = new DesiredCapabilities();
	File apk = new File("gmp.apk");

	@BeforeSuite
	public AppiumDriver<MobileElement> init() throws MalformedURLException {
		//desiredCaps.setCapability(MobileCapabilityType.APP, apk);
		desiredCaps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, app_Package);
		desiredCaps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, app_Activity);
		desiredCaps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, wait_Activity);
		desiredCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation_Name);
		desiredCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_Name);
		desiredCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_Version);
		desiredCaps.setCapability(MobileCapabilityType.DEVICE_NAME, device_Name);
		desiredCaps.setCapability("no-reset", "true");
		desiredCaps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, "true");
		desiredCaps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, "true");

		driver = new AndroidDriver<MobileElement>(new URL(URL), desiredCaps);
		return driver;
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}
}
