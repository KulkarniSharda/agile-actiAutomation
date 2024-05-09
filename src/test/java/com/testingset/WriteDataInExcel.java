package com.testingset;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataInExcel {
    FileInputStream inputStream;
    Workbook workbook;
    Sheet sheet;

    @Test
    public void writeData() throws IOException{
        File file=new File("D\\TestData.xlsx");
        //get the filename
        String filename=file.getName();
        //get extension  of file
        String extension = filename.substring(filename.indexOf(",") + 1);
        System.out.println(extension);
        //access the file
        inputStream = new FileInputStream(file);
        //access the workbook
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);

        } else if (extension.equals("xlx")) {
            workbook = new HSSFWorkbook(inputStream);
            //check if sheet present with cyber name
            //if it is present then use as is else create new sheet
            if(workbook.getSheet("cyber") !=null) {
                sheet= workbook.getSheet("cyber");



            } else{
                //create sheet
                sheet= workbook.createSheet("cyber");
            }
            for(int i=0; i<10; i++){
                //create row
                Row row= sheet.createRow(i);
                for(int j=0; j<2; j++){
                    //create cell
                    Cell cell=row.createCell(j);
                    if(j==0){
                        //add data in the cell
                        cell.setCellValue("Selenium" +i);
                    }else{
                        //add data in cell
                        cell.setCellValue("API" +i);

                    }
                }
            }


        }
        //write data in file
        FileOutputStream outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Data written successfully in excel file.....");


    }

}
