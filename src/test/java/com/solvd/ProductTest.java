package com.solvd;

import com.solvd.pages.SortType;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    //TC003
    @Test
    public void testProductSortInAscendingOrder() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.sortPrices(SortType.PRICE_LOW_TO_HIGH);
        Assert.assertTrue(productPage.isProductListSortedByPrice(SortType.PRICE_LOW_TO_HIGH), "Visible prices aren't sorted properly");
    }

    //TC004
    @Test
    public void testProductSortInDescendingOrder() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.sortPrices(SortType.PRICE_HIGH_TO_LOW);
        Assert.assertTrue(productPage.isProductListSortedByPrice(SortType.PRICE_HIGH_TO_LOW), "Visible prices aren't sorted properly");
    }

    //TC006
    @Test
    public void testToggleProductView() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.clickToggleViewButton();
        Assert.assertTrue(productPage.isProductDescriptionPresent(), "Failed to display products descriptions");
        productPage.clickToggleViewButton();
        Assert.assertFalse(productPage.isProductDescriptionPresent(), "Failed to hide products descriptions");
    }
}
