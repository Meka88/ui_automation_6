package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _12_TGAlertsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-8")).click();
    }


    /**
     * WARNING ALERT
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Alerts" card
     * Click on the "Warning alert" button
     * Validate the alert text equals "You are on TechGlobal Training application."
     * Click on the "OK" button on the alert
     * Validate the result message equals "You accepted warning by clicking OK."
     */

    @Test
    public void validateWarningAlert(){
        WebElement warningAlert = driver.findElement(By.id("warning_alert"));
        warningAlert.click();
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "You are on TechGlobal Training application.");

        alert.accept();
        WebElement message = driver.findElement(By.id("action"));
        Assert.assertEquals(message.getText(), "You accepted warning by clicking OK.");
    }

    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Alerts" card
    Click on the "Confirmation alert" button
    Validate the alert text equals "Would you like to stay on TechGlobal Training application?"
    Click on the "Cancel" button on the alert
    Validate the result message equals "You rejected the alert by clicking Cancel."
    Click on the "Confirmation alert" button again
    Click on the "OK" button on the alert
    Validate the result message equals "You confirmed the alert by clicking OK."
     */

    @Test
    public void validateConfirmationAlert(){
        WebElement confirmationAlert = driver.findElement(By.cssSelector("#confirmation_alert"));
        confirmationAlert.click();

        Alert alertDenied = driver.switchTo().alert();
        Assert.assertEquals(alertDenied.getText(), "Would you like to stay on TechGlobal Training application?");
        alertDenied.dismiss();

        WebElement rejectMessage = driver.findElement(By.id("action"));
        Assert.assertEquals(rejectMessage.getText(), "You rejected the alert by clicking Cancel.");

        confirmationAlert.click();
        Alert alertAccept = driver.switchTo().alert();
        Assert.assertEquals(alertAccept.getText(), "Would you like to stay on TechGlobal Training application?");
        alertAccept.accept();

        WebElement confirmationMessage = driver.findElement(By.id("action"));
        Assert.assertEquals(confirmationMessage.getText(), "You confirmed the alert by clicking OK.");
    }

    /*
    PROMPT ALERT
    Go to https://techglobal-training.com/frontend/
    Click on the "Alerts" card
    Click on the "Prompt alert" button
    Validate the alert text equals "What would you like to say to TechGlobal?"
    Click on the "Cancel" button on the alert
    Validate the result message equals "You rejected the alert by clicking Cancel."
    Click on the "Prompt alert" button again
    Click on the "OK" button on the alert
    Validate the result message equals "You entered "" in the alert and clicked OK."
    Click on the "Prompt alert" button again
    Enter "Hello" to alert the input box
    Click on the "OK" button on the alert
    Validate the result message equals "You entered "Hello" in the alert and clicked OK."
     */
    @Test
    public void validatePromptAlert(){
        WebElement promptAlert = driver.findElement(By.id("prompt_alert"));
        promptAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement message = driver.findElement(By.id("action"));
        Assert.assertEquals(message.getText(), "You rejected the alert by clicking Cancel.");

        promptAlert.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        WebElement message1 = driver.findElement(By.id("action"));
        Assert.assertEquals(message.getText(), "You entered \"\" in the alert and clicked OK.");

        promptAlert.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Hello");
        alert2.accept();

        WebElement message2 = driver.findElement(By.id("action"));
        Assert.assertEquals(message.getText(), "You entered \"Hello\" in the alert and clicked OK.");
    }
}
