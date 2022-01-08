package qaautomation.november2021;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebHeadless {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

	@BeforeMethod
	public void createDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-error",
				"--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
		driver.set(new ChromeDriver(options));
		driver.get().get("https://testautomasi.com");
		driver.get().manage().window().maximize();
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
	}

	protected final boolean elementIsDisplayedByXpath(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).isDisplayed();
	}

	protected final void clickAndWaitByXpath(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).click();
	}

	protected final void setText(By locator, String text) {
		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.get().findElement(locator).sendKeys(text);
	}

	protected final String getText(By locator) {
		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.get().findElement(locator).getText();
	}

	@AfterMethod
	public void quitDriver() {
		driver.get().quit();
	}
}
