package utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	public static String captureScreenShot(WebDriver driver,String screenshotname)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = "D:\\Selenium Mobility\\com.learnautomation.selenium1\\Screentshots\\"+screenshotname+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			System.out.println("Failed to Capture screenshots"+e.getMessage());
		} 	
		return destination;
	}
	   
}
