package com.seleniun.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemoveElements extends Page{
    @FindBy(xpath = "//button[@onclick=\"addElement()\"]")
    private WebElement addElementButton;

    @FindBy(xpath = "//div[@id=\"elements\"]//button[@onclick=\"deleteElement()\"]")
    private List<WebElement> deleteElementButtonList;

    public AddRemoveElements() {
        super("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void addElement(){
        addElementButton.click();
    }
    
    public void removeAllElements(){
        for (WebElement deleteButton: deleteElementButtonList) {
            deleteButton.click();
        }
    }
}
