package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project2Page {

    // modify default constructor
    public Project2Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement userNameInputBox;

    @FindBy(css = "label[for='username']")
    public WebElement userNameInputBoxLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(css = "label[for='password']")
    public WebElement passwordInputBoxLabel;

    @FindBy(id = "login_btn")
    public WebElement loginBtn;

    @FindBy(css = "div:nth-child(3)>a")
    public WebElement forgotPasswordLink;

    @FindBy(id = "error_message")
    public WebElement errorMessage;

    @FindBy(id = "success_lgn")
    public WebElement successfulLoginMessage;

    @FindBy(id = "logout")
    public WebElement logoutBtn;

    @FindBy(css = ".modal-card")
    public WebElement resetPasswordModal;

    @FindBy(id = "modal_title")
    public WebElement resetPasswordModalTitle;

    @FindBy(css = ".delete")
    public WebElement resetPasswordModalCloseBtn;

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordModalHeading;

    @FindBy(id = "email")
    public WebElement resetPasswordModalEmailInputBox;

    @FindBy(css = "label[for='email']")
    public WebElement resetPasswordModalEmailInputBoxLabel;

    @FindBy(id = "submit")
    public WebElement resetPasswordModalSubmitBtn;

    @FindBy(css = "p[class^='has-text-']")
    public WebElement resetPasswordModalMessage;

    @FindBy(css = "div>form")
    public WebElement loginForm;

    // reusable methods
    public void logIn(String userName, String password){
        userNameInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
    }


}
