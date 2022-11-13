package Utils;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DriverSetUp {
	
	public static WebDriver getWebDriver(String browser) {
		
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions(); //To disable notifications
			options.addArguments("--disable-notifications");
		
			options.addArguments("-incognito");			
			
			driver = new ChromeDriver(options);
		} else {
			Assert.fail("Unable to detect the browser");
		}
		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		try {
		driver.close();
		driver.quit();
		}
		catch(NoSuchSessionException e) {
			System.out.println("unable to Close the Session"+ e.getMessage());
		}
		
	}
}

