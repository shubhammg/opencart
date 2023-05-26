package com.hyrsite.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	protected static WebDriver driver =null;
	static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fileInputStream = new FileInputStream(
					"C:\\Users\\tando\\eclipse-workspace\\Testing\\src\\main\\java\\com\\hyrsite\\qa\\config\\config.properties");
			prop.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialize() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tando\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\tando\\Downloads\\chromedriver_win32");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
	}

	/*
	 * public WebDriver driver; public Properties prop;
	 * 
	 * public void initialize() { // Get the browser name from the configuration
	 * file String browserName = prop.getProperty("browser");
	 * 
	 * // Initialize the driver object based on the browser name if
	 * (browserName.equals("chrome")) {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C://Users//tando//Downloads//chromedriver_win32"); driver = new
	 * ChromeDriver(); } else if (browserName.equals("firefox")) {
	 * System.setProperty("webdriver.gecko.driver", "path/to/geckodriver"); driver =
	 * new FirefoxDriver(); }
	 * 
	 * // Maximize the browser window driver.manage().window().maximize();
	 * 
	 * // Set the implicit wait time for the driver
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); }
	 */
}
