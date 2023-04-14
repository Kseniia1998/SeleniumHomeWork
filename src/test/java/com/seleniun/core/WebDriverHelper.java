package com.seleniun.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebDriverHelper {
    private static WebDriver chromeDriver = null;

    private WebDriverHelper() {
    }

    public static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            chromeDriver = new ChromeDriver();
        }
        return chromeDriver;
    }



}
