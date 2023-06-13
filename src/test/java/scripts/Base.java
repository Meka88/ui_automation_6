package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.Driver;

public class Base {
    public static WebDriver driver; // declaration

    Actions actions;

    // declaring Pages
    public static Project2Page project2Page;
    public static GoogleSearchPage googleSearchPage;
    public static GoogleSearchResultPage googleSearchResultPage;
    public static Project3Page project3Page;
    public static EtsyHomePage etsyHomePage;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
