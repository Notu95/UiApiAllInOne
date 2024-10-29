package utility.overall;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import cucumber.stepDef.Hooks;
import utility.UI.CreateUniqueDateFolder;

public class ExtentReportsUtility {

	private static ExtentReports extent;

	public static ExtentReports getExtentReportsInstance() {
		if (extent == null) {
			extent = ExtentReportsUtility.createExtentReportsInstance();
			return extent;
		} else {
			return extent;
		}
	}

	public static ExtentReports createExtentReportsInstance() {
		// ExtentSparkReporter
		String path1 = System.getProperty("user.dir") + "\\target\\reports\\"
				+ CreateUniqueDateFolder.getLatestDateFolderName("target\\reports") + "\\" + Hooks.getTimeString()
				+ "\\extentReport.html";

		String path = System.getProperty("user.dir") + "//Reports//extentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path1);
		reporter.config().setReportName("Web Automation Test Result Report");
		reporter.config().setDocumentTitle("Cucumber Selenium Test Report");

		// ExtentReports
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester ", "Sourav");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", "Chrome"); // set property file and name browser there to access in any class
		return extent;

	}

}
