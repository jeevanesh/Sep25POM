package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.qa.opencart.constants.AppConstants.*;
import com.qa.opencart.utils.ElementUtil;
import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators

	private final By email = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@value='Login']");
	private final By forgotPwdLink = By.linkText("Forgotten Password");
	private final By registerLink = By.linkText("Register");

	// 2. Public page Constructor to initialize the driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions - methods to perform actions on the page

	@Step("getting login page title")
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login Page Title: " + title);
		return title;
	}

	@Step("getting login page url")
	public String getLoginPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("login page url: " + url);
		return url;
	}

	@Step("checking forgot pwd link exist")
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);
	}

	@Step("login with valid username: {0} and password: {1}")
	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("user credentials: " + username + ":" + pwd);
		eleUtil.waitForElementVisible(email, MEDIUM_DEFAULT_TIMEOUT).sendKeys(username);

		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);

//		String title = driver.getTitle();
//		System.out.println("Accounts page title: " + title);
//		return title;

		return new AccountsPage(driver);
	}

	@Step("navigating to the registeration page")
	public RegisterPage navigateToRegisterPage() {
//		eleUtil.clickWhenReady(registerLink, DEFAULT_TIMEOUT);
		driver.findElement(registerLink).click();
		return new RegisterPage(driver);
	}

}
