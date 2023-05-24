package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _08_TGWaitTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-4")).click();
    }

    /*
    TEST CASE 1
Go to https://techglobal-training.com/frontend/
Click on the "Waits" card
Click on the "Click on me to see a red box" button
Validate that a red box is displayed
     */
    @Test
    public void validateWaitForRedBox(){
        WebElement clickOnRedBox = driver.findElement(By.id("red"));
        clickOnRedBox.click();
        WebElement redBox = driver.findElement(By.cssSelector("button[class*='red_box']"));
        Assert.assertTrue(redBox.isDisplayed());
    }

    @Test
    public void validateWaitForBlueBox(){
        WebElement clickOnBlueBox = driver.findElement(By.id("blue"));
        clickOnBlueBox.click();
        WebElement blueBox = driver.findElement(By.cssSelector("button[class*='blue_box']"));
        Waiter.waitForVisibilityOfElement(blueBox, 40);

        Assert.assertTrue(blueBox.isDisplayed());
    }

}
