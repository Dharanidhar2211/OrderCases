package Order.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Order.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest 
{
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver LaunchDriver() throws IOException
	{
	
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\DHARANIDHAR\\eclipse-workspace\\OrderCases\\src\\main\\java\\Ordercases\\data\\browser.properties");
		prop.load(fis);
		String BrowserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		//String BrowserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		if(BrowserName.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(BrowserName.contains("headless"))
			{
				options.addArguments("headless");
			}	
			driver =new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		else if (BrowserName.equalsIgnoreCase("firefox"))
		{
			 driver=new FirefoxDriver();
		}
		else if (BrowserName.equalsIgnoreCase("Edge"))
		{
			 driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	
	}
	public List<HashMap<String, String>> GetJsonData(String Path) throws IOException
	{
	String jsondata=FileUtils.readFileToString(new File(Path),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsondata, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	
		//json to String //String to HashMap
	}
	public String GetScreenShot(String TestCaseName,WebDriver driver) throws IOException
	{
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"//reports//"+TestCaseName+".png"));
		return System.getProperty("user.dir")+"//reports//"+TestCaseName+".png";
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage InitinilizeDriver() throws IOException
	{
		driver=LaunchDriver();
		landingpage=new LandingPage(driver);
		landingpage.GoTo();
		return landingpage;
	}
	@AfterMethod(alwaysRun = true)
	public void Quit()
	{
		driver.close();

	}

}
