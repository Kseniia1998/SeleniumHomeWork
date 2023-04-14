package com.seleniun.herokuapp.pages;

import com.seleniun.core.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileUploader extends Page {

    @FindBy(id = "file-upload")
    private WebElement chooseFile;
    @FindBy(id = "drag-drop-upload")
    private WebElement dropZone;

    @FindBy(xpath = "//div[@id=\"drag-drop-upload\"]//span[@data-dz-name]")
    private WebElement dragDropFile;

    public FileUploader() {
        super("https://the-internet.herokuapp.com/upload");
    }

    public String chooseFile(String filePath) {
        chooseFile.sendKeys(filePath);
        return chooseFile.getAttribute("value");
    }

    public void dragAndDrop(File file) throws AWTException, InterruptedException {

        String absoluteFilePath = file.getAbsolutePath();
        String directoryPath = file.getAbsolutePath().replace(file.getName(), "");

        Robot robot = new Robot();
        dropZone.click();
        Thread.sleep(1500);
        StringSelection directory = new StringSelection(directoryPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(directory, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        StringSelection absPath = new StringSelection(absoluteFilePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(absPath, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public String grabDragAndDropFileName(){
        Utils.waitForElementVisible(dragDropFile);
        return dragDropFile.getText();
    }
}
