package com.solvd.pages.android;

import com.solvd.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.solvd.pages.Utils.waitForElementsListNotEmpty;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView")
    private List<ExtendedWebElement> visibleProductTitlesAndDescriptions;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean checkIfVisibleInCart(String product) {
        waitForElementsListNotEmpty(getDriver(), visibleProductTitlesAndDescriptions, 2);
        for(ExtendedWebElement element : visibleProductTitlesAndDescriptions) {
            if(element.getText().equals(product)) {
                return true;
            }
        }
        return false;
    }
}
