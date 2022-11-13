package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBasics;


public class LoginPage extends PageBasics {
	
	WebDriverWait wait;
	
	@FindBy(id="user-name")
	WebElement usernamefield;
	
	@FindBy(id="password")
	WebElement passwordfield;
	
	@FindBy(id="login-button")
	WebElement login_button;
	
	
	
	public ProductsPage doLogin(String username, String password ) {
		
		enterText(usernamefield, username);
		enterText(passwordfield, password);
		clickButton(login_button);
		return PageFactory.initElements(driver,ProductsPage.class); 
	}
	
}
	

