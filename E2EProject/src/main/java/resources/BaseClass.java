package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			if (browserName.contains("headless")) {
				chromeOptions.addArguments("headless");
				
			}
			driver = new ChromeDriver(chromeOptions);
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			//firefox code
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			//IE Code 
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\reports\\"+" "+testCaseName;
		FileUtils.copyFile(source, new File(destinationPath));
		return destinationPath;
	}
}
