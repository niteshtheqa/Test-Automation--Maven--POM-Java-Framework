package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	SoftAssert softAssert = new SoftAssert();
	TestUtil testUtil;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactPage();

	}

	@Test(enabled = false)
	public void verifyContactsLabel() {
		boolean flag = contactsPage.verifyContactLabel();
		softAssert.assertTrue(flag);
	}

	@DataProvider
	public Object[][] getCRMTestData() {

		Object data[][] = TestUtil.getTestData("test.xlsx", "Contacts");
		return data;

	}

	@Test(enabled = true, dataProvider = "getCRMTestData")
	public void verfiyCreateNewContact(String title, String firstname, String surname, String company)
			throws InterruptedException {

		homePage.clickOnNewContactsPage();
		contactsPage.createNewContact(title, firstname, surname, company);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
