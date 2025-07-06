package Order.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractData.AbstarctDataInfo;

public class OrdersPage extends AbstarctDataInfo{

	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//tr/td[2]")
	List<WebElement>product;
	
	public String OrdersIcon()
	{
		ClickOnOrders();
		String productName=product.get(0).getText();
		return productName;
	}

}
