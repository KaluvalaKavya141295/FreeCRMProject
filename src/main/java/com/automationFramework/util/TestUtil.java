package com.automationFramework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automationFramework.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String Testdatapath="C:\\Users\\K Yadava Reddy\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\automationFramework\\testdata\\FreeCRMTestData.xlsx";
	static FileInputStream file=null;
	static Workbook book;
	static Sheet sheet;
	
	
	public static int PAGE_LOAD_TIMEOUT=30;
	public static int IMPLICIT_WAIT=20;
	
	public  void  switchToFrame() {
		driver.switchTo().frame("mainpanel");
		
	}
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Testdatapath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}
		catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentDir= System.getProperty("");
		FileUtils.copyFile(srcfile, new File("C:\\Users\\K Yadava Reddy\\eclipse-workspace\\FreeCRMTest" +"/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
	
}
