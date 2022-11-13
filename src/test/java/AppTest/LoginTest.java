package AppTest;


import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.PageBasics;
import Pages.LoginPage;
import Pages.ProductsPage;


public class LoginTest extends PageBasics{
	
	LoginPage login_page_object;
	ProductsPage product_page;
	
	@BeforeClass
	public void invokeBrowse() {

		invokeBrowser();
		login_page_object = openWebPage();
	}
	
	@Test
	public void testLogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter username: ");
		String username = sc.next();
		
		System.out.println("Please enter password: ");
		String password = sc.next();
		
		product_page = login_page_object.doLogin(username, password);
		Assert.assertEquals(product_page.get_product_navbar_title(), "PRODUCTS");
	}
	

	@AfterClass
	public void endOfTest() {
//		closeBrowser();
	}
}
