package com.hiphen.crm.generic.ilistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{
	
int lowerlimit=0;
int upperlimit=5;
@Override
public boolean retry(ITestResult result) {
	if(lowerlimit<upperlimit)
	{
		lowerlimit++;
		return true;
	}
		
		
	return false;
}

}
