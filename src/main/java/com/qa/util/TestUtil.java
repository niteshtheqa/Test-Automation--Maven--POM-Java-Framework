package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIME = 30;
	public static long IMPLICIT_WAIT_TIME = 20;

	public static String TESTDATA_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main"
			+ File.separator + "java" + File.separator + "com" + File.separator + "qa" + File.separator + "testdata";

	public static Workbook workbook;
	public static Sheet sheet;

	public void switchToFrame(String frameName) {

		driver.switchTo().frame(frameName);

	}

	public void switchToFrame(int index) {

		driver.switchTo().frame(index);

	}

	public static Object[][] getTestData(String fileName, String sheetName) {
		FileInputStream fileInputStream = null;

		try {
			fileInputStream = new FileInputStream(TESTDATA_FILE_PATH + File.separator + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook = WorkbookFactory.create(fileInputStream);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = workbook.getSheet(sheetName);

		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;

	}

}
