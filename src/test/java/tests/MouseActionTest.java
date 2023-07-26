package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
		Actions action = new Actions(driver);
		driver.navigate().to("https://www.amazon.in");
		driver.manage().window().maximize();
		
		WebElement elementToType = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		action.sendKeys(elementToType, "iphone").build().perform();
		
		WebElement elementToClick = driver.findElement(By.xpath("//input[@value='Go']"));
		Thread.sleep(5000);
		
		action.click(elementToClick).build().perform();
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in : iphone");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		driver.quit();
	}

}
