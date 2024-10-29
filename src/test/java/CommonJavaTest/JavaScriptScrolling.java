package CommonJavaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;


public class JavaScriptScrolling {
	public static void main(String[] Args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(" https://rahulshettyacademy.com/practice-project");
		WebElement element =driver.findElement(By.xpath("//h2[text()='Join now to Practice']"));
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0, 1000);");
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element );
		}
	

}

