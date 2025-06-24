package com.base.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.pages.LoginPage;

public class loginTest extends BaseClass {

	@Test(dataProvider = "LoginDetails")
	public void loginT(String username, String password, String expectedURL) throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(username, password);
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
	}

	@DataProvider(name = "LoginDetails")
	public Object[][] loginDetails() {

		Object[][] loginData = new Object[2][3];

		loginData[0][0] = "Admin";
		loginData[0][1] = "admin123";
		loginData[0][2] = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

		loginData[1][0] = "AdminInValiad";
		loginData[1][1] = "admin123Invalid";
		loginData[1][2] = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		return loginData;
	}

}