package com.seleniun.L5HW_selenium;

import com.seleniun.core.WebDriverHelper;
import com.seleniun.herokuapp.pages.AddRemoveElements;
import com.seleniun.herokuapp.pages.FileUploader;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class L5HWTest {
    private AddRemoveElements addRemoveElements;
    private FileUploader fileUploader;

    @BeforeSuite
    public void setUp() {
        addRemoveElements = new AddRemoveElements();
        fileUploader = new FileUploader();
    }
    @Test
    public void  addRemoveElements(){
        addRemoveElements.navigate();
        addRemoveElements.addElement();
        addRemoveElements.addElement();
        addRemoveElements.removeAllElements();
    }

    @DataProvider(name = "testFiles")
    public Object[][] testFiles() {
        return new Object[][]{
                {"cat.jpg"},
                {"pw.png"},
        };
    }

    @Test(dataProvider = "testFiles")
    public void chooseFile(String fileName){
        File file = new File(Paths.get("src/main/resources/files", fileName).toString());
        fileUploader.navigate();
        String nameFile = fileUploader.chooseFile(file.getAbsolutePath());
        assert nameFile.equals("C:\\fakepath\\"+fileName);
    }

    @Test(dataProvider = "testFiles")
    public void dragAndDropFile(String fileName) throws AWTException, InterruptedException {
        File file = new File(Paths.get("src/main/resources/files", fileName).toString());
        fileUploader.navigate();
        fileUploader.dragAndDrop(file);
        assert fileUploader.grabDragAndDropFileName().equals(fileName);
    }

    @AfterSuite
    public void tearDown() {
        WebDriverHelper.getChromeDriver().close();
        WebDriverHelper.getChromeDriver().quit();
    }
}
