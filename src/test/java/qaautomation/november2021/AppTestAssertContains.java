package qaautomation.november2021;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTestAssertContains extends BaseWebHeadless {
	// TDD
	By loginLink = By.xpath("//a[normalize-space()='Log In/Register As Student']");
	By usernamePath = By.id("username");
	By passwordPath = By.name("password");
	By loginBtn = By.xpath("//button[normalize-space()='Login']");
	By profileTextPath = By.xpath("//p[contains(text(),'Hello')]");

	@Test(testName = "verify login is successful", description = "login will be working just fine")
	public void testDrivenMethod() {
		String username = "fullstackdemo";
		String password = "fullstackdemo";

		clickAndWaitByXpath(loginLink);
		setText(usernamePath, username);
		setText(passwordPath, password);
		clickAndWaitByXpath(loginBtn);
		String actualText = getText(profileTextPath);

		System.out.println(actualText);
		System.out.println(username);
		assertTrue(actualText.contains(username));
	}

}
