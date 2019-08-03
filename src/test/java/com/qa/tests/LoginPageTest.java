package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	SoftAssert assert1 = new SoftAssert();

	public LoginPageTest() {
		super(); // Call to Parent class Constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization(); // initialization method of TesstBase class
		loginPage = new LoginPage();// LoginPage Object
	}

	@Test(priority = 1)
	public void pageTitleTest() {

		String actual = driver.getTitle();
		assert1.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", actual);
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.crmImageLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
