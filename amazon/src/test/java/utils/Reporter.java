package utils;
 
import java.io.File;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class Reporter {
	static ExtentReports reports;
	static ExtentSparkReporter spark;
 
	public ExtentReports generateReport() {
		try {
			spark = new ExtentSparkReporter(System.getProperty("user.dir") + Prop.getProperties("reportPath"));
			reports = new ExtentReports();
			reports.attachReporter(spark);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reports;
	}
 
	public String captureScreenshot(String filename) {
		String name = filename + ".png";
		String destPath = "./" + name;
		TakesScreenshot ts = (TakesScreenshot) Base.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\reports");
		File target = new File(destination, name);
		try {
			FileUtils.copyFile(source, target);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return destPath;
	}
 
	public void attachScreenshotToReport(String filename, ExtentTest test, String description) {
		try {
			test.log(Status.PASS, description,
					MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(filename)).build());
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
 
	public static String captureFailedScreenshot(By locator, String filename) {
		String name = filename + ".png";
		String destPath = "./" + name;
		WebElement element=Base.driver.findElement(locator);
		File source = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\reports");
		File target = new File(destination, name);
		try {
			FileUtils.copyFile(source, target);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return destPath;
	}
 
	public void attachFailedScreenshotToReport(String filename, ExtentTest test, String description) {
		try {
			test.log(Status.FAIL, description,
					MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(filename)).build());
		} catch (Exception e) {
			e.getMessage();
		}
	}
    
}