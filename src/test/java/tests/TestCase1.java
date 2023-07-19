package tests;

import org.testng.annotations.Test;

import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class TestCase1 {
	ElementFetch ele = new ElementFetch();
	HomePageEvents homepage = new HomePageEvents();
	LoginPageEvents loginpage = new LoginPageEvents();
@Test
public void sampleMethodEnteringCredentials() {
	homepage.signInButton();
	loginpage.verifyIfLoginPageIsLoaded();
	loginpage.enterCredentials();
}
}
