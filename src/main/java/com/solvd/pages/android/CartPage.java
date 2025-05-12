package com.solvd.pages.android;

import com.solvd.pages.android.components.CartItemComponent;
import com.solvd.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.solvd.pages.WaitUtil.waitUntilListIsPresent;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    public static final int WAIT_TIMEOUT_SEC = 3;
    @AndroidFindBy(accessibility = "test-Item")
    private List<CartItemComponent> items;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductVisibleInCart(String product) {
        waitUntilListIsPresent(getDriver(), items, WAIT_TIMEOUT_SEC);
        for (CartItemComponent item : items) {
            if (item.getProductTitle().equals(product)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return items.isEmpty();
    }
}
