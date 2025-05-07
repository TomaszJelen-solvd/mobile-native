package com.solvd;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends AbstractTest{
    @Test
    public void testSortAsc() {
        driver = getDriver();
        LoginPageBase loginPage = initPage(driver, LoginPageBase.class);

        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        ProductPageBase productPage = loginPage.clickLogin();

        productPage.sortPricesAsc();
        Assert.assertTrue(productPage.checkIfPricesAscend(), "Visible prices aren't sorted ascending");
    }

    @Test
    public void testSortDesc() {
        driver = getDriver();
        LoginPageBase loginPage = initPage(driver, LoginPageBase.class);

        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        ProductPageBase productPage = loginPage.clickLogin();

        productPage.sortPricesDesc();
        Assert.assertTrue(productPage.checkIfPricesDescend(), "Visible prices aren't sorted descending");
    }
}
