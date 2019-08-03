package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class CompanyAndProfileDetailsPage extends TestBase {

	ConfirmRegistration confirmRegistration;

	public CompanyAndProfileDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Object of Company and Profile details Page

	@FindBy(xpath = "//input[@name='company_name']")
	WebElement comapny;

	@FindBy(name = "phone")
	WebElement phone;

	@FindBy(xpath = "//input[@name='fax']")
	WebElement fax;

	@FindBy(xpath = "//input[@name='website']")
	WebElement website;

	@FindBy(xpath = "//input[@name='company_email']")
	WebElement comapny_email;

	@FindBy(xpath = "//select[@name='country']")
	WebElement country;

	@FindBy(xpath = "//input[@name='copy_address']")
	WebElement copy_address_checkbox;

	@FindBy(name = "btnSubmit")
	WebElement continueButton;

	// Methods of Company Details Page

	public ConfirmRegistration verifyProfileDataSubmit(String comp, String ph, String cntry) {

		comapny.sendKeys(comp);
		phone.sendKeys(ph);
		country.click();
		Select contry = new Select(country);
		contry.selectByVisibleText(cntry);
		continueButton.click();

		return new ConfirmRegistration();
	}
}
