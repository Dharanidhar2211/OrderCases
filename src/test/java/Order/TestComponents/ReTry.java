package Order.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTry implements IRetryAnalyzer
{

	int count=0;
	int MaxTry=1;
	@Override
	public boolean retry(ITestResult result)
	{
		if(count<MaxTry)
		{
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
