package runner;
import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import pages.LoginPageAction;
import utils.Base;
import utils.DataProviders;
import utils.Reporter;


public class AppTest extends Base {
    ExtentReports reports;
    public ExtentTest loginTest;
    Reporter report = new Reporter();
    LoginPageAction loginAction;

    @BeforeClass
    public void createReport() {
        reports = report.generateReport();
        
    }

    @BeforeMethod
    public void browser(Method method) {
        openBrowser();
        loginTest = reports.createTest(method.getName()); 
        loginAction = new LoginPageAction(loginTest);
        
    }

    @Test(dataProvider = "nonExistantEmail", dataProviderClass = DataProviders.class, priority = 1, enabled = true)
    public void testCase1(String category, String sendkeys, String expectedValue) throws InterruptedException {
        loginAction.loginWith_Nonexistant_email(sendkeys, expectedValue);
    }

    @Test(dataProvider = "RegisteredEmail", dataProviderClass = DataProviders.class, priority = 2, enabled = true)
        public void testCase2(String category, String sendkeys, String expectedValue) throws InterruptedException
        {
            loginAction.loginWith_Registered_Email(sendkeys, expectedValue);
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
