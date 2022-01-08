package qaautomation.november2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

	String profileTextPath = "//strong[normalize-space()='%s']";

	public ProfilePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public String getProfileText(String username) {
		By profileTextXpath = By.xpath(String.format(profileTextPath, username));
		return getText(profileTextXpath);
	}
}
