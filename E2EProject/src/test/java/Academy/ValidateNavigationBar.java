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

public class ValidateNavigationBar extends BaseClass{
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	LandingPage landingPage;
	public WebDriver driver;
	
	@BeforeTest
	public void initializeDriverInstance() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");
		driver.get(System.getProperty("testEnvironmentURL"));
		log.info("Navigated to Home page");
	}
	
	@Test
	public void validateNavigationBarTest() throws IOException {
			landingPage = new LandingPage(driver);
			landingPage.closePopUp().click();
			Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
			log.info("Navigation bar is displayed");
		}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
