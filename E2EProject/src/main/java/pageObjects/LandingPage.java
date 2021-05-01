package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[href*='sign_in']")
	private WebElement loginButton;
	
	public WebElement loginButton() {
		return loginButton;
	}
	
	@FindBy(xpath = "//div[@class='text-center']/h2")
	private WebElement title;
	
	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']")
	private WebElement navigationBar;
	
	public WebElement getNavigationBar() {
		return navigationBar;
	}
	
	@FindBy(xpath = "//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button")
	private WebElement closepPopUp;
	
	public WebElement closePopUp() {
		return closepPopUp;
	}
	
	

}
