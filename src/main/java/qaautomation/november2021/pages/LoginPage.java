package qaautomation.november2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	By loginLink = By.xpath("//a[normalize-space()='Log In/Register As Student']");
	By usernamePath = By.id("username");
	By passwordPath = By.name("password");
	By loginBtn = By.xpath("//button[normalize-space()='Login']");

	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void login(String username, String password) {
		clickAndWaitByXpath(loginLink);
		setText(usernamePath, username);
		setText(passwordPath, password);
		clickAndWaitByXpath(loginBtn);
	}

}
