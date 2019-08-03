package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CompanyAndProfileDetailsPage;
import com.qa.pages.ConfirmRegistration;
import com.qa.pages.SignUpPage;

public class CompanyAndProfileDetailsPageTest extends TestBase {

	CompanyAndProfileDetailsPage companyAndProfileDetailsPage;
	ConfirmRegistration confrimRegistration;
	SignUpPage signUpPage;

	public CompanyAndProfileDetailsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		companyAndProfileDetailsPage = new CompanyAndProfileDetailsPage();
		signUpPage = new SignUpPage();
		companyAndProfileDetailsPage = signUpPage.crmSingUp("Free Edition", prop.getProperty("firstname"),
				prop.getProperty("surname"), prop.getProperty("email"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

	@Test
	public void verifyCompanyAndProfileDetailsEnteredTest() {
		confrimRegistration = companyAndProfileDetailsPage.verifyProfileDataSubmit("AAA", "+918983661435", "India");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
