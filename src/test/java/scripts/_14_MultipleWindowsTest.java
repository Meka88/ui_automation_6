package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;
import utils.WindowHandler;
import java.util.List;

public class _14_MultipleWindowsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-10")).click();

    }

    /*
   TEST CASE
   Go to https://techglobal-training.com/frontend
   Click on "Multiple Windows" card
   Click on "Apple"
   Validate the Apple logo is displayed
    */
    @Test(priority = 1, description = "TC321: Validate the Apple navigation")
    public void validateTheAppleNavigation(){
        WebElement appleLink = driver.findElement(By.id("apple"));
        appleLink.click();
        WindowHandler.switchToChildWindow();
        WebElement appleLogo = driver.findElement(By.cssSelector(".globalnav-link-apple"));
        Assert.assertTrue(appleLogo.isDisplayed());
    }

     /*
    TEST CASE
    Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Click on "Microsoft"
    Validate the URL contains "microsoft"
     */

    @Test(priority = 2, description = "TC321: Validate the Microsoft navigation")
    public void validateMicrosoftNavigation(){
        WebElement microsoftLink = driver.findElement(By.id("microsoft"));
        microsoftLink.click();
        WindowHandler.switchToChildWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("microsoft"));
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Click on "Tesla"
    Validate the title is "Electric Cars, Solar & Clean Energy | Tesla"
    Navigate back to https://techglobal-training.com/frontend/multiple-windows
    Validate the URL contains "techglobal"
    Validate the main heading is "Multiple Windows"
     */
    @Test(priority = 3, description = "TC323 Validate the Tesla navigation")
    public void validateTeslaNavigation(){
        WebElement teslaPage = driver.findElement(By.id("tesla"));
        teslaPage.click();

        WindowHandler.switchToChildWindow();
        Assert.assertEquals(driver.getTitle(), "Electric Cars, Solar & Clean Energy | Tesla");

        WindowHandler.switchToMainWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));

        WebElement mainHeading = driver.findElement(By.id("main_heading"));
        Assert.assertEquals(mainHeading.getText(), "Multiple Windows");
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Validate the links "Apple", "Microsoft" and "Tesla" navigates user to
    "https://www.apple.com/", "https://www.microsoft.com/en-us/", "https://www.tesla.com/"
     */
    @Test(priority = 4, description = "Validate link URLs")
    public void validateAllLinks(){
        List<WebElement> linksList = driver.findElements(By.cssSelector(".MultipleWindows_link__JB372"));
        String[] expectedUrlText = {"https://www.apple.com/", "https://www.microsoft.com/en-us/", "https://www.tesla.com/"};
        for (int i = 0; i < linksList.size(); i++) {
            linksList.get(i).click();
            WindowHandler.switchToChildWindow();
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrlText[i]);
            driver.close();
            WindowHandler.switchToMainWindow();
        }
    }
}
