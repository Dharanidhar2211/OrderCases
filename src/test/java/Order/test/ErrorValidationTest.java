package Order.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Order.TestComponents.BaseTest;
import Order.TestComponents.ReTry;
import Order.pageObjects.CartPage;
import Order.pageObjects.LandingPage;
import Order.pageObjects.OrdersPage;
import Order.pageObjects.PaymentPage;
import Order.pageObjects.ProductCatlogPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ErrorValidationTest extends BaseTest{

	//Tc_003
	@Test(priority = 0,retryAnalyzer = ReTry.class)
	public void ErrorValidationtest() throws InterruptedException
	{
		ProductCatlogPage productcatlog=landingpage.LoginInfo("dharanidhar220@gmail.com", "Ilovecricket@123q");
		String ErrorText=landingpage.ErrorPopUp();
		Assert.assertEquals(ErrorText, "Incorrect email or password.");	
	}
	//Tc_004
	@Test(priority = 1)
	public void ItemErrorMsg() throws InterruptedException
	{
		ProductCatlogPage productcatlog=landingpage.LoginInfo("dharanidhar2211@gmail.com", "Ilovecricket@123");
		List<WebElement> products=productcatlog.GetProducts();
		CartPage cartpage=productcatlog.AddProductTOCart("ZARA COAT 3");
		boolean match=cartpage.CartProducts("ZARA COAT #");
		Assert.assertFalse(match);
	}
	
	

}
