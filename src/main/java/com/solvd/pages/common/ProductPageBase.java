package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends PageBase{
    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkIfTitleDisplayed();

    public abstract boolean checkIfPricesAscend();

    public abstract boolean checkIfPricesDescend();

    public abstract void sortPricesAsc();

    public abstract void sortPricesDesc();

    public abstract void addProduct(int index);

    public abstract CartPageBase clickCart();
}
