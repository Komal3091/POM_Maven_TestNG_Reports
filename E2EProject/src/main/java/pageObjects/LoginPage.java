package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_email")
	private WebElement emailId;
	
	public WebElement emailId() {
		return emailId;
	}
	
	@FindBy(id = "user_password")
	private WebElement password;
	
	public WebElement password() {
		return password;
	}
	
	@FindBy(css = "[value='Log In']")
	private WebElement login;
	
	public WebElement login() {
		return login;
	}
}
