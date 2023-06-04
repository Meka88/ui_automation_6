package scripts;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _13_IFrameTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/iframes");
    }

    /*
   TEST CASE
   Go to https://techglobal-training.com/frontend/iframes
   Validate the "Please fill out your information below" paragraph
    */
    @Test(priority = 1, description = "Test case #: title of the test case")
    public void validateTheParagraph(){
        // switching to iFrame one way
        //locate iFrame
        WebElement iFrame = driver.findElement(By.id("form_frame"));
        // need to switch to iframe
        driver.switchTo().frame(iFrame);

        // second way by index
        //driver.switchTo().frame(0);
        // third way by id or name
        //driver.switchTo().frame("form_name");


        WebElement formParagraph = driver.findElement(By.cssSelector("#name_form>p"));

        Assert.assertTrue(formParagraph.isDisplayed());
        Assert.assertEquals(formParagraph.getText(), "Please fill out your information below");
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/iframes
    Enter name as "John"
    Enter last name as "Doe"
    Click on "SUBMIT" button
    Validate that the Result is "You entered: John Doe"
     */
    @Test(priority = 2, description = "TC345 Validate the form submission")
    public void validateTheFormSubmission(){
        WebElement iFrame = driver.findElement(By.id("form_frame"));
        driver.switchTo().frame(iFrame);

        WebElement nameInput = driver.findElement(By.id("first_name"));
        nameInput.sendKeys("John");
        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        lastNameInput.sendKeys("Doe");
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.submit();
        driver.switchTo().parentFrame();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(), "You entered: John Doe");
    }
}
