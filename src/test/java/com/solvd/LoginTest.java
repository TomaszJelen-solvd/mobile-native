package com.solvd;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTest extends BaseTest {
    //TC001
    @Test (dataProvider = "data-provider")
    public void testLoginUser(String name, String password) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login(name, password);
        Assert.assertTrue(productPage.isTitlePresent(), "Failed to display product page title");
    }

    //TC002
    @Test (dataProvider = "data-provider")
    public void testInvalidLogin(String name, String password) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login(name, password);
        Assert.assertTrue(loginPage.isErrorMessagePresent(), "Failed to display error");
        Assert.assertEquals(loginPage.getErrorText(), "Username and password do not match any user in this service.", "Wrong error message");
    }

    //TC010
    @Test (dataProvider = "data-provider")
    public void testLockedOutLogin(String name, String password) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login(name, password);
        Assert.assertTrue(loginPage.isErrorMessagePresent(), "Failed to display error");
        Assert.assertEquals(loginPage.getErrorText(), "Sorry, this user has been locked out.", "Wrong error message");
    }

    //TC007
    @Test (dataProvider = "data-provider")
    public void testLogoutUser(String name, String password) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login(name, password);
        loginPage = productPage.logout();
        Assert.assertTrue(loginPage.isLoginPresent(), "Failed to display login page");
    }

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod (Method m){
        switch (m.getName()) {
            case "testInvalidLogin":
                return new Object[][] {{"aaa", "aaa"}};
            case "testLockedOutLogin":
                return new Object[][] {{"locked_out_user","secret_sauce"}};
        }
        return new Object[][] {{"standard_user", "secret_sauce"}};
    }
}
