package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import static java.awt.SystemColor.text;

public class GoogleSearchPage {

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "APjFqb")
    public WebElement searchBar;


    public void search(String text){
        searchBar.sendKeys(text + Keys.ENTER);
    }
}
