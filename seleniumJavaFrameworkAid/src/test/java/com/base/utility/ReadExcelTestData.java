package com.base.utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelTestData {

	public static Object[][] readSheet(String path, String sheetName) throws Exception {

		try (FileInputStream fis = new FileInputStream(path); Workbook wb = new XSSFWorkbook(fis)) {

			Sheet sheet = wb.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows(); // 3
			int cols = sheet.getRow(0).getLastCellNum(); // 2

			Object[][] data = new Object[rows - 1][cols]; // skip header

			for (int i = 1; i < rows; i++) { // start at row 1
				Row row = sheet.getRow(i);
				for (int j = 0; j < cols; j++) {
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					data[i - 1][j] = cell.toString();
				}
			}
			return data;
		}
	}

}
