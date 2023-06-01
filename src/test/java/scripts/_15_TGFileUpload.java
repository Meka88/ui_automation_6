package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _15_TGFileUpload extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-13")).click();
    }

    @Test
    public void validateUploadButton(){
        WebElement fileUploadInput = driver.findElement(By.id("file_upload"));
        WebElement uploadBtn = driver.findElement(By.id("file_submit"));

        String file = "someFile";
        fileUploadInput.sendKeys(file);
        uploadBtn.click();
        Waiter.pause(5);
    }

    /**
     * Note: create .txt file "hello.txt" in the root of the project
     * TEST CASE
     * Go to https://techglobal-training.com/frontend/
     * Click on the "File Upload" card
     * Send the path of the file as keys to the "Choose File" input box
     * Click on the "UPLOAD" button
     * Validate the result message equals "You Uploaded 'hello.txt'"
     */

    @Test
    public void validateFileUpload(){
        WebElement uploadInputBox = driver.findElement(By.id("file_upload"));
        WebElement uploadSubmitBtn = driver.findElement(By.id("file_submit"));

        String filePath = "C:\\Users\\mekab\\IdeaProjects\\ui_automation_6\\hello.txt";
        String fileName = filePath.substring(filePath.lastIndexOf('\\') + 1);
        uploadInputBox.sendKeys(filePath);
        uploadSubmitBtn.click();
        Waiter.pause(3);
        WebElement message = driver.findElement(By.id("result"));

        Assert.assertEquals(message.getText(), "You Uploaded '"+ fileName + "'");
    }

}
