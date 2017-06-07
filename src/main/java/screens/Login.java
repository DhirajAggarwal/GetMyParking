package screens;

/**
 * @author dhiraj.aggarwal
 *
 */
public class Login extends BaseActivity {

	public String signUp(String emailId, String password, String confirmpassword) {
		findMobileListElements("id", signUpListId).get(1).click();
		findMobileElement("id", signUpEmailId).sendKeys(emailId);
		findMobileElement("id", signUpPasswordId).sendKeys(password);
		findMobileElement("id", signUpConfirmPasswordId).sendKeys(confirmpassword);
		findMobileElement("id", signUpButtonId).click();
		return getCurrentActivity();
	}

	public String signIn(String emailId, String password) {
		findMobileListElements("id", signInListId).get(0).click();
		findMobileElement("id", signInEmailId).sendKeys(emailId);
		findMobileElement("id", signInPasswordId).sendKeys(password);
		findMobileElement("id", signInButtonId).click();
		if(isElementPresent("id", allowDeviceLocation))
			findMobileElement("id", allowDeviceLocation).click();
		System.out.println(getCurrentActivity());
		return getCurrentActivity();
	}

	public String signInSignUpCheck(String emailId, String password, String confirmpassword) {
		if (isElementPresent("id", signInEmailId)) {
			String currentActivity = getCurrentActivity();
			System.out.println(currentActivity);
			if (currentActivity.equals(signIn(emailId, password)))//.ui.activities.LoginActivity
				return signUp(emailId, password, confirmpassword);
			return currentActivity;
		}
		return "False";
	}
}
