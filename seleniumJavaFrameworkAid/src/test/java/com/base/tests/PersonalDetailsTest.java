package com.base.tests;

import org.testng.annotations.Test;

import com.base.BaseClass;

public class PersonalDetailsTest extends BaseClass {
	
	@Test
	public void clickOnMyInfo() {
		personalDetailsPage.clickOnMyInfo();
		personalDetailsPage.AddEmployeeDetails();
	}

}
