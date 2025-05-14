package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.Base;
import utils.Reporter;

public class AppTest extends Base {
    ExtentReports reports;
    public static ExtentTest test;
    Reporter report = new Reporter();

    @BeforeClass
    public void createReport() {
        reports = report.generateReport();
    }

    @BeforeMethod
    public void browser() {
        openBrowser();
    }

    @Test
    public void testCase1() {
        
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void flush() {
        reports.flush();
    }
}
