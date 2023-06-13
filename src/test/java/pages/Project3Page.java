package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.DropdownHandler;

public class Project3Page {

    public Project3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "label:nth-child(1)>input")
    public WebElement oneWayBtn;

    @FindBy(css = "label:nth-child(2)>input")
    public WebElement roundTripBtn;

    @FindBy(css = ".field:nth-child(2)>label")
    public WebElement cabinClassLabel;

    @FindBy(css = "div:nth-child(2)>div>select")
    public WebElement cabinClassSelect;

    @FindBy(css = ".field:nth-child(3)>label")
    public WebElement fromLabelDropDown;

    @FindBy(css = "div:nth-child(3)>div>select")
    public WebElement fromSelectDropDown;

    @FindBy(css = ".field:nth-child(4)>label")
   public WebElement toLabelDropDown;

    @FindBy(css = "div:nth-child(4)>div>select")
    public WebElement toSelectDropDown;

    @FindBy(css = ".field:nth-child(5)>label")
    public WebElement departLabel;

    @FindBy(css = ".field:nth-child(5)>div")
    public WebElement departDatePicker;

    @FindBy(css = ".field:nth-child(6)>label")
    public WebElement returnLabel;

    @FindBy(css = ".field:nth-child(6)>div")
    public WebElement returnDatePicker;

    @FindBy(css = ".field:nth-child(7)>label")
    public WebElement numberOfPassengersLabel;

    @FindBy(css = "div:nth-child(7)>div>select")
    public WebElement numberOfPassengersDropDown;

    @FindBy(css = ".field:nth-child(8)>label")
    public WebElement passengerOneLabel;

    @FindBy(css = "div:nth-child(8)>div>select")
    public WebElement passengerOneDropdown;

    @FindBy(css = "form>div:nth-child(2)>div>button")
    public WebElement bookBtn;

    @FindBy(css = "form>div.ml-3")
    public WebElement bookingResultMessage;

    @FindBy(css = "div:nth-child(9)>div>select")
    public WebElement passengerTwoDropdown;

    @FindBy(css = ".field:nth-child(5) .control input[name='month']")
    public WebElement departMonth;

    @FindBy(css = ".field:nth-child(5) .control input[name='day']")
    public WebElement departDay;

    @FindBy(css = ".field:nth-child(5) .control input[name='year']")
    public WebElement departYear;

    @FindBy(css = ".field:nth-child(6) .control input[name='month']")
    public WebElement returnMonth;

    @FindBy(css = ".field:nth-child(6) .control input[name='day']")
    public WebElement returnDay;

    @FindBy(css = ".field:nth-child(6) .control input[name='year']")
    public WebElement returnYear;
}
