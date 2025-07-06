package Order.stepdefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Order.TestComponents.BaseTest;
import Order.pageObjects.CartPage;
import Order.pageObjects.LandingPage;
import Order.pageObjects.PaymentPage;
import Order.pageObjects.ProductCatlogPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinationstest extends BaseTest 
{
	public LandingPage landingpage;
	public ProductCatlogPage productcatlog;
	public CartPage cartpage;
	public PaymentPage paymentpage;
	@Given("Login to the Application")
	public void Login_to_the_Application() throws IOException 
	{
		landingpage=InitinilizeDriver();
	}
	@Given("^Login with the valid email(.+) and password (.+)$")
	public void Login_with_valid_Email_and_Passowrd(String email,String password)
	{
		 productcatlog=landingpage.LoginInfo(email,password);
	}
	@When("^I add the product to the cart (.+)$")
	public void I_added_the_Product_to_the_cart(String item) throws InterruptedException
	{
		List<WebElement> products=productcatlog.GetProducts();
		 cartpage=productcatlog.AddProductTOCart(item);
	}
	@And("^Checkout the item (.+) and submit the order$")
	public void Checkout_the_item_and_submit_the_orders(String item)
	{
		boolean match=cartpage.CartProducts(item);
		Assert.assertTrue(match);
		paymentpage=cartpage.CheckOut();
		paymentpage.SelectCountry();	
	}
	@Then("Need to get the {string} Text on the screen")
	public void Need_to_get_the_StringTest_on_the_screen(String MSG)
	{
		String confirmMsg=paymentpage.PlaceOrder();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase(MSG));
		
	}
	@And("Close the Application")
	public void Close_the_Application()
	{
		driver.close();
	}
	
}
