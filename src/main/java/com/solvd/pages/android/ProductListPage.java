package com.solvd.pages.android;

import com.solvd.pages.SortType;
import com.solvd.pages.android.components.FilterComponent;
import com.solvd.pages.android.components.MenuComponent;
import com.solvd.pages.android.components.ProductListItemComponent;
import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;

import static com.solvd.pages.WaitUtil.waitUntilListIsPresent;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase {

    public static final int WAIT_TIMEOUT_SEC = 2;

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement title;

    @AndroidFindBy(accessibility = "test-Item")
    private List<ProductListItemComponent> items;

    @AndroidFindBy(accessibility = "test-Toggle")
    private ExtendedWebElement toggleButton;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private ExtendedWebElement filterButton;

    @AndroidFindBy(accessibility = "Selector container")
    private FilterComponent filterOptions;

    @AndroidFindBy(accessibility = "test-Menu")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]")
    private MenuComponent menuOptions;

    @AndroidFindBy(accessibility = "test-Cart")
    private ExtendedWebElement cartButton;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitlePresent() {
        return title.isElementPresent();
    }

    @Override
    public boolean verifyProductSortingByPrice(SortType sortType) {
        waitUntilListIsPresent(getDriver(), items, WAIT_TIMEOUT_SEC);
        BigDecimal reference = null;
        BigDecimal price;
        for (ProductListItemComponent item : items) {
            price = new BigDecimal(item.getPrice().substring(1));
            if (reference != null) {
                if (sortType.isAscending()) {
                    if (reference.compareTo(price) > 0) {
                        return false;
                    }
                } else {
                    if (reference.compareTo(price) < 0) {
                        return false;
                    }
                }
            }
            reference = price;
        }
        return true;
    }

    @Override
    public void toggleView() {
        toggleButton.click();
    }

    @Override
    public void sortPrices(SortType sortType) {
        filterButton.click();
        filterOptions.sortPrices(sortType);
    }

    @Override
    public DrawingPageBase clickDrawingOption() {
        menuButton.click();
        return menuOptions.clickDrawingOption();
    }

    @Override
    public LoginPageBase logout() {
        menuButton.click();
        return menuOptions.logout();
    }

    @Override
    public void addProductToCart(String name) {
        waitUntilListIsPresent(getDriver(), items, WAIT_TIMEOUT_SEC);
        for (ProductListItemComponent item : items) {
            if (item.getProductTitle().equals(name)) {
                item.addProduct();
            }
        }
    }

    @Override
    public void removeProductFromCart(String name) {
        waitUntilListIsPresent(getDriver(), items, WAIT_TIMEOUT_SEC);
        for (ProductListItemComponent item : items) {
            if (item.getProductTitle().equals(name)) {
                item.removeProduct();
            }
        }
    }

    @Override
    public CartPageBase openCart() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public boolean isProductDescriptionPresent() {
        waitUntilListIsPresent(getDriver(), items, WAIT_TIMEOUT_SEC);
        return items.get(0).isDescriptionPresent();
    }
}
