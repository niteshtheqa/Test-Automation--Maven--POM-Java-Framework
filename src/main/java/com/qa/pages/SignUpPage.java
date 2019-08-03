package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class SignUpPage extends TestBase {

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	// Sign Up Page Object repository

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpButton;

	@FindBy(name = "payment_plan_id")
	WebElement paymentPlan;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='surname']")
	WebElement surname;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(xpath = "//input[@name='email_confirm']")
	WebElement confirmEmail;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='passwordconfirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agreeTerms']")
	WebElement agreeTerms;

	@FindBy(xpath = "//button[@name='submitButton']")
	WebElement submitButton;

	public String crmSingupPageTitle() {
		return driver.getTitle();
	}

	public boolean verifySignUpButtonIsClickable() {
		return signUpButton.isEnabled();
	}

	public CompanyAndProfileDetailsPage crmSingUp(String paymentId, String fn, String sn, String em, String un, String pw) {
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("signUpButton")));

		signUpButton.click();
		System.out.println("signButton clicked");
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("paymentPlan")));
		paymentPlan.click();
		System.out.println("Drop down clicked");
		Select p_id = new Select(paymentPlan);
		p_id.selectByVisibleText(paymentId);
		System.out.println("Value selected");
		firstName.sendKeys(fn);
		surname.sendKeys(sn);
		email.sendKeys(em);
		confirmEmail.sendKeys(em);
		username.sendKeys(un);
		password.sendKeys(pw);
		confirmPassword.sendKeys(pw);
		agreeTerms.click();
		submitButton.click();
		return new CompanyAndProfileDetailsPage();

	}

}
