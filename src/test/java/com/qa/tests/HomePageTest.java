package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.Util;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	Util util;
	SoftAssert assert1 = new SoftAssert();

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		util = new Util();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(enabled = true)
	public void verifyHomePageTitleTest() {
		assert1.assertEquals(homePage.verifyHomePageTitle(), "CRMPRO");
	}

	@Test(enabled = true)
	public void verifyUserTest() {
		util.switchToFrame("mainpanel");
		assert1.assertTrue(homePage.verifyUser());
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
