package com.seleniun.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(WebDriverHelper.getChromeDriver(), Duration.ofMillis(45000L));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
    }

    public static WebElement waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(WebDriverHelper.getChromeDriver(), Duration.ofMillis(45000L));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
