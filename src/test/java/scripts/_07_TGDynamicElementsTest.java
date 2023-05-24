package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class _07_TGDynamicElementsTest extends Base{
    /*
    TEST CASE 1
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate both boxes are displayed with the below texts
    Box 1
         */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-3")).click();
    }

    @Test
    public void validateBox1(){
//        WebElement dynamicBoxElement = driver.findElement(By.id("card-3"));
//        dynamicBoxElement.click();

        WebElement boxElement = driver.findElement(By.cssSelector("p[id^='box_1']"));

        Assert.assertTrue(boxElement.isDisplayed());
        Assert.assertEquals(boxElement.getText(), "Box 1");

    }

    /*
    TEST CASE 2
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate box2 is displayed with the below texts
    Box 2
     */

    @Test
    public void validateBox2(){
        WebElement box2 = driver.findElement(By.cssSelector("p[id^='box_2"));
        Assert.assertTrue(box2.isDisplayed());
        Assert.assertEquals(box2.getText(), "Box 2");
    }

    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate that both boxes are displayed with the below texts
    Box 1, Box 2
    techglobal-training.comtechglobal-training.com
    Techglobal Training | Home
    Practice your automation skills
     */

    @Test
    public void validateDynamicBoxElements(){
        List<WebElement> boxList = driver.findElements(By.xpath("//p[contains(text(), 'Box')]"));

        String[] expectedText = {"Box 1", "Box 2"};
        for (int i = 0; i < boxList.size(); i++) {
            Assert.assertTrue(boxList.get(i).isDisplayed());
            Assert.assertEquals(boxList.get(i).getText(), expectedText[i]);
        }
    }
}
