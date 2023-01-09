package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day11_ExtentReports extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    //1. Extent reports is used for generating CUSTOM HTML REPORTS
    //2. We can add compony or project specific information in the report configuration

    @BeforeClass
    public static void extentReportsSetUp(){
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
//        ***************
//        adding custom System Info
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("SQA","John Fox");
//        adding more custom info
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");
//        ********************
//        DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter);
//      SUMMARY:EXTENT REPORTS AND EXTENT HTML REPORTER IS USED TO ADD CUSTOM INFORMATION ON THE REPORT AND CREATE THE REPORT IN A PATH

//        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");
    }

    @Test
    public void extentReportsTest(){
        extentTest.pass("Going to the App Homepage");
        driver.get("https://www.techproeducation.com");

//        click on LMS
        extentTest.pass("Clicking on LMS login button");
        driver.findElement(By.linkText("LMS LOGIN")).click();

//        verify the URL
        extentTest.pass("verify the url");
        String expectedURL ="https://lms.techproeducation.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED",expectedURL,actualURL);
        extentTest.pass("test is complete");

    }

    @Test
    public void setExtentReportsTest2(){
        //pass is used to mark the step as PASSED
        extentTest.pass("PASS");
        //info is used to just give an information for that step
        extentTest.info("INFO");
        //failed is used to mark the step as failed
        extentTest.fail("FAILED");
        //skip is used to mark the step as skipped
        extentTest.skip("SKIPPED");
        //warning is used to give warning information
        extentTest.warning("WARNING");
    }
    @AfterClass
    public static void extentReportsTearDown(){
        //generating the report
        extentReports.flush();
    }



}
