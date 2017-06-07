package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestActivity {

	@Test
	@Parameters({"userNameData","passwordData"})
	public void login(String userNameData, String passwordData ) {
		String currentActivity = helper.getCurrentActivity();
		String resultLogIn = login.signInSignUpCheck(userNameData, passwordData, passwordData);
		if (resultLogIn != "False")
			Assert.assertEquals(currentActivity, resultLogIn);
		else
			Assert.assertTrue(true);
	}
}
