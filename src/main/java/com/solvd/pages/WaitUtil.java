package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class WaitUtil {
    protected static final Logger logger = LoggerFactory.getLogger(WaitUtil.class);
    public static final int WAIT_POLL_INTERVAL_MS = 3000;
    public static void waitUntilListIsPresent(final WebDriver driver, final List<? extends ExtendedWebElement> elements, int waitTimeoutSec) {
        try {
            logger.debug("Waiting for elements list to be not empty and at least one element to be present");
            new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSec), Duration.ofMillis(WAIT_POLL_INTERVAL_MS))
                    .ignoring(WebDriverException.class)
                    .until(d -> !elements.isEmpty() && elements.get(0).isElementPresent(1));
            logger.debug("Elements list is ready with at least one visible element");
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements list is empty or contains no visible elements within timeout");
        }

    }


}
