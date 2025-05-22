package utils;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import runner.AppTest;
 
public class WebDriverHelper extends Base {
 
	LoggerHandler logger = new LoggerHandler();
	Reporter report = new Reporter();
	ExcelFile excelfile = new ExcelFile("");
	public ExtentTest test;

	public WebDriverHelper(ExtentTest test)
	{
		this.test = test;
	}

 
	public void clickElement(By locator, String message, String description, String eMessage) {
		try {
			WebElement element = driver.findElement(locator);
			element.click();
			logger.logInfo(message);
			report.attachScreenshotToReport(message, test, description);
		} catch (Exception e) {
			logger.logError(eMessage);
			report.attachFailedScreenshotToReport(eMessage, test, description);
			System.out.println(e.getMessage());
		}
	}
 
	public void sendKeys(By locator,String message, String description, String eMessage, String value) {
		try {
			WebElement element = driver.findElement(locator);
			element.sendKeys(value);
			logger.logInfo(message);
			report.attachScreenshotToReport(message, test, description);
		} catch (Exception e) {
			logger.logError(eMessage);
			report.attachFailedScreenshotToReport(eMessage, test, description);
			System.out.println(e.getMessage());
		}
	}
	
	public String getText(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "No text Found";
		}
	}
	
	public void switchWindow(int num) {
		try {
			List<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(num));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void hover(By locator, String message, String description, String eMessage) {
		try {
			WebElement element = driver.findElement(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
			logger.logInfo(message);
			report.attachScreenshotToReport(message, test, description);
		} catch (Exception e) {
			logger.logError(eMessage);
			report.attachFailedScreenshotToReport(eMessage, test, description);
			System.out.println(e.getMessage());
		}
	}
	
	public void scroll(By locator, String message, String description, String eMessage) {
		try {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			logger.logInfo(message);
		} catch (Exception e) {
			logger.logError(eMessage);
			report.attachFailedScreenshotToReport(eMessage, test, description);
			System.out.println(e.getMessage());
		}
	}
	
	public void waitForElement(By locator, int sec) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(sec))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void verify(By locator, String message, String description, String eMessage, String expectedvalue) {
		try {
			assert(expectedvalue.equals(getText(locator)));
			logger.logInfo(message);
			report.attachScreenshotToReport(message, test, description);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}catch(AssertionError ae) {
			logger.logError(eMessage);
			report.attachFailedScreenshotToReport(eMessage, test, description);
			System.out.println(ae.getMessage());
		}
	}
}
 