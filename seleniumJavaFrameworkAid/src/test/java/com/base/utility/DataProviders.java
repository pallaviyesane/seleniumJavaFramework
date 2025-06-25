package com.base.utility;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "login-data")
	public static Object[][] loginData() throws Exception {
		return ReadExcelTestData.readSheet("C:\\Users\\SUHAS\\Documents\\seleniumJavaFramework\\seleniumJavaFrameworkAid\\src\\test\\resources\\TestDada.xlsx", // relative or absolute path
				"Sheet1");
	}
}