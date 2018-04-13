package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReport {
WebDriver driver;
ExtentReports reports;
ExtentTest logger;
	
	@BeforeMethod
	public void setup()
	{
		reports = new ExtentReports("./Reports/LoginPageReport.html",true);
		logger = reports.startTest("Verify Login Page", "This page will verify sign out link");
		driver = BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getconfig().getApplicationurl());
		logger.log(LogStatus.INFO, "Application is up and running");
		
	}
	
	@Test
	public void testHomePage()
	{
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getApplicationTitle();
		logger.log(LogStatus.PASS, "Home page loded and verified");
		Assert.assertTrue(title.contains("Avactis"), "Title is nor verified properly");
		home.clickOnSignIn();
		logger.log(LogStatus.INFO, "Click on SignIn Link");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getexcel().getdata("Login", 0, 0), DataProviderFactory.getexcel().getdata("Login", 0, 1));
		//login.VerifysignOutLink();
		logger.log(LogStatus.INFO, "Login to application");
		
	}
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closebrowser(driver);
		reports.endTest(logger);
		reports.flush();
	}


}
