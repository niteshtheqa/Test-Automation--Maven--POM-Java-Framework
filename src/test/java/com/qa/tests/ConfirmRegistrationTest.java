package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CompanyAndProfileDetailsPage;
import com.qa.pages.ConfirmRegistration;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;

public class ConfirmRegistrationTest extends TestBase {

	LoginPage loginPage;
	SignUpPage signUpPage;
	CompanyAndProfileDetailsPage companyAndProfileDetailsPage;
	ConfirmRegistration confirmRegistration;

	public ConfirmRegistrationTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		confirmRegistration = new ConfirmRegistration();
		signUpPage = new SignUpPage();
		companyAndProfileDetailsPage = new CompanyAndProfileDetailsPage();
		signUpPage.crmSingUp("Free Edition", prop.getProperty("firstname"), prop.getProperty("surname"),
				prop.getProperty("email"), prop.getProperty("username"), prop.getProperty("password"));
		companyAndProfileDetailsPage.verifyProfileDataSubmit("AAA", "+918983661435", "India");

	}

	@Test
	public void verifyRegistrationCompletedTest() {
		loginPage = confirmRegistration.verifyRegistrationCompleted();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
