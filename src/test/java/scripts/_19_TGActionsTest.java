package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _19_TGActionsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);
    }

    /**
     * TEST CASE 1
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"
     * Perform a right-click action on the second web element labeled "Right-Click on me"
     * Verify that the message appears next to the element stating, "You right-clicked on a button!"
     * Perform a double click action on the third web element labeled "Double-Click on me"
     * Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */

    @Test
    public void validateMouseActions(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://techglobal-training.com/frontend/actions");

        WebElement clickOnMeBtn = driver.findElement(By.id("click"));
        WebElement rightClickOnMeBtn = driver.findElement(By.id("right-click"));
        WebElement doubleClickOnMeBtn = driver.findElement(By.id("double-click"));

        Assert.assertTrue(clickOnMeBtn.isDisplayed());
        Assert.assertEquals(clickOnMeBtn.getText(), "Click on me");

        Assert.assertTrue(rightClickOnMeBtn.isDisplayed());
        Assert.assertEquals(rightClickOnMeBtn.getText(), "Right-Click on me");

        Assert.assertTrue(doubleClickOnMeBtn.isDisplayed());
        Assert.assertEquals(doubleClickOnMeBtn.getText(), "Double-Click on me");

        actions.moveToElement(clickOnMeBtn).click().perform();
        WebElement resultOfClick = driver.findElement(By.id("click_result"));
        Assert.assertEquals(resultOfClick.getText(), "You clicked on a button!");

        actions.moveToElement(rightClickOnMeBtn).contextClick().perform();
        WebElement resultOfRightClick = driver.findElement(By.id("right_click_result"));
        Assert.assertEquals(resultOfRightClick.getText(), "You right-clicked on a button!");

        actions.moveToElement(doubleClickOnMeBtn).doubleClick().perform();
        WebElement resultOfDoubleClick = driver.findElement(By.id("double_click_result"));
        Assert.assertEquals(resultOfDoubleClick.getText(), "You double-clicked on a button!");

    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the web element stating, "An element dropped here!"
     */

    @Test
    public void validateDragAndDrop(){
        WebElement dragMe = driver.findElement(By.id("drag_element"));
        WebElement dropMe = driver.findElement(By.id("drop_element"));

        Assert.assertEquals(dragMe.getText(), "Drag Me");
        Assert.assertEquals(dropMe.getText(), "Drop Here");

        actions.moveToElement(dragMe).clickAndHold().moveToElement(dropMe).release().perform();

        WebElement resultOfDragAndDrop = driver.findElement(By.id("drag_and_drop_result"));
        Waiter.waitForVisibilityOfElement(resultOfDragAndDrop, 30);
        Assert.assertEquals(resultOfDragAndDrop.getText(), "An element dropped here!");

    }

    /**
     * TEST CASE 3
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box, and remove if there is an existing text inside
     * First, enter “h” to the input box in upper case using keyboard actions
     * Then complete the word by sending “ello” as a key
     * Validate value attribute of the input box is “Hello”
     */
    @Test
    public void validateKeyBoardAction(){
        WebElement inputBox = driver.findElement(By.id("input_box"));
        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox, "h")
                .keyUp(Keys.SHIFT)
                .sendKeys("ello")
                .perform();
        Waiter.pause(5);
        Assert.assertEquals(inputBox.getAttribute("value"), "Hello");
    }

    /**
     * TEST CASE 4
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box, and remove if there is an existing text inside
     * Enter “techglobal” to input the box with uppercases
     * Then, copy the text and paste it again
     * Validate the value attribute for the search input box is “TECHGLOBALTECHGLOBAL”
     */

    @Test
    public void validateTechGlobalEntry(){
        WebElement inputBox = driver.findElement(By.id("input_box"));

        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("acvv")
                .perform();

        Assert.assertEquals(inputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");
    }
}
