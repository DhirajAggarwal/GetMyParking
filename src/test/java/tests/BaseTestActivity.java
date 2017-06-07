package tests;

import pagefactory.DataElements;
import screens.HomePage;
import screens.Login;
import utils.AppFactory;
import utils.Helper;

/**
 * @author dhiraj.aggarwal
 *
 */
public abstract class BaseTestActivity extends AppFactory implements DataElements {

	Helper helper = new Helper();
	Login login = new Login();
	HomePage homePage = new HomePage();
}
