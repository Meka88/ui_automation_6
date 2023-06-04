package scripts.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;
import utils.Waiter;

public class _02_ProjectText extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    @Test(priority = 1, description = "TC01: Validate Login form")
    public void validateTheLoginForm(){
        WebElement nameInputBox = driver.findElement(By.id("username"));
        WebElement nameLabel = driver.findElement(By.cssSelector("div:nth-child(1)>label"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.cssSelector("div:nth-child(2)>label"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));

        Assert.assertTrue(nameInputBox.isDisplayed());
        Assert.assertNotEquals(nameInputBox.getAttribute("required"), "true");
        Assert.assertEquals(nameLabel.getText(), "Please enter your username");

        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertNotEquals(passwordInputBox.getAttribute("required"), "true");
        Assert.assertEquals(passwordLabel.getText(), "Please enter your password");

        Assert.assertTrue(loginBtn.isDisplayed());
        Assert.assertTrue(loginBtn.isEnabled());
        Assert.assertEquals(loginBtn.getText(), "LOGIN");

        Assert.assertTrue(forgotPassword.isDisplayed());
        Assert.assertTrue(forgotPassword.isEnabled());
        Assert.assertEquals(forgotPassword.getText(), "Forgot Password?");
    }

    @Test(priority = 2, description = "TS02: Validate Login")
    public void validateLogin(){
        WebElement nameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));

        nameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginBtn.click();

        WebElement loginMessage = driver.findElement(By.id("success_lgn"));
        Assert.assertTrue(loginMessage.isDisplayed());
        Assert.assertEquals(loginMessage.getText(), "You are logged in");

        WebElement logoutBtn = driver.findElement(By.id("logout"));
        Assert.assertTrue(logoutBtn.isDisplayed());
        Assert.assertEquals(logoutBtn.getText(), "LOGOUT");
    }

    @Test(priority = 3, description = "TC03: Validate Logout")
    public void validateLogout(){
        WebElement nameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));

        nameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginBtn.click();

        WebElement logoutBtn = driver.findElement(By.id("logout"));
        logoutBtn.click();

        WebElement loginForm = driver.findElement(By.cssSelector("div>form"));
        Assert.assertTrue(loginForm.isDisplayed());
    }

    @Test(priority = 4, description = "TC04: Validate Forgot Password Link And Reset Password")
    public void validateForgotPasswordLinkAndResetPassword(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
        forgotPassword.click();

        WebElement modalHeading = driver.findElement(By.id("modal_title"));
        WebElement closeBtn = driver.findElement(By.cssSelector("header button"));
        WebElement emailInputBox = driver.findElement(By.id("email"));
        WebElement inputBoxLabel = driver.findElement(By.cssSelector("section label"));
        WebElement submitBtn = driver.findElement(By.id("submit"));

        Assert.assertTrue(modalHeading.isDisplayed());
        Assert.assertTrue(closeBtn.isDisplayed());
        Assert.assertTrue(emailInputBox.isDisplayed());
        Assert.assertEquals(inputBoxLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(submitBtn.isDisplayed());
        Assert.assertTrue(submitBtn.isEnabled());
        Assert.assertEquals(submitBtn.getText(), "SUBMIT");

    }

    @Test(priority = 5, description = "TC05: Validate Close Button on ResetPassword Modal")
    public void validateCloseButtonOnResetPasswordModal(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
        forgotPassword.click();

        WebElement resetModal = driver.findElement(By.cssSelector(".modal-card"));
        Assert.assertTrue(resetModal.isDisplayed());

        WebElement closeBtn = driver.findElement(By.cssSelector("header button"));
        closeBtn.click();

        Assert.assertFalse(resetModal.isDisplayed());
    }

    @Test(priority = 6, description = "TC06: Validate Reset Password Form")
    public void validateResetPasswordForm(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
        forgotPassword.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement submitBtn = driver.findElement(By.id("submit"));
        emailInput.sendKeys("aabcd@gmail.com");
        submitBtn.click();

        WebElement resetFormMessage = driver.findElement(By.cssSelector("section p"));
        Assert.assertTrue(resetFormMessage.isDisplayed());
        Assert.assertEquals(resetFormMessage.getText(), "A link to reset your password has been sent to your email address.");
    }

    @Test(priority = 7, description = "TC07: Validate invalid login with empty credentials")
    public void validateInvalidLoginWithEmptyCredentials(){
        WebElement loginBtn = driver.findElement(By.id("login_btn"));
        loginBtn.click();
        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 8, description = "TC08: Validate invalid Login with wrong username")
    public void validateInvalidLoginWithInvalidUsername(){
        WebElement nameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));

        nameInputBox.sendKeys("John");
        passwordInputBox.sendKeys("Test1234");
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 9, description = "TC09: Validate Invalid Login with Invalid password")
    public void validateInvalidLoginWithInvalidPassword(){
        WebElement nameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));

        nameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("1234");
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Password entered!");
    }

    @Test(priority = 10, description = "TC10: Validate Invalid Login with Invalid username and password")
    public void validateInvalidLoginWithInvalidUsernameAndPassword(){
        WebElement nameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));

        nameInputBox.sendKeys("John");
        passwordInputBox.sendKeys("1234");
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }
}
