package com.base.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.pages.LoginPage;

public class loginTest extends BaseClass {

	@Test
	public void login() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login();
	}

}