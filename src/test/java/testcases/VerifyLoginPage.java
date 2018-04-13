package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getconfig().getApplicationurl());
		
	}
	
	@Test
	public void testHomePage()
	{
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("Avactis"), "Title is nor verified properly");
		home.clickOnSignIn();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getexcel().getdata("Login", 0, 0), DataProviderFactory.getexcel().getdata("Login", 0, 1));
		//login.VerifysignOutLink();
		
	}
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closebrowser(driver);
	}


}
