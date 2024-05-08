package SeleniumFramework;

import java.awt.Font;
import java.io.File;
import java.util.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExcelHandling extends baseClass {

	@org.testng.annotations.DataProvider(name = "ExcelData")
	public Object[][] excelMethod() throws Exception {

		Object[][] testData = null;
		XSSFWorkbook wb = null;

		File file = new File("C:\\CyberSuccess\\InputData\\LoginData1.xlsx");

		try {
			FileInputStream inputFile = new FileInputStream(file);

			wb = new XSSFWorkbook(inputFile);

			XSSFSheet sheet = wb.getSheet("Sheet1");

			XSSFRow row = sheet.getRow(0);

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
				wb.getSheetAt(0);
				sheet.getRow(i).createCell(7).setCellValue("Pass");
				
				FileOutputStream output=new FileOutputStream(file);
				
				wb.write(output);				
				
			}
			
		
			
		} catch (Exception e) {

		}

		return testData;

	}

	@BeforeClass
	public void beforeClass() {
//		driver = launchBrowser("Chrome");

//		driver.navigate().to("");
	}

	@Test(dataProvider = "ExcelData")
	public void m1(String username, Object password, String FN, String LN, double age, double salary, String city, String status) {
		/*
		 * System.out.println("username : " + username + ", password: " + password +
		 * ", FirstName : " + FN + ", LastName : " + LN + ", Age : " + age +
		 * ", Salary : " + salary + ", City : " + city);
		 */
		/*
		 * driver.findElement(By.id("username")).sendKeys(username);
		 * driver.findElement(By.id("passwo1rd")).sendKeys(password.toString());
		 * driver.findElement(By.id("loginButton")).click();
		 * 
		 * Assert.assertTrue(driver.findElement(By.id("Admin")).isDisplayed());
		 * 
		 * driver.findElement(By.id("firstName")).sendKeys(FN);
		 */

	}
	
	@Test
	public void method2() throws IOException {
		
		ConfigProperties config=new ConfigProperties();
		
		String filePath= config.getProperty("ExcelFilePath");
		
		System.out.println(ExcelUtil.getCellValue(filePath, 1, 4));
		
		  ExcelUtil.writeExcelData(filePath,6,4, 23568);
		  ExcelUtil.writeExcelData(filePath,6,1, "CyberSuccess");
		 
	}
	
	
	@DataProvider(name ="GetExcelData")
	public Object[][] getExcelData() throws IOException {
		
		ConfigProperties config=new ConfigProperties();
		
		String filePath= config.getProperty("ExcelFilePath");
		
		return ExcelUtil.readExcelData(filePath);
	}

}
