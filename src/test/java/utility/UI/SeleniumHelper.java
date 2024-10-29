package utility.UI;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.stepDef.Hooks;

public class SeleniumHelper {
	static WebDriver driver;
	public SeleniumHelper(WebDriver driver) {
		this.driver=driver;
	}
	//------------Waits-----------------
	public static void getImplicitelyWait(long miliSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(miliSeconds) );
		
	}
	public static void getExpliciteWaitOfVisibility(WebElement element,long miliSeconds) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(miliSeconds));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	public static void getExpliciteWaitOfClickable(WebElement element,long miliSeconds) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(miliSeconds));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void getExpliciteWaitOfAlertIsPresent(long miliSeconds) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(miliSeconds));
		w.until(ExpectedConditions.alertIsPresent());
	}
	public static void getExpliciteWaitOfAttributeContains(WebElement element,String attribute, String value, long miliSeconds) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(miliSeconds));
		w.until(ExpectedConditions.attributeContains(element,attribute,value));
	}
	//------------------Scrolling--------------------
	public static void getScrollInToView(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	//------------------ScreenShot--------------------
	public static File takeScreenshot() { //returnsFile
		File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		return f1;
	}
	public static void Screenshot(String screenShotName) throws IOException { //returnsFile
		File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path_name_type=System.getProperty("user.dir")+"\\target\\reports\\"+CreateUniqueDateFolder.getLatestDateFolderName("target\\reports")+"\\"+Hooks.timeString+"\\screenshots\\"+screenShotName+".png";
		copyFileAtWithName(f1,path_name_type);
		
	}
	//-----------------copyFile------------------------
	public static void copyFileAtWithName(File f ,String path_name_type) throws IOException {
		File f1=new File(path_name_type);
		if(f1.exists()) {
			String[] pathSpilt=path_name_type.split("\\.");
			String path_name_type_version= pathSpilt[0]+"(1)."+pathSpilt[1];
			SeleniumHelper.copyFileAtWithName(f, path_name_type_version);
		}else{
			String[] pathSpilt=path_name_type.split("\\.");
			FileUtils.copyFile(f, f1);
		}
		
		
	}
	
}
