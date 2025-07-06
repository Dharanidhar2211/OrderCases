package Order.pageObjects;

import java.util.List;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractData.AbstarctDataInfo;

public class CartPage extends AbstarctDataInfo{

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> CartProducts;
	
	@FindBy(xpath ="//button[text()='Checkout']")
	WebElement wait4;
	
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;
	
	
	
	
	
	public boolean CartProducts(String item)
	{
		VisibilityOFWebElement(wait4);
		boolean match=CartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		return match;
	}
	public PaymentPage CheckOut()
	{
		checkout.click();
		
		PaymentPage paymentpage=new PaymentPage(driver);
		return paymentpage;
	}
}
