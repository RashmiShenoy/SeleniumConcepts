package testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LoginPage;
import utilities.Helper;

public class LoginTestCRM extends BaseClass {
	
	@Test
	public void loginApp() throws InterruptedException, IOException {
		
		logger = report.createTest("Login to CRM");
		
		LoginPage loginPage =  PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		loginPage.loginToCRM(excel.getStringData("Sheet1", 0, 0),excel.getStringData("Sheet1", 0, 1));
	
		logger.pass("Login success");
	}
}
