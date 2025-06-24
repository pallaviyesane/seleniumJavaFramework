package com.base.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "username")
	private WebElement uName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button")
	private WebElement submitButton;

	public void login(String userName, String passwordValue) throws InterruptedException {
		uName.sendKeys(userName);
		password.sendKeys(passwordValue);
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

}
