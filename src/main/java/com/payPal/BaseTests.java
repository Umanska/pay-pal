package com.payPal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;

    public LoginPage setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/Yuliia_Umanska/Documents/my-staff/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.sandbox.paypal.com/us/signin");
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public void tearDown() {
        driver.quit();
    }
}
