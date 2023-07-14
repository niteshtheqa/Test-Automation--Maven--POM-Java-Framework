package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;
	public static Properties prop;
	public static WebDriverWait wait;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener webEventListener;

	public TestBase() {
		try {

			prop = new Properties();

			String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "java" + File.separator + "com" + File.separator + "qa" + File.separator
					+ "config" + File.separator + "configuration.properties";
			FileInputStream fileInputStream = new FileInputStream(filePath);
			prop.load(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver", "");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}

		eventFiringWebDriver = new EventFiringWebDriver(driver);
		webEventListener = new WebEventListener();
		eventFiringWebDriver.register(webEventListener);
		driver = eventFiringWebDriver;
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("baseURL"));

	}

	public static void takesScreenShots() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String currentDir = System.getProperty("user.dir") + File.separator + "screenshots";

		FileUtils.copyDirectory(srcFile,
				new File(currentDir + "\\screenshots_\\" + System.currentTimeMillis() + ".png"));

	}

}
