package qaautomation.november2021;

import org.testng.annotations.Test;

import qaautomation.november2021.pages.CommonPage;
import qaautomation.november2021.utils.TestUtility;

public class CommonPageTest extends BaseWebTest {
	CommonPage commonPage = new CommonPage(driver, explicitWait);

	@Test
	public void testSwitchingFacebook() {
		commonPage.openNewTab();
		commonPage.switchWindow(1);
		commonPage.openURL("https://facebook.com");

		String scriptJS = "alert('beware of alert!')";

		commonPage.runJavaScriptCommand(scriptJS);
		TestUtility.hardWait(3);
	}

	@Test
	public void testNavigateBrowser() {
		commonPage.openURL("https://facebook.com");
		commonPage.navigateBrowser("back");
		TestUtility.hardWait(3);
		commonPage.navigateBrowser("forward");
		TestUtility.hardWait(3);
		commonPage.navigateBrowser("refresh");
	}
}
