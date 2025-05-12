package com.solvd.pages.common;

import java.util.List;
import com.solvd.pages.SortType;
import org.openqa.selenium.WebDriver;

public abstract class ProductListPageBase extends PageBase {
    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();

    public abstract boolean verifyProductSortingByPrice(SortType ascending);

    public abstract void toggleView();

    public abstract void sortPrices(SortType sortType);

    public abstract DrawingPageBase clickdrawingOption();

    public abstract LoginPageBase logout();

    public abstract void addProductToCart(String name);

    public void addProductsToCart(List<String> names) {
        for (String name : names) {
            addProductToCart(name);
        }
    }

    public abstract void removeProduct(String name);

    public abstract CartPageBase openCart();

    public abstract boolean isProductDescriptionPresent();
}
