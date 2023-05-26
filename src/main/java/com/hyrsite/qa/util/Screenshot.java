package com.hyrsite.qa.util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot implements ITestListener {

    private static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result.getName());
    }

    public static void captureScreenshot(String screenshotName) {
        try {
            // Capture screenshot as File
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define destination path for the screenshot
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String destinationPath = "C:\\Users\\tando\\eclipse-workspace\\Testing\\target\\screenshots\\" + screenshotName + "_" + timestamp + ".png";

            // Save the screenshot to the destination path
            FileHandler.copy(screenshot, new File(destinationPath));

            System.out.println("Screenshot captured: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
