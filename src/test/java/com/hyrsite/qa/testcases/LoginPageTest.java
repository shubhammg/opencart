package com.hyrsite.qa.testcases;

import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hyrsite.qa.base.TestBase;
import com.hyrsite.qa.page.LoginPage;
import com.hyrsite.qa.util.ExcelDataReader;
import com.hyrsite.qa.util.Screenshot;
import com.qa.ExtentTReportListener.ExtentReportListener;



public class LoginPageTest extends TestBase {

	LoginPage loginPage;
  private ExtentReports extent;
    private ExtentTest test;
   
    ITestResult result;
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialize();
		loginPage = new LoginPage();
		extent = ExtentReportListener.getInstance();
        test = ExtentReportListener.startTest("MyTest");
       
		

	}
	
	
	@Test(enabled=true)
	public void loginTitleTest() throws IOException {
		
		loginPage.validatePageTitle();
		loginPage.img.getText();
		loginPage.feature.click();
		
		//loginPage.selectDropdownOptionByValue("SHOWCASE");
		
		/*
		 * ExcelDataReader read=new ExcelDataReader(); Object[][] data=
		 * read.readExcel(); for (Object[] row : data) { for (Object value : row) {
		 * System.out.print(value + "\t"); } System.out.println(); }
		 */
	}
	@DataProvider(name = "excelData")
    public Object[][] getExcelData() throws IOException {
        return ExcelDataReader.readExcel();
    }
	
	@Test(dataProvider = "excelData")
	
	public void loginTest(String name, String age, String email,ITestResult result) {
		
		
		
		
		//Screenshot.takeScreenshot(driver, "ss1");
		
		System.out.println("Name: " + name + ", Age: " + age + ", Email: " + email);
		
		test.pass("My test First test case passed");
		
		
	}
	@Test
	public void pageClick() {
		loginPage.clickFunction();
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
       
        driver.quit();
		ExtentReportListener.endTest();
		
		
	}
	
	/*public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotName = result.getMethod().getMethodName();
           // screenshot.captureScreenshot(screenshotName);
*/        
	
	/*
	 * @BeforeMethod public void setup() throws IOException { // Load the
	 * configuration file prop = new Properties(); FileInputStream fis = null; try {
	 * fis = new FileInputStream(
	 * "C:\\Users\\tando\\eclipse-workspace\\Testing\\src\\main\\java\\com\\hyrsite\\qa\\config\\config.properties"
	 * ); } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } prop.load(fis);
	 * 
	 * // Initialize the driver object initialize(); }
	 * 
	 * @Test public void loginTest() { // Navigate to the login page
	 * driver.get(prop.getProperty("url"));
	 * 
	 * // Perform the login action LoginPage loginPage = new LoginPage();
	 * 
	 * loginPage.enterUsername(prop.getProperty("username"));
	 * loginPage.enterPassword(prop.getProperty("password"));
	 * loginPage.clickLoginButton();
	 * 
	 * // Assert that the login was successful
	 * assertTrue(driver.getCurrentUrl().contains("dashboard")); }
	 * 
	 * @AfterMethod public void tearDown() { // Close the browser driver.quit(); }
	 */

}