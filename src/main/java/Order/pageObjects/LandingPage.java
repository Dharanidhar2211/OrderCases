package Order.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractData.AbstarctDataInfo;

public class LandingPage extends AbstarctDataInfo
{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	@FindBy(id = "userEmail")
	WebElement mail;
	
	@FindBy(id = "userPassword")
	WebElement pass;
	
	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(css = ".toast-error")
	WebElement toastmsg;
	public ProductCatlogPage LoginInfo(String Gmail,String password)
	{
		mail.sendKeys(Gmail);
		pass.sendKeys(password);
		login.click();
		ProductCatlogPage productcatlog=new ProductCatlogPage(driver);
		return productcatlog;
	}
	public String ErrorPopUp()
	{
		String ToastError=toastmsg.getText();
		return ToastError;
		
	}
	
	
	
	
	
	
}
