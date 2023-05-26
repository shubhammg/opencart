package com.hyrsite.qa.testcases;

import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hyrsite.qa.base.TestBase;
import com.hyrsite.qa.page.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialize();
		loginPage = new LoginPage();

	}

	@Test
	public void loginTitleTest() {
		loginPage.validatePageTitle();
		

	}
	@Test
	public void loginTest() {
		loginPage.loginBtn();
		

	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

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
