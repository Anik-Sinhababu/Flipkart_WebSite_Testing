package pages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import uistore.LoginLocator;
import utils.Base;
import utils.WebDriverHelper;

public class LoginPageAction extends Base{
        public ExtentTest test;
        WebDriverHelper helper;
        public LoginPageAction(ExtentTest test)
        {
            this.test = test;
            this.helper = new WebDriverHelper(test);
        }
        


        public void loginWith_Nonexistant_email(String sendkeys, String expectedValue) throws InterruptedException
        {
            helper.clickElement(LoginLocator.login_button, "click login button in Homepage", "Login_Button Clicked", "Could not click on login button");
            helper.clickElement(LoginLocator.ip_username, "Click on input field", "Click on input field", "Could not click on input field");
            helper.sendKeys(LoginLocator.ip_username, "Send non-existant email to as input", "Send non-existant email to as input", "Could not send values to input field", sendkeys);
            Thread.sleep(1000);
            helper.clickElement(LoginLocator.continue_button, "Click on Continue button", "Click on Continue button", "Could not click on continue button.");
            Thread.sleep(1500);
            helper.verify(LoginLocator.invalid_Email_popup, "un-registered email: message successfully shown", "unregistered email displayed", "Not an unregistered email", expectedValue);
        }

        public void loginWith_Registered_Email(String sendKeys, String expectedValue) throws InterruptedException
        {
            helper.clickElement(LoginLocator.login_button, "click login button in Homepage", "Login_Button Clicked", "Could not click on login button");
            helper.clickElement(LoginLocator.ip_username, "Click on input field", "Click on input field", "Could not click on input field");
            helper.sendKeys(LoginLocator.ip_username, "Send non-existant email to as input", "Send non-existant email to as input", "Could not send values to input field", sendKeys);
            Thread.sleep(1000);
            helper.clickElement(LoginLocator.continue_button, "Click on Continue button", "Click on Continue button", "Could not click on continue button.");
            Thread.sleep(1500);
            helper.verify(LoginLocator.verification_popup, "Verification mail sent", "Verification mail sent", "unregistered email", expectedValue);
        }


}
