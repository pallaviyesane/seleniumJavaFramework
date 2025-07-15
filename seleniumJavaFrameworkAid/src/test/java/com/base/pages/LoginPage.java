package com.base.pages;

import java.time.Duration;

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

	@FindBy(name = "username")
	private WebElement uName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button")
	private WebElement submitButton;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//p[@class='abc']")
	private WebElement testException;

	public void login(String userName, String passwordValue) throws InterruptedException {
		uName.sendKeys(userName);
		password.sendKeys(passwordValue);
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void forgotPassword() {
		forgotPassword.click();
	}
	
	public void testException() {
		testException.click();
	}

}
