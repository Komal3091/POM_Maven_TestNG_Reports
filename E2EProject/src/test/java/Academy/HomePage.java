package Academy;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass {
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	//WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	public WebDriver driver;
	@BeforeTest
	public void initializeDriverInstance() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");
		driver.get(System.getProperty("testEnvironmentURL"));
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		    
		    log.info("Navigated to Home page");
			landingPage = new LandingPage(driver);
			loginPage = new LoginPage(driver);
			landingPage.closePopUp().click();
			landingPage.loginButton().click();
			loginPage.emailId().sendKeys(username);
			loginPage.password().sendKeys(password);
			loginPage.login().click();
			log.info(text);
			driver.navigate().back();
			
		}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[1][3];
		data[0][0] = "Komal";
		data[0][1] = "Krishna";
		data[0][2] = "Granted User";
		/*data[1][0] = "Kunal";
		data[1][1] = "Krishna1";
		data[1][2] = "Restricted User";*/
		
		return data;
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}


