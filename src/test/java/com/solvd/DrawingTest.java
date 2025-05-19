package com.solvd;

import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrawingTest extends BaseTest {

    @Test
    public void testDrawingLine() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productPage = loginPage.login("standard_user", "secret_sauce");

        DrawingPageBase drawingPage = productPage.openDrawingPage();
        drawingPage.drawLine();
        Assert.assertTrue(drawingPage.isHorizontalLinePresent(), "Failed to find drawn line");
    }
}
