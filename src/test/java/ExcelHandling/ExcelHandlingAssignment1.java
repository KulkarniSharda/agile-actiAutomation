package ExcelHandling;


    import com.actiautomation.CommonFunctions;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

    public class ExcelHandlingAssignment1 {
        WebDriver driver;
        CommonFunctions commonFunctions;
        Sheet sheet;
        FileInputStream inputStream;
        Workbook workbook;

        @BeforeClass
        public void browserSetup() throws InterruptedException, AWTException {
            commonFunctions = new CommonFunctions();
            driver = commonFunctions.launchBrowser("chrome");
            driver.get("https://online.actitime.com/oncospark");
            commonFunctions.loginForActitime();
            driver.manage().window().maximize();
            Robot rbt=new Robot();
            rbt.keyPress(KeyEvent.VK_CONTROL);
            rbt.keyPress(KeyEvent.VK_MINUS);
            rbt.keyRelease(KeyEvent.VK_MINUS);
            rbt.keyPress(KeyEvent.VK_MINUS);
            rbt.keyRelease(KeyEvent.VK_MINUS);
            rbt.keyPress(KeyEvent.VK_MINUS);
            rbt.keyRelease(KeyEvent.VK_MINUS);
            Thread.sleep(5000);
        }

        @Test
        public void writeAllCust() throws IOException {
            WebElement tasks = driver.findElement(By.xpath("//div[text()='Tasks']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", tasks);

            List<WebElement> customerList = driver.findElements(By.xpath("//div[@class='node customerNode notSelected editable']"));
            int noCust= customerList.size();
            System.out.println(noCust);
      /*  for (WebElement list : customerList) {
            String custTNames = list.getText();
            System.out.println(custTNames);
        }*/
            List<WebElement> projectList= driver.findElements(By.xpath("//div[@class='text']"));
            int noProj=projectList.size();
            System.out.println(noProj);
        /*for (WebElement listProject : projectList) {
            String projectNames = listProject.getText();
            System.out.println(projectNames);
        }*/


            // Create a new Excel workbook and sheet
            File file=new File("D:\\TestData.xlsx");
            String fileName=file.getName();
            String extension=fileName.substring(fileName.indexOf(".")+1);
            System.out.println(extension);
            inputStream=new FileInputStream(file);
            if(extension.equals("xlsx")){
                workbook=new XSSFWorkbook(inputStream);
            }
            else if(extension.equals("xls")){
                workbook=new HSSFWorkbook(inputStream);
            }
            //check sheet present of name "cyber" if not present then create sheet of name cyber
            if(workbook.getSheet("Project_Cust")!=null){
                sheet=workbook.getSheet("Project_Cust");
            }
            else {
                sheet=workbook.createSheet("Project_Cust");
            }


            for (int i = 0; i < customerList.size(); i++) {
                Row row=sheet.createRow(i);
                Cell cell=row.createCell(0);
                WebElement element=customerList.get(i);
                String customerNames=element.getText();
                cell.setCellValue(customerNames);

                Cell cell2 = row.createCell(1);
                WebElement projectElement = projectList.get(i);
                String projectNames = projectElement.getText();
                cell2.setCellValue(projectNames);
            }

            // Write the workbook to a file
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();

        }
    }

