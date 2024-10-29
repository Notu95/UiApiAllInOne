package ui.pageObjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage   {
	WebDriver driver;
	
	public  GooglePage(WebDriver driver){
		//super();
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void reInitializeElements() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//textarea[@title='Search']")
	public WebElement searchBox;

	@FindBy(css="div[class='FPdoLc lJ9FBc'] input[name='btnK']")  
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']") 
	public WebElement searchButton1;
	
	@FindBy(xpath="//span[text()='Videos']") 
	public WebElement videoSection;
	
	
	@FindBy(css="div[class='o3j99 LLD4me LS8OJ']")  
	public WebElement blankSpace;
	
	
	
	public void enterText(String searchText) {
		searchBox.sendKeys(searchText);
	}
	
	public void enterSearchButton() {
		searchButton1.click();
	}
}
