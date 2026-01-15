package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import static com.qa.opencart.constants.AppConstants.*;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.ExcelUtil;
public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void registerSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"Tony", "Mark", "9898989898", "tony@123", "yes"},
			{"Rahul", "Mehta", "9898989896", "Rahul@123", "no"},
			{"Tara", "Wadekar", "9898989895", "Tara@123", "yes"}
		};
	}
	
	@DataProvider
	public Object[][] getUserRegData() {
		Object regData[][] = ExcelUtil.getTestData(REGISTER_SHEET_NAME);
		return regData;
	}
	
	
	@Test(dataProvider = "getUserRegData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Assert.assertTrue(
				registerPage.
					userRegisteration(firstName, lastName, telephone, password, subscribe));
	}
	
	
}
