package utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
