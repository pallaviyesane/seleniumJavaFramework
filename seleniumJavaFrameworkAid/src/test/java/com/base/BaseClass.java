package com.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.base.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	@BeforeSuite
	public void beforeSuite() throws IOException {
		ExtentManager.setExtent();
	}

	@BeforeMethod
	@Parameters("browser")
	public void init(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
		} else {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
		}

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}