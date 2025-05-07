package com.solvd;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.solvd.ProductService.SAUCE_LABS_BACKPACK;

public class CartTest extends AbstractTest{
    @Test
    public void testAddProductInCart() {
        driver = getDriver();
        LoginPageBase loginPage = initPage(driver, LoginPageBase.class);

        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        ProductPageBase productPage = loginPage.clickLogin();

        productPage.addProduct(SAUCE_LABS_BACKPACK.getIndex());
        CartPageBase cartPage = productPage.clickCart();
        Assert.assertTrue(cartPage.checkIfVisibleInCart(SAUCE_LABS_BACKPACK.getName()), "Failed to display added product in cart");
    }
}
