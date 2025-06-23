package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void init() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}