package com.base.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public void login() {
		uName.sendKeys("Admin");
		password.sendKeys("admin123");
		submitButton.click();
	}

}
