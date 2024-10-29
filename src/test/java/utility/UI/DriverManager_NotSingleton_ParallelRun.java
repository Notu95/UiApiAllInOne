package utility.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager_NotSingleton_ParallelRun {
	
	public static WebDriver getDriver() {
		/* Method 1 of setting up driver */
		String projectPath1=System.getProperty("user.dir");
		//or
		String projectPath2=System.getProperty("..");
		System.setProperty("WebDriver.chrome.driver", projectPath1+"\\drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		return driver;
		
	}

}
