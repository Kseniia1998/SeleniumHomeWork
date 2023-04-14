package com.seleniun.herokuapp.pages;

import com.seleniun.core.Utils;
import com.seleniun.core.WebDriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public abstract class Page {
    private final WebDriver driver;
    private final String url;

    public Page(String url) {
        this.driver = WebDriverHelper.getChromeDriver();
        PageFactory.initElements(driver, this);
        this.url = url;
    }

    public void  navigate(){
        driver.get(url);
        this.pageLoaded();
    }

    public void pageLoaded(){
        Utils.waitForPageLoaded();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
