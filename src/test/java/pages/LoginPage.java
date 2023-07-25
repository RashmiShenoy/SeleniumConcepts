package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	 public LoginPage(WebDriver ldriver) {
		 this.driver = ldriver;
	 }
	 
	 @FindBy(xpath = "//*[contains(text(),'Log In')]") WebElement loginFirst;
	 @FindBy(name = "username") WebElement uname;
	 @FindBy(name = "password") WebElement password;
	 @FindBy(xpath = "//input[@value = 'Login']") WebElement loginBtn;
	 
	 public void loginToCRM(String username, String pass) throws InterruptedException{
		 Thread.sleep(2000);
		 
		 loginFirst.click();
		  uname.sendKeys(username);
		  password.sendKeys(pass);
		  loginBtn.click();
	 }
	 
}
