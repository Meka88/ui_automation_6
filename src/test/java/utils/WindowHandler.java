package utils;

import org.openqa.selenium.WebDriver;

public class WindowHandler {
    static String mainWindow;
    static WebDriver driver;
    // switching to second window
    public static void switchToChildWindow(){
        driver = Driver.getDriver();
        mainWindow = driver.getWindowHandle();
        for(String s : driver.getWindowHandles()){
            if(!s.equals(mainWindow)) {
                driver.switchTo().window(s);
                break;
            }
        }
    }
    // switching back to main window
    public static void switchToMainWindow(){
        driver.switchTo().window(mainWindow);
    }
}
