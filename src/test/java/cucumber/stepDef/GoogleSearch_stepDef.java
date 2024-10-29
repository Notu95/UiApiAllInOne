package cucumber.stepDef;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import ui.pageObjects.GooglePage;
import utility.UI.DriverManager_Singleton;
import utility.UI.SeleniumHelper;
import utility.overall.LoggerUtility;

public class GoogleSearch_stepDef {

	Hooks hooks;
	WebDriver driver;
	GooglePage googlePage;

	@Given("browser is loaded")
	public void browser_is_loaded() {
		LoggerUtility.info(this.getClass(), "Loading browser....");
		hooks = new Hooks();
		this.driver = hooks.driver;
		System.out.println(driver instanceof ChromeDriver);
	}

	@When("^load the url (.*)$")
	public void load_the_url(String url) {
		LoggerUtility.info(this.getClass(), "Loading url....");
		hooks.driver.get(url);
	}

	@Then("verify that google searchbox is visible")
	public void verify_that_google_searchbox_is_visible() {
		LoggerUtility.info(this.getClass(), "Verifying Search box...");
		this.googlePage = hooks.getGooglePage();
		Assert.assertTrue(googlePage.searchBox.isDisplayed());

	}

	@Then("^enter (.*) in the google serach box$")
	public void enter_tcs_in_the_google_serach_box(String companyName) throws IOException {
		googlePage.enterText(companyName);
		SeleniumHelper.Screenshot("EnteredCompanyName");
	}

	@Then("click on google search button")
	public void click_on_google_search_button() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
		}
//		googlePage.blankSpace.click();
//		googlePage.enterSearchButton();
		googlePage.searchBox.sendKeys(Keys.ENTER);
	}

	@Then("^validate that (.*) is visible$")
	public void validate_that_is_visible(String companyUrl) {
		boolean b = DriverManager_Singleton.getDriver().getPageSource().contains(companyUrl);
		Assert.assertTrue(b);
	}

	@Then("validate that video section is coming")
	public void validate_that_video_section_is_coming() {
		SeleniumHelper.getImplicitelyWait(10000);
		googlePage.reInitializeElements();
		// GooglePage googlePage=new GooglePage(driver); // instead of calling
		// constructor again, just reinitialize
		SeleniumHelper.getScrollInToView(googlePage.videoSection);
		SeleniumHelper.getExpliciteWaitOfVisibility(googlePage.videoSection, 10000);
		boolean b = googlePage.videoSection.isDisplayed();
		Assert.assertTrue(b);
	}

}
