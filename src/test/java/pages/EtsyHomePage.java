package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class EtsyHomePage {

    public EtsyHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "ul[role='menubar'] a")
    public List<WebElement> navBarItems;
}
