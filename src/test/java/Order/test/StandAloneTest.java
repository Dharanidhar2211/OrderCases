package Order.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Order.TestComponents.BaseTest;
import Order.pageObjects.CartPage;
import Order.pageObjects.LandingPage;
import Order.pageObjects.OrdersPage;
import Order.pageObjects.PaymentPage;
import Order.pageObjects.ProductCatlogPage;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class StandAloneTest extends BaseTest{

	//Tc_001
	@Test(priority = 0,groups = "PurchaseOrderTest",dataProvider = "GetData")
	public void SubmitOrderTest(HashMap<String, String> input) throws InterruptedException
	{
		ProductCatlogPage productcatlog=landingpage.LoginInfo(input.get("email"), input.get("password"));
		List<WebElement> products=productcatlog.GetProducts();
		CartPage cartpage=productcatlog.AddProductTOCart(input.get("item"));
		boolean match=cartpage.CartProducts(input.get("item"));
		Assert.assertTrue(match);
		PaymentPage paymentpage=cartpage.CheckOut();
		paymentpage.SelectCountry();		
		String confirmMsg=paymentpage.PlaceOrder();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
	}
	//Tc_002
	@Test(priority = 1)
	public void OrderHistoryTest()
	{
		ProductCatlogPage productcatlog=landingpage.LoginInfo("dharanidhar220@gmail.com", "Ilovecricket@123");
		OrdersPage orderpage=landingpage.ClickOnOrders();
		String productName=orderpage.OrdersIcon();
		Assert.assertEquals(productName, "ZARA COAT 3");
	
	}
	@DataProvider
	public Object[][] GetData() throws IOException
	{
		List<HashMap<String, String>> map=GetJsonData("C:\\Users\\DHARANIDHAR\\eclipse-workspace\\OrderCases\\src\\main\\java\\Ordercases\\data\\data.json");
		return new Object[][] {{map.get(0)},{map.get(1)}};
		
	}

}
