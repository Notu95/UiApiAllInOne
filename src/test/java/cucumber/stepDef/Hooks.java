package cucumber.stepDef;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import ui.pageObjects.GooglePage;
import utility.UI.CreateUniqueDateFolder;
import utility.UI.DriverManager_NotSingleton_ParallelRun;
import utility.UI.DriverManager_Singleton;
import utility.UI.SeleniumHelper;
import utility.overall.ExtentReportsUtility;
import utility.overall.LoggerUtility;

/*  Hooks class should be under stepDef folder */
/* Init the landingPage/allPage pageObject elements under setUp_InitElements() */
public class Hooks {
	static WebDriver driver;
	static GooglePage googlePage;
	public static String timeString;

	static ExtentReports extent = ExtentReportsUtility.getExtentReportsInstance();
	ExtentTest test;

	// @Before(order=1)
	public void setUp_notSingleInstance() {
		DriverManager_NotSingleton_ParallelRun dmns = new DriverManager_NotSingleton_ParallelRun();
		this.driver = dmns.getDriver();
	}

	// -----------------driverSetUp------------------
	@Before(order = 1)
	public void setUp_SingleDriverInstance() {
//		DriverManager_Singleton dms = new DriverManager_Singleton();
		this.driver = DriverManager_Singleton.getDriver();

	}

	// ......Initialize page objects
	@Before(order = 3)
	public void setUp_InitElements() {
		googlePage = new GooglePage(driver);

	}

	public GooglePage getGooglePage() {
		return googlePage;

	}

	// -------------extent report---------------
	@Before(order = 2)
	public void setUp_ExtentReport(Scenario scenario) {
		test = extent.createTest(scenario.getName());

	}

	// .........initialize SeleniumHelper----------
	@Before(order = 4)
	public void setUp_InitSeleniumHelper() {
		new SeleniumHelper(driver);

	}

	// ................create target folder----------
	@BeforeAll(order = 2)
	public static void setUp_targetFolder() {
		CreateUniqueDateFolder.createUniqueDateFolder("target\\reports");
		String path = System.getProperty("user.dir") + "\\target\\reports\\" + CreateUniqueDateFolder.dateString()
				+ "\\" + Hooks.timeString;
		File folder = new File(path);
		Boolean b = folder.mkdirs();
		if (b = true) {
			System.out.println("HHmm folder created at : " + path);
		} else {
			System.out.println("HHmm folder not created at : " + path);
		}
	}

	// ---------------FixingTimeSignature--------------
	@BeforeAll(order = 1)
	public static void setUp_timeSignature() {
		String str = Hooks.getTimeString();

	}

	public static void timeSignature() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm");
		timeString = currentDateTime.format(format);
	}

	public static String getTimeString() {
		if (timeString == null) {
			Hooks.timeSignature();
		}
		return timeString;
	}

	// ..........tearDown-----------------
	@AfterAll
	public static void tearDownScenario() {
		DriverManager_Singleton.closeDriver();
	}

	@After(order = 1)
	public void tearDownScenario_1(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String scenarioName = scenario.getName();
			LoggerUtility.info(this.getClass(), "Scenario Failed: " + scenarioName);
			String path_name_type = System.getProperty("user.dir") + "\\target\\reports\\"
					+ CreateUniqueDateFolder.getLatestDateFolderName("target\\reports") + "\\" + timeString
					+ "\\screenshots\\" + "FailedScreenshot_" + scenarioName + ".png";// .jpg";

			SeleniumHelper.copyFileAtWithName(SeleniumHelper.takeScreenshot(), path_name_type);
		}
		if (!scenario.isFailed()) {
			String scenarioName = scenario.getName();
			LoggerUtility.info(this.getClass(), "Scenario Success: " + scenarioName);
			String path_name_type = System.getProperty("user.dir") + "\\target\\reports\\"
					+ CreateUniqueDateFolder.getLatestDateFolderName("target\\reports") + "\\" + timeString
					+ "\\screenshots\\" + "SuccessScreenshot_" + scenarioName + ".png";// .jpg";

			SeleniumHelper.copyFileAtWithName(SeleniumHelper.takeScreenshot(), path_name_type);
		}
	}

	@After(order = 2)
	public void tearDownExtentReport(Scenario scenario) {
		if (scenario.isFailed()) {
			test.log(Status.FAIL, timeString);
		} else {
			test.log(Status.PASS, timeString);
		}
		// test.addScreenCaptureFromPath(path, title);

		extent.flush();
	}

}
