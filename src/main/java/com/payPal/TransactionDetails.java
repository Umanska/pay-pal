package com.payPal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TransactionDetails {
    protected WebDriver driver;
    static String PAGE_TITLE = "PayPal: Transaction Details";

    public TransactionDetails(WebDriver driver) {
        By pageContent = By.className("td-fullpage-container");
        if ((new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(pageContent)) != null) {
            this.driver = driver;
        }
    }

    public void checkPageTitle() {
        Assert.assertEquals(PAGE_TITLE,driver.getTitle());
    }

    public void checkLastCreditCardNumbers() {
        String expectedCrdNumbers = "x-1802";
        WebElement lastCreditCardNumbers = driver.findElement(By.cssSelector("dl .paid-with-section span[dir='ltr']"));
        Assert.assertEquals(expectedCrdNumbers,lastCreditCardNumbers.getText());
    }

    public void checkPaidWithSection(String expectedSum) {
        WebElement sumInPaidWithSection = driver.findElement(By.cssSelector("div .funding-source-item .funding-source-right-col span"));
        Assert.assertEquals(expectedSum,sumInPaidWithSection.getText());
    }

    public void checkTotalSum(String expectedSum) {
        WebElement sumInTotalSection = driver.findElement(By.cssSelector(".purchaseDetailFields #td_itemTotal+div .primary"));
        Assert.assertEquals(expectedSum,sumInTotalSection.getText());
    }

    public void checkPurchaseAmount(String expectedSum) {
        WebElement sumInPurchaseAmountSection = driver.findElement(By.cssSelector("#td_purchaseDetailsSeller+dd .numeral .ppvx_text--sm"));
        Assert.assertEquals(expectedSum,sumInPurchaseAmountSection.getText());
    }

    public void checkTransactionAmount(String expectedSum) {
        String sumInTransactionAmountSection = driver.findElement(By.cssSelector(".transactionNetAmount")).getAttribute("innerText");
        Pattern pattern = Pattern.compile("\\"+expectedSum);
        Matcher matcher = pattern.matcher(sumInTransactionAmountSection);
        Assert.assertTrue(matcher.find());
    }
}
