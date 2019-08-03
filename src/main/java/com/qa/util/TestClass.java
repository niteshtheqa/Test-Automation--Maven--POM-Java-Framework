package com.qa.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.xmlbeans.impl.tool.XSTCTester.TestCase;

import com.qa.base.TestBase;

public class TestClass extends Util {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		TestClass testClass = new TestClass();
		String fileName = "test.xlsx";
		String sheetName = "Datasheet";
		Object[][] str = testClass.getTestData(fileName, sheetName);

		
	}
}
