package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(xpath="html/body/div[1]/header/div[2]/div[1]/ul/li[2]/a")WebElement SignIn;
	@FindBy(xpath="//a[@id='ui-id-3']/span")WebElement Fashion;
	@FindBy(xpath="//a[@id='ui-id-4']/span")WebElement Electronics;
	@FindBy(xpath="//a[@id='ui-id-5']/span")WebElement HomeAppliances;
	@FindBy(xpath="//a[@id='ui-id-6']/span")WebElement HelthBeauty;
	
	public void clickOnSignIn()
	{
		SignIn.click();
	}
	public void clickOnFashion()
	{
		Fashion.click();
	}
	public void clickOnElectronics()
	{
		Electronics.click();
	}
	public void clickOnHomeAppliances()
	{
		HomeAppliances.click();
	}
	public void clickOnHelthBeauty()
	{
		HelthBeauty.click();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
	

}