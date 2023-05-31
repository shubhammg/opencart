package com.hyrsite.qa.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hyrsite.qa.base.TestBase;
import com.hyrsite.qa.page.LandingPage;
import com.hyrsite.qa.page.LoginPage;
import com.hyrsite.qa.util.ExcelDataReader;
import com.qa.ExtentTReportListener.ExtentReportListener;

public class LandingPageTest extends TestBase{
	// my new
	LoginPage loginPage;
	LandingPage landingPage;
	  private ExtentReports extent;
	    private ExtentTest test;
	    ITestResult result;
	    public LandingPageTest() {
	    	super();
	    }
	
	@BeforeMethod
	public void setup() {

		initialize();
		loginPage = new LoginPage();
		landingPage =new LandingPage();
		extent = ExtentReportListener.getInstance();
        test = ExtentReportListener.startTest("MyTest");
        loginPage.loginBtn();

}

	
	@AfterMethod
	public void tearDown(ITestResult result) {
       
        driver.quit();
		ExtentReportListener.endTest();
	}
	
@Test(dataProvider="excelData")
public void loginFunctionality(String email) {
	
	landingPage.email.sendKeys(email);
}
@DataProvider(name = "excelData")
public Object[][] getExcelData() throws IOException {
    return ExcelDataReader.readExcel();
}

}
