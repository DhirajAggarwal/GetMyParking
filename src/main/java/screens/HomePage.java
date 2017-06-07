package screens;

public class HomePage extends BaseActivity {

	public String searchParkingPlace() {
		if(isElementPresent("id", allowDeviceLocation))
			findMobileElement("id", allowDeviceLocation).click();
		String currentLocation = findMobileElement("id", titleSearchedTextId).getText();
		return currentLocation;
	}

}
