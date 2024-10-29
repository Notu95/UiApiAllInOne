package CommonJavaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeBrowser {
//	static WebDriver driver;
	
	public static void main(String[]  args) {
		
//		String projectPath1=System.getProperty("user.dir");
//		System.setProperty("WebDriver.chrome.driver", projectPath1+"\\drivers\\chromedriver-win64\\chromedriver.exe");
//		System.out.println(projectPath1+"\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		System.out.println("Browser invoked");
		driver.get("https://www.google.com");
	}

}
