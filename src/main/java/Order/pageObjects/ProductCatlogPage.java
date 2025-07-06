package Order.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractData.AbstarctDataInfo;

public class ProductCatlogPage extends AbstarctDataInfo {

	WebDriver driver;
	public ProductCatlogPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = ".mb-3")
	WebElement wait1;
	
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	
	
	@FindBy(xpath = "//div[text()=' Product Added To Cart ']")
	WebElement wait2;
	
	@FindBy(css = ".ng-animating']")
	WebElement wait3;
	
	public List<WebElement> GetProducts()
	{
		VisibilityOFWebElement(wait1);
		 return products;
	}
	public WebElement GetProduct(String item)
	{
		WebElement prod=GetProducts().stream().filter(s->s.findElement(By.tagName("b")).getText().equals(item)).findFirst().orElse(null);
		return prod;
	}
	public CartPage AddProductTOCart(String item) throws InterruptedException
	{
		WebElement prod=GetProduct(item);
		prod.findElement(addToCart).click();
		VisibilityOFWebElement(wait2);
		InVisibilityOFWebElement(wait3);
		ClickOnCart();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	
	}
	

}
