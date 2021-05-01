package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.BaseClass;

public class ValidateTitle extends BaseClass {
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	LandingPage landingPage;
	public WebDriver driver;
	@BeforeTest
	public void initializeDriverInstance() throws IOException {
		driver = initializeDriver();
		driver.get(System.getProperty("testEnvironmentURL"));
		
	}
	
	@Test
	public void valiadteTitleTest() throws IOException {

			landingPage = new LandingPage(driver);
			landingPage.closePopUp().click();
			Assert.assertEquals("FEATURED COURSES", landingPage.getTitle().getText());
			log.info("Title matches the value");
		}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
