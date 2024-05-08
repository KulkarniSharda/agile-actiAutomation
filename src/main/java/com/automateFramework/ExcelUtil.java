package com.automateFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil {

	static Workbook wb;
	static Sheet sheet;
	static Row row;

	/**
	 * This method will return the value in terms of  Object[][] (two dimentional array)
	 * @param filePath(path of the file which needs to be access )
	 * 
	 */
	public static Object[][] readExcelData(String filePath) throws IOException {

		Object[][] testData = null;

//		String file = "C:\\CyberSuccess\\InputData\\LoginData1.xlsx";

		String extention = filePath.substring(filePath.indexOf("."));

		try {
			FileInputStream input = new FileInputStream(filePath);

			if (extention.equals(".xlsx")) {

				wb = new XSSFWorkbook(input);

			} else {
				wb = new HSSFWorkbook(input);

			}

			sheet = wb.getSheetAt(0);
			row = sheet.getRow(0);

			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalColumns = row.getPhysicalNumberOfCells();

			testData = new Object[totalRows - 1][totalColumns];

			for (int i = 1; i <= totalRows - 1; i++) {

				for (int j = 0; j < row.getLastCellNum(); j++) {

					Cell cell = sheet.getRow(i).getCell(j);

					if (cell != null) {
						if (cell.getCellType().equals(CellType.STRING)) {

							testData[i - 1][j] = cell.getStringCellValue();

						} else if (cell.getCellType().equals(CellType.NUMERIC)) {

							testData[i - 1][j] = cell.getNumericCellValue();
						} else if (cell.getCellType().equals(CellType.BOOLEAN)) {

							testData[i - 1][j] = cell.getBooleanCellValue();

						} else if (cell.getCellType().equals(CellType.BLANK)) {
							System.out.println("Blank Cell");
							testData[i - 1][j] = null;
						}
					}

				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			wb.close();

		}
		return testData;
	}
	
	
	/**
	 * This method will write the value based on the row and column combination
	 * @param filePath, rowNumber, cellPosition, value
	 * 
	 */
	public static void writeExcelData(String filePath, int rowNumber, int cellPosition, Object value)
			throws IOException {
		String extention = filePath.substring(filePath.indexOf("."));

		try {
			FileInputStream input = new FileInputStream(filePath);

			if (extention.equals(".xlsx")) {

				wb = new XSSFWorkbook(input);
				System.out.println(wb);

			} else {
				wb = new HSSFWorkbook(input);

			}

			sheet = wb.getSheetAt(0);
			row = sheet.getRow(0);

			int totalRows = sheet.getPhysicalNumberOfRows();
			
			sheet.getLastRowNum();

			/*
			 * for(int i=1; i<=totalRows-1; i++) {
			 * 
			 * sheet.getRow(i).createCell(cellPosition).setCellValue("Fail");
			 * 
			 * }
			 */

			if (value.getClass().toString().contains("class java.lang.Integer")) {

				sheet.getRow(rowNumber).createCell(cellPosition).setCellValue((int) value);

			} else if (value.getClass().toString().contains("class java.lang.String")) {

				sheet.getRow(rowNumber).createCell(cellPosition).setCellValue(value.toString());
			}

			FileOutputStream output = new FileOutputStream(filePath);

			wb.write(output);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			wb.close();
		}

	}

	/**
	 * This method will return the value based on the row and column combination
	 */
	public static Object getCellValue(String filePath, int rowNum, int columnNum) throws IOException {

		String extention = filePath.substring(filePath.indexOf("."));

		Object returnData = null;

		try {
			FileInputStream input = new FileInputStream(filePath);

			if (extention.equals(".xlsx")) {

				wb = new XSSFWorkbook(input);

			} else {
				wb = new HSSFWorkbook(input);

			}

			sheet = wb.getSheetAt(0);

			Row row = sheet.getRow(rowNum);

			Cell cell = row.getCell(columnNum);

			if (cell.getCellType().equals(CellType.NUMERIC)) {

				returnData = cell.getNumericCellValue();

			} else if (cell.getCellType().equals(CellType.STRING)) {
				returnData = cell.getStringCellValue();

			} else if (cell.getCellType().equals(CellType.BOOLEAN)) {
				returnData = cell.getBooleanCellValue();

			}

//			returnData =  row.getCell(columnNum).getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			wb.close();
		}

		return returnData;
	}
}
