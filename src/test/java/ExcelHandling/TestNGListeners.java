package ExcelHandling;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


    import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class TestNGListeners implements ISuiteListener, ITestListener {
        String ssFolderPath;
        @Override
        public void onStart(ISuite suite) {
            System.out.println("This is onStart method of ISuiteListener");

            String currentDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yy"));

            System.out.println(currentDate );

            ssFolderPath= System.getProperty("user.dir")+"/reports/"+ currentDate;
            File file= new File(ssFolderPath);
            if(!file.exists()){ // check if the folder is not present
                file.mkdir();  //create a folder
            }

        }
        @Override
        public void onFinish(ISuite suite) {
            System.out.println("This is onFinish method of ISuiteListener");
        }
        //ITestListener
        @Override
        public void onStart(ITestContext context) {
            System.out.println("This is onStart method of ITestListener");
        }

        public void onFinish(ITestContext context) {
            System.out.println("This is onFinish method of ITestListener");
        }

        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("This is onTestStart method of ITestListener");
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("This is onTestSuccess method of ITestListener");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            // getTestContext return context (variables, method name, exceptions, results) of the @Test method
            try {
                WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

                //get the method name from context

                String methodName = result.getMethod().getMethodName();

                String fileName = ssFolderPath+"/"+methodName+".png";
                File dstFile = new File(fileName);
                FileUtils.copyFile(srcFile, dstFile);
            } catch (Exception e) {
            }
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println("This is onTestSkipped method of ITestListener");
        }
}
