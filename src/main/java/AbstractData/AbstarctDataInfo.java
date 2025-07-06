package AbstractData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Order.pageObjects.OrdersPage;

public class AbstarctDataInfo {

	WebDriver driver;
	public AbstarctDataInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orders;
	
	public void VisibilityOFWebElement(WebElement wait1)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(wait1));
	}
	public void InVisibilityOFWebElement(WebElement wait1) throws InterruptedException
	{
		Thread.sleep(2000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOf(wait1));
	}
	public void ClickOnCart()
	{
		cart.click();
	}
	public OrdersPage ClickOnOrders()
	{
		orders.click();
		OrdersPage orderpage=new OrdersPage(driver);
		return orderpage;
	}

}
