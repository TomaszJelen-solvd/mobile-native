package com.solvd.pages.common;

import java.util.List;
import com.solvd.pages.SortType;
import org.openqa.selenium.WebDriver;

public abstract class ProductListPageBase extends PageBase {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();

    public abstract boolean isProductListSortedByPrice(SortType ascending);

    public abstract void clickToggleViewButton();

    public abstract void sortPrices(SortType sortType);

    public abstract DrawingPageBase openDrawingPage();

    public abstract LoginPageBase logout();

    public abstract void addProductToCart(String name);

    public void addProductsToCart(List<String> names) {
        for (String name : names) {
            addProductToCart(name);
        }
    }

    public abstract void removeProductFromCart(String name);

    public abstract CartPageBase openCart();

    public abstract boolean isProductDescriptionPresent();
}
