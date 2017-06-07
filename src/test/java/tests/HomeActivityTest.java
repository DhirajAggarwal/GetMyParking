package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author dhiraj.aggarwal
 *
 */
public class HomeActivityTest extends BaseTestActivity {

	@Test
	public void verifyParkingSearched() {
		Assert.assertTrue(homePage.searchParkingPlace().contains(parkingLocation));
	}
}
