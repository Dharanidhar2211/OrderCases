package Order.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Ordercases.data.ExtentReporterTEST;

public class Listerners extends BaseTest implements ITestListener 
{
	ExtentReports extent=ExtentReporterTEST.ExtentReportTest();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) 
	{
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().log(Status.FAIL, result.getMethod().getMethodName());
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		String path=null;
		try {
			path = GetScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());

	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		onTestFailure(result);
	}
	@Override
	public void onStart(ITestContext context) 
	{

	}
	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
}
