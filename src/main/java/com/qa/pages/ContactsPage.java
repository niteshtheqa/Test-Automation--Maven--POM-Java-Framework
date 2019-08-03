package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// Contacts Page Object Repository

	@FindBy(xpath = "//td[@class='datacardtitle' and contains(text(),'Contacts')]")
	WebElement contactLabel;

	@FindBy(name = "by_user")
	WebElement selectContact;
}
