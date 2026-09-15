package qaautomation.november2021;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qaautomation.november2021.pages.LoginPage;
import qaautomation.november2021.pages.ProfilePage;

public class AppTest extends BaseWebTest {
	LoginPage loginPage;
	ProfilePage profilePage;

	@BeforeMethod
	public void setUpPages() {
		loginPage = new LoginPage(driver, explicitWait);
		profilePage = new ProfilePage(driver, explicitWait);
	}

	@Test(testName = "verify login is successful", description = "login will be working just fine")
	public void test1() {
		String username = "standard_user";
		String password = "secret_sauce";

		loginPage.login(username, password);
		String actualString = profilePage.getProfileText(username);
		assertEquals(actualString.toLowerCase(), "products");
	}
}
