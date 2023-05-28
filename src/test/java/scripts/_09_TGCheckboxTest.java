package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _09_TGCheckboxTest extends Base{

    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Checkboxes" card
    Validate "Apple" and "Microsoft" checkboxes are displayed, enabled, and not selected
    Select both and validate they are both selected
    Deselect both and validate they are deselected
     */
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-7")).click();
    }

    @Test
    public void validateCheckboxes(){

        List<WebElement> checkboxLabelSet = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        List<WebElement> checkboxInputSet = driver.findElements(By.cssSelector("#checkbox-button-group_1 input"));

        //String[] expectedResult = {"Apple", "Microsoft"};

        checkboxInputSet.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

        for (int i = 0; i < checkboxLabelSet.size(); i++) {
            checkboxLabelSet.get(i).click();
            Assert.assertTrue(checkboxInputSet.get(i).isSelected());
        }
    }

    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Checkboxes" card
    Validate "Tesla" and "SpaceX" checkboxes are displayed, enabled, and not selected
    Select both and validate they are both selected
    Deselect both and validate they are deselected
     */
    @Test
    public void validateCheckboxes2(){
        List<WebElement> checkboxLabelList = driver.findElements(By.cssSelector("#checkbox-button-group_2 label"));
        List<WebElement> checkboxInputList = driver.findElements(By.cssSelector("#checkbox-button-group_2 input"));

        for (WebElement cBox : checkboxInputList) {
            Assert.assertTrue(cBox.isDisplayed());
            Assert.assertFalse(cBox.isSelected());
            Assert.assertTrue(cBox.isEnabled());
        }

        for (int i = 0; i < checkboxLabelList.size(); i++) {
            checkboxLabelList.get(i).click();
            Assert.assertTrue(checkboxInputList.get(i).isSelected());
        }

        for (int i = 0; i < checkboxLabelList.size(); i++) {
            checkboxLabelList.get(i).click();
            Assert.assertFalse(checkboxInputList.get(i).isSelected());
        }
    }




}
