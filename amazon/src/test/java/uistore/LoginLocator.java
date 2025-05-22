package uistore;

import org.openqa.selenium.By;

public class LoginLocator {
    public static By login_button = By.xpath("//a[@href='/account/login?ret=/']");
    public static By ip_username = By.xpath("//input[@class='r4vIwl BV+Dqf']");
    public static By invalid_Email_popup = By.xpath("//div[text()='You are not registered with us. Please sign up.']");
    public static By continue_button  = By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']");
    public static By verification_popup = By.xpath("//div[@class='eIDgeN']");
}
