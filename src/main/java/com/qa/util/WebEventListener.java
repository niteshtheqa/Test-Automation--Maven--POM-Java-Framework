package com.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigating to : '" + url + "'");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to: '" + url + "'");

	}

	
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");

	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");

	}

	
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	
	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Refreshing page");
	}

	
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page refreshed");
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element By : " + by.toString());
	}

	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Element Found By :" + by.toString());
	}

	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on Element : " + element.toString());
	}

	
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on :" + element.toString());
	}

	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of Element :" + element.toString() + " before any changes made");
	}

	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of element with changes:" + element.toString());
	}

	
	public void beforeScript(String script, WebDriver driver) {

	}

	
	public void afterScript(String script, WebDriver driver) {

	}

	
	public void onException(Throwable throwable, WebDriver driver) {
		try {
			TestUtil.takesScreenShots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
