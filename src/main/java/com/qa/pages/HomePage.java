package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	// Object Repository of Home Page

	@FindBy(xpath = "//td[contains(text(),'User: nitesh wayafalkar')]")
	WebElement user;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactLink;
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement newContactLink;

	public boolean verifyUser() {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("user")));
		boolean user1 = user.isDisplayed();
		System.out.println("***********" + user1 + "***********************");
		return user1;
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsPage() {

		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		return new ContactsPage();
	}

}
