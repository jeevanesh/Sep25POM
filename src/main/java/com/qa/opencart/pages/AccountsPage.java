package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	// constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccPageTitle() {
		String title = driver.getTitle();
		System.out.println("Home Page Title: " + title);
		return title;	
	}
	
	public String getAccPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Accounts page URL: " + url);
		return url;
	}

}
