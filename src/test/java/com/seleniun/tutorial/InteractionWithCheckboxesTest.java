package com.seleniun.tutorial;

import com.seleniun.core.WebDriverHelper;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class InteractionWithCheckboxesTest {

    @Test
    public void  checkCheckboxes() throws InterruptedException{


        WebDriver driver = WebDriverHelper.getChromeDriver();

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox = driver.findElement(By.tagName("input"));
        checkBox.click();
        Thread.sleep(5000);

        driver.navigate().to("https://formy-project.herokuapp.com/checkbox");
        List<WebElement> checkboxes =driver.findElements(By.tagName("input"));
        Thread.sleep(5000);
        for (WebElement c: checkboxes){
            c.click();
            Thread.sleep(5000);
        }
        for (WebElement c: checkboxes){
            c.click();
            Thread.sleep(5000);
        }

        driver.quit();

    }
}
