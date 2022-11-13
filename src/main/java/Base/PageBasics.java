package Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import Pages.LoginPage;
import Utils.DriverSetUp;
import Utils.PropertiesFile;




public class PageBasics {
	public static WebDriver driver = null;
	public static WebDriverWait wait;
	public static Properties prop = null;
	
	public void invokeBrowser() {
		prop = PropertiesFile.readFile();
		driver = DriverSetUp.getWebDriver(prop.getProperty("browser"));
		wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		
	}
	
	public boolean is_page_load_completed() {
		try {
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete'"));
			return true;
		}
		catch (WebDriverException e) {
			return false;
		}

	}
	
	public LoginPage openWebPage() {
		
		driver.get(prop.getProperty("url"));
		this.is_page_load_completed();
		return PageFactory.initElements(driver,LoginPage.class);
		
	}
	
	public boolean verifyTitle(String expectedTitle) {
		boolean status;
		try {
			
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		status=true;
		}
		catch(Exception e){
			status = false;
		}
		return status;
	}
	
	
	public void enterText(WebElement web_element, String text) {
		wait.until(ExpectedConditions.visibilityOf(web_element));
		web_element.sendKeys(text);
	}
	
	public void clickButton(WebElement web_element) {
		wait.until(ExpectedConditions.elementToBeClickable(web_element));
		web_element.click();
		is_page_load_completed();
	}
	
	
	public String get_element_text(WebElement web_element) {
		return web_element.getText();
	}
	
	protected void closeBrowser() {
		driver.close();
		driver.quit();
	}
		
	
}
