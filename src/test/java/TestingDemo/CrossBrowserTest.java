package TestingDemo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest {

	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@Test(priority = 1)
	public void verifyTitle() {

		String expectedUrl = driver.getCurrentUrl();
		String actualurl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(expectedUrl, actualurl);

	}

	@Test(priority = 2)
	public void verifyLogo() {
		boolean logo = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		Assert.assertTrue(logo);
	}

	@Test(priority = 3)
	public void verifyProductText() {
		boolean drpEanable = driver.findElement(By.xpath("//span[@class='title']")).isEnabled();
		Assert.assertTrue(drpEanable);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
