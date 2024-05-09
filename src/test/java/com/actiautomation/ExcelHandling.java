package com.actiautomation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandling {
    FileInputStream inputStream;
    Workbook workbook;

    public Workbook getWorkbook(String filePath) throws IOException {
        File file = new File("D\\TestData.xlsx");
        String filename = file.getName();
        String extension = filename.substring(filename.indexOf(",") + 1);
        System.out.println(extension);
        //access the file
        inputStream = new FileInputStream(file);
        //access the workbook
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);

        } else if (extension.equals("xlx")) {
            workbook = new HSSFWorkbook(inputStream);


        }
        return  workbook;

    }
    //get the exel data
    @DataProvider
    public Object [][] getExcelData() throws  IOException{
        Workbook workbook=getWorkbook("D:\\TestData.xlsx");





        //accesss the file

        //access The workbook

        //access 0th index sheet
        Sheet sheet=workbook.getSheetAt(0);
        //get total number of rows
        int totalRows= sheet.getPhysicalNumberOfRows();
        System.out.println("Total Rows:"+ totalRows);
        //get total num of columns
        Row row;
        row= sheet.getRow(0);
        int totalColumns=row.getPhysicalNumberOfCells();
        System.out.println("Total Columns:"+totalColumns);
        Object [][] data=new Object[totalRows-1][totalColumns];





        for(int i=1; i<totalRows; i++){
            //get access of each row based on value of i
            row= sheet.getRow(i);
            for(int j =0; j<totalColumns; j++){
                Cell cell= row.getCell(j);
                String  val =cell.getStringCellValue();
                System.out.println(val + "");








            }
            System.out.println();

        }
        return data;

        //close file
      //  inputStream.close();



    }
    // close workbook and fileinputstream instances
    public  void closeInstances() throws IOException {

    }
    @Test(dataProvider="getExcelData")
    public void verifyExcelData( Object var1, Object var2) throws  IOException{
        System.out.println(var1 + "" + var2);
    }
    @AfterClass
    public void tearDown() throws IOException{
        closeInstances();

    }


}
