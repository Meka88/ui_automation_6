package scripts.projects;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project2Page;
import scripts.Base;

public class _02_ProjectTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
        project2Page = new Project2Page();
    }

    @Test(priority = 1, description = "TC01: Validate Login form")
    public void validateTheLoginForm(){


        Assert.assertTrue(project2Page.userNameInputBox.isDisplayed());
        Assert.assertNotEquals(project2Page.userNameInputBox.getAttribute("required"), "true");
        Assert.assertEquals(project2Page.userNameInputBoxLabel.getText(), "Please enter your username");

        Assert.assertTrue(project2Page.passwordInputBox.isDisplayed());
        Assert.assertNotEquals(project2Page.passwordInputBox.getAttribute("required"), "true");
        Assert.assertEquals(project2Page.passwordInputBoxLabel.getText(), "Please enter your password");

        Assert.assertTrue(project2Page.loginBtn.isDisplayed());
        Assert.assertTrue(project2Page.loginBtn.isEnabled());
        Assert.assertEquals(project2Page.loginBtn.getText(), "LOGIN");

        Assert.assertTrue(project2Page.forgotPasswordLink.isDisplayed());
        Assert.assertTrue(project2Page.forgotPasswordLink.isEnabled());
        Assert.assertEquals(project2Page.forgotPasswordLink.getText(), "Forgot Password?");
    }

    @Test(priority = 2, description = "TS02: Validate Login")
    public void validateLogin(){

        project2Page.logIn("TechGlobal", "Test1234");


        Assert.assertTrue(project2Page.successfulLoginMessage.isDisplayed());
        Assert.assertEquals(project2Page.successfulLoginMessage.getText(), "You are logged in");


        Assert.assertTrue(project2Page.logoutBtn.isDisplayed());
        Assert.assertEquals(project2Page.logoutBtn.getText(), "LOGOUT");
    }

    @Test(priority = 3, description = "TC03: Validate Logout")
    public void validateLogout(){

        project2Page.logIn("TechGlobal", "Test1234");

        project2Page.logoutBtn.click();

        Assert.assertTrue(project2Page.loginForm.isDisplayed());
    }

    @Test(priority = 4, description = "TC04: Validate Forgot Password Link And Reset Password")
    public void validateForgotPasswordLinkAndResetPassword(){

        project2Page.forgotPasswordLink.click();

        Assert.assertTrue(project2Page.resetPasswordModalTitle.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalCloseBtn.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalEmailInputBoxLabel.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalEmailInputBoxLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(project2Page.resetPasswordModalSubmitBtn.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalSubmitBtn.isEnabled());
        Assert.assertEquals(project2Page.resetPasswordModalSubmitBtn.getText(), "SUBMIT");

    }

    @Test(priority = 5, description = "TC05: Validate Close Button on ResetPassword Modal")
    public void validateCloseButtonOnResetPasswordModal(){
        project2Page.forgotPasswordLink.click();

        Assert.assertTrue(project2Page.resetPasswordModal.isDisplayed());

        project2Page.resetPasswordModalCloseBtn.click();

        try{
            Assert.assertFalse(project2Page.resetPasswordModal.isDisplayed());
        }catch (StaleElementReferenceException e){
            Assert.assertTrue(true);
        }

    }

    @Test(priority = 6, description = "TC06: Validate Reset Password Form")
    public void validateResetPasswordForm(){
        project2Page.forgotPasswordLink.click();

        project2Page.resetPasswordModalEmailInputBox.sendKeys("aabcd@gmail.com");
        project2Page.resetPasswordModalSubmitBtn.click();

        Assert.assertTrue(project2Page.resetPasswordModalMessage.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalMessage.getText(), "A link to reset your password has been sent to your email address.");
    }

    @Test(priority = 7, description = "TC07: Validate invalid login with empty credentials")
    public void validateInvalidLoginWithEmptyCredentials(){
        project2Page.loginBtn.click();

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 8, description = "TC08: Validate invalid Login with wrong username")
    public void validateInvalidLoginWithInvalidUsername(){
        project2Page.logIn("John", "Test1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 9, description = "TC09: Validate Invalid Login with Invalid password")
    public void validateInvalidLoginWithInvalidPassword(){
        project2Page.logIn("TechGlobal", "1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Password entered!");
    }

    @Test(priority = 10, description = "TC10: Validate Invalid Login with Invalid username and password")
    public void validateInvalidLoginWithInvalidUsernameAndPassword(){
        project2Page.logIn("John", "1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }
}
