package pages;

import java.io.IOException;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.BrowserFactory;
import utilities.ConfigDataProvider;
import utilities.Helper;
import utilities.ReadFile;

public class BaseClass {
	public WebDriver driver;
	public ReadFile excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() throws IOException {
		excel = new ReadFile();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+ "./reports/FreeCRM-" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath
					(Helper.captureScreenshot(driver)).build());)
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath
					(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
	}
}
