package com.solvd.pages.android;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.solvd.pages.Utils.waitForElementsListNotEmpty;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    @FindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private List<ExtendedWebElement> visiblePrices;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
    private ExtendedWebElement sortAscendingOption;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Price (high to low)\"]")
    private ExtendedWebElement sortDescendingOption;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
    private List<ExtendedWebElement> visibleAddButtons;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement cartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean checkIfTitleDisplayed() {
        return title.isElementPresent();
    }

    @Override
    public boolean checkIfPricesAscend() {
        Float reference = null;
        float price;
        for (ExtendedWebElement element : visiblePrices) {
            price = Float.parseFloat(element.getText().substring(1));
            if (reference != null) {
                if (reference.compareTo(price) > 0) {
                    return false;
                }
            }
            reference = price;
        }
        return true;
    }

    @Override
    public boolean checkIfPricesDescend() {
        Float reference = null;
        float price;
        for (ExtendedWebElement element : visiblePrices) {
            price = Float.parseFloat(element.getText().substring(1));
            if (reference != null) {
                if (reference.compareTo(price) < 0) {
                    return false;
                }
            }
            reference = price;
        }
        return true;
    }

    @Override
    public void sortPricesAsc() {
        sortButton.click();
        sortAscendingOption.click();
    }

    @Override
    public void sortPricesDesc() {
        sortButton.click();
        sortDescendingOption.click();
    }

    @Override
    public void addProduct(int index) {
        waitForElementsListNotEmpty(getDriver(), visibleAddButtons, 2);
        visibleAddButtons.get(index).click();
    }

    @Override
    public CartPageBase clickCart() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }
}
