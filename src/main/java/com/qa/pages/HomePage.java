package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
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
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
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

	public ContactsPage clickOnContactPage() {
		contactLink.click();
		return new ContactsPage();
	}

	public void clickOnNewContactsPage() throws InterruptedException {
		Thread.sleep(5000);
		String strJavaScript = "var element = arguments[0];"
				+ "var mouseEventObj = document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );" + "element.dispatchEvent(mouseEventObj);";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(strJavaScript, driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(contactLink).build().perform();
		newContactLink.click();
	}

}
