package Order.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractData.AbstarctDataInfo;

public class PaymentPage extends AbstarctDataInfo  {

	WebDriver driver;
	public PaymentPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css = ".ta-results")
	WebElement wait5;
	
	
	@FindBy(css = ".ta-results button:last-of-type")
	WebElement India;
	
	@FindBy(css = ".hero-primary")
	WebElement wait6;
	
	@FindBy(css = ".action__submit")
	WebElement PlaceOrder;
	
	@FindBy(css = ".hero-primary")
	WebElement success;
	
	
	public void SelectCountry()
	{
		Actions a=new Actions(driver);
		a.sendKeys(Country, "India").build().perform();
		VisibilityOFWebElement(wait5);
		India.click();
	}
	public String PlaceOrder()
	{
		PlaceOrder.click();
		VisibilityOFWebElement(wait6);
		String confirmMsg=success.getText();
		return confirmMsg;
	}

}
