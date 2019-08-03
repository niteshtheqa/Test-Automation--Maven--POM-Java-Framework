package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.CompanyAndProfileDetailsPage;
import com.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase {

	SignUpPage signUpPage;
	CompanyAndProfileDetailsPage companyAndProfileDetailsPage;
	SoftAssert softAssert = new SoftAssert();

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		signUpPage = new SignUpPage();

	}

	@Test(enabled = true,priority =1)
	public void verifySignUpPageTitle() {
		String title = driver.getTitle();

		System.out.println("************" + title + "***********************");
		softAssert.assertEquals("CRMPRO - CRM Pro for customer relationship management, sales, and support", title);
	}

	@Test(enabled = true,priority =2)
	public void verifySignUpButtonClickableTest() {
		boolean flag = signUpPage.verifySignUpButtonIsClickable();

		softAssert.assertTrue(flag);
	}

	@Test(priority =3)
	public void verifySignUpFeatureTest() {
		companyAndProfileDetailsPage = signUpPage.crmSingUp("Free Edition", prop.getProperty("firstname"), prop.getProperty("surname"),
				prop.getProperty("email"), prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
