package AppTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.PageBasics;
import Pages.LoginPage;
import Pages.ProductsPage;

public class ProductsPageTest extends PageBasics {
	
	LoginPage login_page_object;
	ProductsPage product_page;
	
	@BeforeClass
	public void invokeBrowse() {

		invokeBrowser();
		login_page_object = openWebPage();
		product_page = login_page_object.doLogin("standard_user", "secret_sauce");
	}
	
	@Test
	public void test_random_product_selection() {
		

		product_page.add_product_to_cart_based_on_index(0);
		Assert.assertEquals(product_page.is_product_carted(0), true);
		
		product_page.add_product_to_cart_based_on_index(2);
		Assert.assertEquals(product_page.is_product_carted(2), true);
		
		product_page.add_product_to_cart_based_on_index(5);		
		Assert.assertEquals(product_page.is_product_carted(5), true);
		
	}
	

	@AfterClass
	public void endOfTest() {
//		closeBrowser();
	}
	
}
