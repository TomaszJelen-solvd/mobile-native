package com.solvd;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductListPageBase;
import com.solvd.service.LoginCredentials;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.solvd.service.LoginCredentials.*;

public class LoginTest extends BaseTest {

    //TC002, TC010 and TC001
    @Test(dataProvider = "loginData")
    public void testLoginDifferentUsers(LoginCredentials credentials) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login(credentials.getName(), credentials.getPassword());
        if (credentials.getErrorText() == null) {
            Assert.assertTrue(productPage.isTitlePresent(), "Failed to display product page title");
        } else {
            Assert.assertTrue(loginPage.isErrorMessagePresent(), "Failed to display error");
            Assert.assertEquals(loginPage.getErrorText(), credentials.getErrorText(), "Wrong error message");
        }
    }

    //TC007
    @Test
    public void testLogoutUser() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login("standard_user", "secret_sauce");
        loginPage = productPage.logout();
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Failed to display login page");
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {STANDARD_USER},
                {USER_INVALID_CREDENTIALS},
                {USER_LOCKED_OUT_CREDENTIALS}
        };
    }
}
