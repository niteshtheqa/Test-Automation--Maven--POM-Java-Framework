package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Page object repository of Login Page
	@FindBy(xpath = "//input[@type='text' and @name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//img[@src='https://classic.crmpro.com/img/logo.png']")
	WebElement imageLogo;

	// Page methods

	public String pageTitle() {
		return driver.getTitle();
	}

	public boolean crmImageLogo() {
		return imageLogo.isDisplayed();
	}

	public HomePage login(String un, String pw) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("username")));
		username.sendKeys(un);
		password.sendKeys(pw);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("loginButton")));
		loginButton.click();
		return new HomePage();
	}
}
