package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(name = "title")
	WebElement title;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement first_name;

	@FindBy(xpath = "//input[@name='surname']")
	WebElement surname;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;

	@FindBy(xpath = "//input[@type='button' and @value='Load From Company']//following-sibling::input[@value='Save']")
	WebElement save;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;

	public boolean verifyContactLabel() {

		return contactLabel.isDisplayed();
	}

	public void createNewContact(String title, String firstname, String surname, String company) {

		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		first_name.sendKeys(firstname);
		this.surname.sendKeys(surname);
		this.company.sendKeys(company);
		save.click();

	}

}
