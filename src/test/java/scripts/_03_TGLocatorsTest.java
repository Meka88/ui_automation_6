package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _03_TGLocatorsTest {
    public static WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup(); // Set up Chrome driver

        driver = new ChromeDriver(); // Launch a Chrome driver
        driver.manage().window().maximize(); // Maximizes the Chrome window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait

        driver.get("https://techglobal-training.com/frontend/locators");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 1)
    public void validateKiwiParagraph(){
        WebElement kiwiParagraph = driver.findElement(By.id("item_kiwi"));
        Assert.assertTrue(kiwiParagraph.isDisplayed());
        Assert.assertEquals(kiwiParagraph.getText(), "Kiwi");
    }

    @Test(priority = 2)
    public void validateOrangeParagraph(){
        WebElement orangeParagraph = driver.findElement(By.name("item_orange"));
        Assert.assertTrue(orangeParagraph.isDisplayed());
        Assert.assertEquals(orangeParagraph.getText(), "Orange");
    }

    @Test(priority = 3)
    public void validateGrapesParagraph(){
        WebElement grapesParagraph = driver.findElement(By.className("item_grapes"));
        Assert.assertTrue(grapesParagraph.isDisplayed());
        Assert.assertEquals(grapesParagraph.getText(), "Grapes");
    }

    @Test(priority = 4)
    public void validateElements(){
        List<WebElement> allParagraphs = driver.findElements(By.tagName("p"));
        String[] expectedTexts = {"Kiwi", "Orange", "Grapes"};
        //Assert.assertTrue(allParagraphs.get(0).isDisplayed());
        for (int i = 0; i < 2; i++) {
            Assert.assertTrue(allParagraphs.get(i).isDisplayed());
            Assert.assertEquals(allParagraphs.get(i).getText(), expectedTexts[i]);
        }

    }

    @Test(priority = 5)
    public void validateLinkApple(){
        WebElement redAppleLink = driver.findElement(By.linkText("Red Apple"));
        Assert.assertTrue(redAppleLink.isDisplayed());
        Assert.assertTrue(redAppleLink.isEnabled());
        Assert.assertEquals(redAppleLink.getAttribute("href"), "https://en.wikipedia.org/wiki/Red_apple"); // this using attribute
        //redAppleLink.click(); // click on it
        //Assert.assertEquals(driver.getCurrentUrl(), "https://en.wikipedia.org/wiki/Red_apple"); // validate URL

    }

    @Test(priority = 6)
    public void validateAllLinks(){
        List <WebElement> allLinks = driver.findElements(By.partialLinkText("pple"));

        String[] expectedVisibleTexts = {"Red Apple", "Green Apple", "Pineapple"};
        String[] expectedLinks = {"https://en.wikipedia.org/wiki/Red_apple", "https://en.wikipedia.org/wiki/Green_apple", "https://en.wikipedia.org/wiki/Pineapple"};

        for (int i = 0; i < 2; i++) {
            Assert.assertTrue(allLinks.get(i).isDisplayed());
            Assert.assertTrue(allLinks.get(i).isEnabled());
            Assert.assertEquals(allLinks.get(i).getText(), expectedVisibleTexts[i]);
            Assert.assertEquals(allLinks.get(i).getAttribute("href"), expectedLinks[i]);
        }
        Assert.assertEquals(allLinks.get(0).getAttribute("href"), "https://en.wikipedia.org/wiki/Red_apple");
        Assert.assertEquals(allLinks.get(1).getAttribute("href"), "https://en.wikipedia.org/wiki/Green_apple");
        Assert.assertEquals(allLinks.get(2).getAttribute("href"), "https://en.wikipedia.org/wiki/Pineapple");
    }
}

