package AppTest;



import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
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
		
		List<WebElement> products = product_page.get_products_list();
		
		
		for(int i=0;i<3;i++) {
			
			Random ran = new Random();
			int random_product_index = ran.nextInt(products.size());
			product_page.add_product_to_cart_based_on_index(random_product_index);
			Assert.assertEquals(product_page.is_product_carted(random_product_index), true);

		}
		
		
		
		
	}
	

	@AfterClass
	public void endOfTest() {
//		closeBrowser();
	}
	
}