package qaautomation.november2021;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AppTestAssertContains extends BaseWebHeadless {
	By usernamePath = By.id("user-name");
	By passwordPath = By.name("password");
	By loginBtn = By.xpath("//input[@id='login-button']");
	By profileTextPath = By.xpath("//span[@class='title']");

	@Test(testName = "verify login is successful", description = "login will be working just fine")
	public void testDrivenMethod() {
		String username = "standard_user";
		String password = "secret_sauce";

		setText(usernamePath, username);
		setText(passwordPath, password);
		clickAndWaitByXpath(loginBtn);
		String actualText = getText(profileTextPath);

		assertTrue(actualText.toLowerCase().contains("product"));
	}
}
