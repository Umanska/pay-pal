package com.payPal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TransactionTest extends BaseTests {

    static String EMAIL = "";//enter your test personal account email in https://www.sandbox.paypal.com/
    static String PASSWORD = "";//enter your test personal account password
    String expectedPurchaseAmount = "$100.00";//change to your amount of the last transaction
    MyAccountPage myCurrentAccountPage;
    TransactionDetails transactionDetails;

    @Before
    public void getNewChrome() {
        setUp();
    }

    @Test
    public void transactionCheck() {
        myCurrentAccountPage = loginPage.submitLoginAction(EMAIL,PASSWORD);
        transactionDetails = myCurrentAccountPage.navigateToPaymentDetails();
        transactionDetails.checkPageTitle();
        transactionDetails.checkLastCreditCardNumbers();
        transactionDetails.checkPaidWithSection(expectedPurchaseAmount);
        transactionDetails.checkPurchaseAmount(expectedPurchaseAmount);
        transactionDetails.checkTotalSum(expectedPurchaseAmount);
        transactionDetails.checkTransactionAmount(expectedPurchaseAmount);
    }

    @After
    public void closeChrome() {
        tearDown();
    }
}