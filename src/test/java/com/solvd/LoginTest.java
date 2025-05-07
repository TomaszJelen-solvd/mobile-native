package com.solvd;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest{
    @Test
    public void testCorrectLogin() {
        LoginPageBase loginPage = initPage(driver, LoginPageBase.class);

        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        ProductPageBase productPage = loginPage.clickLogin();
        Assert.assertTrue(productPage.checkIfTitleDisplayed(), "Failed to display product page title");
    }

    @Test
    public void testInvalidLogin() {
        LoginPageBase loginPage = initPage(driver, LoginPageBase.class);

        loginPage.enterName("aaa");
        loginPage.enterPassword("aaa");
        loginPage.clickLoginExpectingError();
        Assert.assertTrue(loginPage.checkIfErrorDisplayed(), "Failed to display error");
        Assert.assertEquals(loginPage.getErrorText(), "Username and password do not match any user in this service.", "Wrong error message");
    }
}
