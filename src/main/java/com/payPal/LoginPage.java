package com.payPal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    protected WebDriver driver;
    protected MyAccountPage myAccountPage;
    private LoginPage loginPage;

    static String PAGE_TITLE = "Log in to your PayPal account";
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By submitEmailButton = By.id("btnNext");
    private By submitPasswordButton = By.id("btnLogin");
    private By submittedEmail = By.className("profileDisplayEmail");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkPageTitle() {
        return driver.getTitle().equals(PAGE_TITLE);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitEmail() {
        driver.findElement(submitEmailButton).submit();
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(submittedEmail));
    }

    public MyAccountPage submitLoginAction(String email,String password) {
        checkPageTitle();
        setEmail(email);
        submitEmail();
        setPassword(password);
        driver.findElement(submitPasswordButton).submit();
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".welcome-container")));
        return myAccountPage = new MyAccountPage(driver);
    }

}
