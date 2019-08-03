package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class ConfirmRegistration extends TestBase {

	public ConfirmRegistration() {
		PageFactory.initElements(driver, this);
	}

	// Object repository of Confirm Registration

	@FindBy(xpath = "//button[@name='finish' and @type='button']")
	WebElement completeRegistration;

	public LoginPage verifyRegistrationCompleted() {
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("completeRegistration")));
		completeRegistration.click();
		return new LoginPage();
	}
}
