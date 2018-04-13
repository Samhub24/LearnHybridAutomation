package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		
		this.driver = ldriver;
		
	}
	
	@FindBy(xpath="//input[@id='email']")WebElement username;
	@FindBy(xpath="//input[@id='pass']")WebElement password;
	@FindBy(xpath="//button[@id='send2']")WebElement login;
	By signout = By.xpath("html/body/div[1]/header/div[2]/div[1]/ul/li[2]/div/ul/li[3]/a");
	@FindBy(xpath ="html/body/div[1]/header/div[2]/div[1]/ul/li[2]/span/button")
	static WebElement Testname;
	
	public void loginApplication(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
	}
	
	public static void clickOnTestname()
	{
		Testname.click();
	}
	
	public void VerifysignOutLink()
	{
		LoginPage.clickOnTestname();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		String text = ele.getText();
		Assert.assertEquals(text, "Sign out");
		
	}
}