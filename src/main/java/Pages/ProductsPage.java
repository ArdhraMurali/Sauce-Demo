package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBasics;

public class ProductsPage extends PageBasics {
	
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	WebElement products_page_navabr_value;
	
	@FindBy(xpath="//div[@class='inventory_list']")
	WebElement products_list;
	
	
	public String get_product_navbar_title() {
		return get_element_text(products_page_navabr_value);
	}
	
	public List<WebElement> get_products_list(){
		return  driver.findElements( By.xpath("//div[@class='inventory_list']/div"));	
	}
	
	public boolean get_product_based_on_name(String product_name) {
		this.get_products_list();
		return true;
	}
	
	protected WebElement get_product_based_on_index(int product_index) {
		List<WebElement> products = this.get_products_list();
		return products.get(product_index);
	}
	
	public WebElement get_product_cart_button(WebElement product) {
		List<WebElement> wrapper1 = product.findElements(By.xpath("div"));
		
		WebElement wrapper1_2 = wrapper1.get(1);
		
		List<WebElement> price = wrapper1_2.findElements(By.xpath("div"));
		
		WebElement price_bar = price.get(1);
		
		return price_bar.findElement(By.xpath("button"));
	}
	
	public void add_product_to_cart_based_on_index(int product_index) {
		WebElement product = get_product_based_on_index(product_index);
		
		WebElement add_to_cart_button = get_product_cart_button(product);
		
		clickButton(add_to_cart_button);
	}
	
	public boolean is_product_carted(int product_index) {
		WebElement product = get_product_based_on_index(product_index);
		
		WebElement add_to_cart_button = get_product_cart_button(product);

		return get_element_text(add_to_cart_button).equalsIgnoreCase("REMOVE");
	}
}
