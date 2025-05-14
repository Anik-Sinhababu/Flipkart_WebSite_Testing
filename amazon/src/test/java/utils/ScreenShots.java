package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class ScreenShots {
    public void captureScreen(String filename)
    {
        try{
            TakesScreenshot ts = (TakesScreenshot)Base.driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(System.getProperty("user.dir") + Prop.getProperties("ssPath") + filename + ".png");
            FileUtils.copyFile(source, destinationFile); 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void captureElementScreenshot(By locator, String filename)
    {
        try{
            WebElement element = Base.driver.findElement(locator);
            File source = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(System.getProperty("user.dir") + Prop.getProperties("ssPath") + filename + ".png");
            FileUtils.copyFile(source, destinationFile);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
