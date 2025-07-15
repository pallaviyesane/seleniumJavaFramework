package com.base.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.pages.LoginPage;
import com.base.utility.DataProviders;

public class loginTest extends BaseClass {
	LoginPage loginPage;

	@Test(dataProvider = "LoginDetails", enabled = false)
	public void loginT(String username, String password, String expectedURL) throws InterruptedException {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(username, password);
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
	}

	@Test(enabled = false)
	public void forgrtPassword() {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.forgotPassword();
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCodes");
	}

//	@Test(expectedExceptions = { NoSuchSessionException.class, TimeoutException.class, UnreachableBrowserException.class })
//	public void testExceptionTestNg() throws TimeoutException {
//		// loginPage = PageFactory.initElements(driver, LoginPage.class);
//		driver.findElement(By.id("sdf"));
//		loginPage.testException();
//	}

	@Test(dataProvider = "login-data", dataProviderClass = DataProviders.class, enabled = false)
	public void loginUsingExcelData(String username, String password) throws InterruptedException {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(username, password);
		// Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
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