package qaautomation.november2021;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import qaautomation.november2021.pages.LoginPage;
import qaautomation.november2021.pages.ProfilePage;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseWebTest {
	/**
	 * Rigorous Test :-)
	 */
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);

	@Test(testName = "verify login is successful", description = "login will be working just fine")

	public void test1() {
		String username = "fullstackdemo";
		String password = "fullstackdemo";

		loginPage.login(username, password);
		String actualString = profilePage.getProfileText(username);
		assertEquals(actualString, username);

	}

}
