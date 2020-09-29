package com.payPal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
    protected TransactionDetails transactionDetails;
    protected WebDriver driver;
    private By welcomeElement = By.cssSelector(".welcome-container");
    private By logOutButton = By.cssSelector("#header-logout[href='/signout']");
    private By recentPayment = By.xpath("//a[.//p[contains(text(),' -$100.00')]]");
    private String welcomeText = "Hello, John";

    public MyAccountPage(WebDriver driver) {
            this.driver = driver;
    }

    public boolean checkWelcomeSign() {
        return driver.findElement(welcomeElement).getText().equals(welcomeText);
    }

    public boolean existLogOutButton() {
        return driver.findElement(logOutButton).isDisplayed();
    }

    public TransactionDetails navigateToPaymentDetails() {
        if(checkWelcomeSign()&& existLogOutButton()){
        driver.findElement(recentPayment).click();
        }
        return transactionDetails = new TransactionDetails(driver);
    }
}
