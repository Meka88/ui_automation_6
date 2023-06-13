package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class GoogleSearchResultPage {

    public GoogleSearchResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "result-stats")
    public WebElement resultStat;
}
