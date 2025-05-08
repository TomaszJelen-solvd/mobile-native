package com.solvd;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.solvd.service.ProductService.SAUCE_LABS_BACKPACK;
import static com.solvd.service.ProductService.SAUCE_LABS_BIKE_LIGHT;

public class CartTest extends BaseTest {
    //TC005
    @Test
    public void testAddProductInCart() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.addProduct(SAUCE_LABS_BACKPACK.getName());
        CartPageBase cartPage = productPage.openCart();
        Assert.assertTrue(cartPage.checkIfVisibleInCart(SAUCE_LABS_BACKPACK.getName()), "Failed to display added product in cart");
    }

    //TC008
    @Test
    public void testAddSeveralProductsInCart() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.addProduct(SAUCE_LABS_BACKPACK.getName());
        productPage.addProduct(SAUCE_LABS_BIKE_LIGHT.getName());

        CartPageBase cartPage = productPage.openCart();
        Assert.assertTrue(cartPage.checkIfVisibleInCart(SAUCE_LABS_BACKPACK.getName()), "Failed to display added product in cart");
        Assert.assertTrue(cartPage.checkIfVisibleInCart(SAUCE_LABS_BIKE_LIGHT.getName()), "Failed to display added product in cart");
    }

    //TC009
    @Test
    public void testAddAndRemoveProductInCart() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.addProduct(SAUCE_LABS_BACKPACK.getName());
        productPage.removeProduct(SAUCE_LABS_BACKPACK.getName());
        CartPageBase cartPage = productPage.openCart();
        Assert.assertTrue(cartPage.isEmpty(), "Failed to remove added product from cart");
    }
}
