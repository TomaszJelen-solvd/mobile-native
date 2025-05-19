package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends PageBase {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductVisibleInCart(String product);

    public abstract boolean isItemListEmpty();
}
