package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _10_TGRadioButtonsTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-6")).click();
    }
    /*
    TEST CASE 1
    Go to https://techglobal-training.com/frontend/
    Click on the "Radio Buttons" card
    Validate that "Java", "JavaScript" and "C#" radio buttons are displayed, enabled, and not selected
    Select "Java" and validate it is selected but the other 2 are deselected
    Select "JavaScript" to validate it is selected but the other 2 are deselected
     */

    @Test
    public void validateRadioButtons(){
        List<WebElement> radioButtonLabelList = driver.findElements(By.cssSelector("#radio-button-group_1 label"));
        List<WebElement> radioButtonInputList = driver.findElements(By.cssSelector("#radio-button-group_1 input"));

        for (WebElement e : radioButtonInputList) {
            Assert.assertTrue(e.isDisplayed());
            Assert.assertTrue(e.isEnabled());
            Assert.assertFalse(e.isSelected());
        }
        radioButtonLabelList.get(0).click();
        Assert.assertTrue(radioButtonInputList.get(0).isSelected());

        for (int i = 1; i < radioButtonLabelList.size(); i++) {
            Assert.assertFalse(radioButtonInputList.get(i).isSelected());
        }

        radioButtonLabelList.get(1).click();
        Assert.assertTrue(radioButtonInputList.get(1).isSelected());

        for (int i = 0; i < radioButtonLabelList.size(); i++) {
            Assert.assertFalse(radioButtonInputList.get(i).isSelected());
            i +=1;
        }

    }
    /*
    TEST CASE 2
Go to https://techglobal-training.com/frontend/
Click on the "Radio Buttons" card
Validate that "Selenium", "Cypress" and "Playwright" radio buttons are displayed, enabled, and not selected
Select "Cypress" and validate it is selected but the other 2 are deselected
Select "Playwright" to validate it is selected but the other 2 are deselected
     */

    @Test
    public void validateRadioBox(){
        List<WebElement> radioBoxLabelList = driver.findElements(By.cssSelector("#radio-button-group_2 label"));
        List<WebElement> radioBoxInputList = driver.findElements(By.cssSelector("#radio-button-group_2 input"));

        for (WebElement e : radioBoxInputList) {
            Assert.assertTrue(e.isDisplayed());
            Assert.assertTrue(e.isEnabled());
            Assert.assertFalse(e.isSelected());
        }
        radioBoxLabelList.get(1).click();
        for (int i = 0; i < radioBoxLabelList.size(); i++) {
            Assert.assertFalse(radioBoxInputList.get(i).isSelected());
            i+=1;
        }
        radioBoxLabelList.get(2).click();
        for (int i = 0; i < radioBoxLabelList.size()-1; i++) {
            Assert.assertFalse(radioBoxInputList.get(i).isSelected());
        }

    }
}
