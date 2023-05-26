package com.qa.ExtentTReportListener;
import org.testng.ITestNGListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestNGListener  {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            // Set the file path for the report
            String reportPath = "C:\\Users\\tando\\eclipse-workspace\\Testing\\test-output\\Extent.html";

            // Create a new ExtentSparkReporter instance with the file path
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            // Attach the reporter to the ExtentReports instance
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }

        return extentReports;
    }

    public static ExtentTest startTest(String testName) {
        // Create a new ExtentTest instance with the given test name
        extentTest = extentReports.createTest(testName);

        return extentTest;
    }

    public static void endTest() {
        // End the current test
        extentReports.flush();
    }
}
