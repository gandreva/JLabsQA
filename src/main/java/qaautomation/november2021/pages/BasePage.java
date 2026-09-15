package qaautomation.november2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	public BasePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}
	
	protected final void clickAndWaitByXpath(By locator) {
		WebElement element = explicitWait.get().until(ExpectedConditions.presenceOfElementLocated(locator));
		((JavascriptExecutor) driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			element.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver.get()).executeScript("arguments[0].click();", element);
		}
	}

	protected final void setText(By locator, String text) {
		WebElement element = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}

	public final String getText(By locator) {
		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.get().findElement(locator).getText();
	}
}
