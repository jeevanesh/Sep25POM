package com.qa.opencart.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static com.qa.opencart.constants.AppConstants.*;


@Feature("F 50: Open Cart - Login Feature")
@Epic("Epic 100: design pages for open cart application")
@Story("US 101: implement login page for open cart application")
public class LoginPageTest extends BaseTest {
	
	@Description("checking open cart login page title...")
	@Severity(SeverityLevel.MINOR)
	@Owner("Jeevanesh")
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		ChainTestListener.log("Login page title is: " + title);
		Assert.assertEquals(title, LOGIN_PAGE_TITLE);
	}
	
	@Description("checking open cart login page url...")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Jeevanesh")
	@Test
	public void loginPageUrlTest() {
		String url = loginPage.getLoginPageUrl();
		Assert.assertTrue(url.contains(LOGIN_PAGE_URL_FRACTION));
	}
	
	@Description("checking open cart login page has forgot pwd link...")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Jeevanesh")
	@Test(enabled = false)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("check user is able to login with valid user credentials...")
	@Severity(SeverityLevel.BLOCKER)
	@Owner("Jeevanesh")
	@Test(priority = Short.MAX_VALUE, description = "login with valid credentials")
	public void doLoginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), HOME_PAGE_TITLE);
	}
	
	@Test(enabled = false, description = "WIP -- forgot pwd check")
	public void forgotPwd() {
		System.out.println("forgot pwd ");
	}
	
	
}
