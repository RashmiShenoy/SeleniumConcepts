package pageEvents;

import org.testng.Assert;

import pageObjects.LoginPageElement;
import utils.ElementFetch;

public class LoginPageEvents {
    ElementFetch ele = new ElementFetch();
    public void verifyIfLoginPageIsLoaded(){
        Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElement.LoginText).size()>0,"Element not found");

    }
    public void enterEmailID(){
        Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElement.LoginText).size()>0,"Element not found");

    }
    public void enterCredentials(){
        ele.getWebElement("XPATH",LoginPageElement.emailAddress).sendKeys("user@example.com");
        ele.getWebElement("XPATH",LoginPageElement.passwordField).sendKeys("12345");
    }
}