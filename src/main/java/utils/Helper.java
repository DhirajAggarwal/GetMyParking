package utils;

import static utils.AppFactory.driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author dhiraj.aggarwal
 *
 */
public class Helper {

	/*
	 * Locator Method
	 */
	public By loc(String locate, String element) {
		switch (locate.toLowerCase()) {
		case "class":
			return By.className(element);
		case "css":
			return By.cssSelector(element);
		case "name":
			return By.name(element);
		case "id":
			return By.id(element);
		case "linktext":
			return By.linkText(element);
		case "partiallinktext":
			return By.partialLinkText(element);
		case "xpath":
			return By.xpath(element);
		case "tagname":
			return By.tagName(element);
		default:
			return null;
		}
	}

	/*
	 * Find Element by List
	 */
	public List<MobileElement> findMobileListElements(String locate, String element) {
		waitForElement(locate, element);
		return driver.findElements(loc(locate, element));
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateBack(int count) {
		for (int i = 0; i <= count; i++) {
			driver.navigate().back();
		}
	}

	/*
	 * Find Element
	 */
	public MobileElement findMobileElement(String locate, String element) {
		waitForElement(locate, element);
		return driver.findElement(loc(locate, element));
	}

	/*
	 * Scroll Up/Down to the text that needs to be clicked
	 */
	@SuppressWarnings("deprecation")
	public WebElement scrolTo(String elementText) {
		return driver.scrollTo(elementText);
	}

	/*
	 * Wait Method: Works on visibility of Element; Returns time to find each
	 * Element; Default TimeOut=15 Secs
	 */
	public void waitForElement(String locate, String element) {
		String msg;
		long time = System.currentTimeMillis();
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
					.pollingEvery(500, TimeUnit.MILLISECONDS);
			wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfElementLocated(loc(locate, element))));
			msg = "Time taken to find out the element \"" + element + "\" is "
					+ ((System.currentTimeMillis() - time) / 1000) + " seconds.";
			System.out.println(msg);
		} catch (NoSuchElementException | TimeoutException | UnhandledAlertException e1) {
			System.out.println("Ohh! " + element + " couldn't be found. The Timeout happened in "
					+ ((System.currentTimeMillis() - time) / 1000) + " seconds.");
		}
	}

	/*
	 * Method that returns if an Element is Present in DOM or Not
	 */
	public Boolean isElementPresent(String locator, String element) {
		try {
			findMobileElement(locator, element).isDisplayed();
			System.out.println("Hurray! Element \"" + element + "\" is present");
			return true;
		} catch (Exception e) {
			System.out.println("Alaas! Element \"" + element + "\" was not there");
			return false;
		}
	}

	public String getCurrentActivity() {
		return ((AndroidDriver<MobileElement>) driver).currentActivity();
	}

	public int screenHight() {
		return driver.manage().window().getSize().getHeight();
	}

	public int screenWidth() {
		return driver.manage().window().getSize().getWidth();
	}

	public void swipeVertical() {
		driver.swipe(0, 0, 0, screenHight(), 1);
	}

	public void swipeHorizontal() {
		driver.swipe(0, 0, screenWidth(), 0, 1);
	}

	public void selectDropDown(int index) {
		Select selectByIndex = new Select((WebElement) driver);
		selectByIndex.selectByIndex(index);
	}

	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}
}
