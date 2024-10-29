package utility.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/* You can randomly access singleton-driver using this class directly*/
public class DriverManager_Singleton {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			/* Method 1 of setting up driver */
			String projectPath1 = System.getProperty("user.dir");
			// or
			String projectPath2 = System.getProperty("..");
			// Setting Up Driver properties
//		System.setProperty("WebDriver.chrome.driver", projectPath1+"\\drivers\\chromedriver-win64(3)\\chromedriver.exe");

			/* Method 2 of setting up driver */
			// WebDriverManager.chromedriver().browserVersion("130.0.6723.58").setup();
			WebDriverManager.chromedriver().setup();
//		WebDriverManager.edgedriver().setup();

			/* invoking browser */
			driver = new ChromeDriver();
//		driver=new EdgeDriver();

			return driver;
		} else {
			return driver;
		}

	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
