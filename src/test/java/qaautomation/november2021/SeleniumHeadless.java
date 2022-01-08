package qaautomation.november2021;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumHeadless {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-error",
				"--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		driver.get("https://testautomasi.com");
		driver.manage().window().maximize();
	}

	@Test
	public void testHeadless() {
		String username = "fullstackdemo";
		String password = "fullstackdemo";

		driver.findElement(By.xpath("//a[normalize-space()='Log In/Register As Student']")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		String actualText = driver.findElement(By.xpath("//strong[normalize-space()='fullstackdemo']")).getText();
		assertEquals(actualText, username);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}