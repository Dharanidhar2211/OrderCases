package Ordercases.data;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterTEST 
{
	public static ExtentReports ExtentReportTest()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\Results.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("OrderTestCase");
		reporter.config().setDocumentTitle("Automation Results");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Name", "Dharanidhar");
		extent.setSystemInfo("ID", "1234");
		extent.setSystemInfo("Chrome Version", "137.0.7151.122");
		return extent;
	}

}
