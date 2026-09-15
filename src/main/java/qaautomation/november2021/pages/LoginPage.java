package qaautomation.november2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	By usernameInput = By.xpath("//input[@id='user-name']");
	By passwordInput = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='login-button']");
	
	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void login(String username, String password) {
		setText(usernameInput, username);
		setText(passwordInput, password);
		clickAndWaitByXpath(loginBtn);
	}
}
