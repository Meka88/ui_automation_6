package scripts.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;

import java.util.List;

public class _01_ProjectTest extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");
    }

    @Test(priority = 1, description = "TC01 Validate Contact Us Info")
    public void validateContactUsPage(){
        WebElement heading = driver.findElement(By.cssSelector("h1[class='is-size-2']"));
        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(), "Contact Us");

        WebElement address = driver.findElement(By.id("address"));
        Assert.assertTrue(address.isDisplayed());
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");

        WebElement email = driver.findElement(By.id("email"));
        Assert.assertTrue(email.isDisplayed());
        Assert.assertEquals(email.getText(), "info@techglobalschool.com");

        WebElement phoneNumber = driver.findElement(By.id("phone-number"));
        Assert.assertTrue(phoneNumber.isDisplayed());
        Assert.assertEquals(phoneNumber.getText(), "(773) 257-3010");
    }

    @Test(priority = 2, description = "TC02 Validate Full name InputBox")
    public void validateFullNameInputBox(){
        WebElement inputBox = driver.findElement(By.cssSelector("form>div:nth-child(1)>div>input"));
        Assert.assertTrue(inputBox.isDisplayed());
        Assert.assertEquals(inputBox.getAttribute("required"), "true");

        WebElement nameLabel = driver.findElement(By.cssSelector("form>div:nth-child(1)>label"));
        Assert.assertEquals(nameLabel.getText(), "Full name *");
        Assert.assertEquals(inputBox.getAttribute("placeholder"), "Enter your name");// bug

    }

    @Test(priority = 3, description = "TC03 Validate Gender RadioBox")
    public void validateGenderRadioBox(){
        WebElement gender = driver.findElement(By.cssSelector("div.field:nth-child(2) label.label"));
        Assert.assertEquals(gender.getText(), "Gender *");
        Assert.assertEquals(gender.getAttribute("required"), "true");

        List<WebElement> genderInputList = driver.findElements(By.cssSelector(".mr-1"));
        List<WebElement> genderLabelList = driver.findElements(By.cssSelector("div[class='field'] label.radio"));

        String[] labelList = {"Male", "Female", "Prefer not to disclose"};// Bug order

        for (int i = 0; i < genderLabelList.size(); i++) {
            Assert.assertTrue(genderLabelList.get(i).isDisplayed());
            Assert.assertEquals(genderLabelList.get(i).getText(), labelList[i]);
            Assert.assertTrue(genderInputList.get(i).isEnabled());
            Assert.assertFalse(genderInputList.get(i).isSelected());
        }

        genderLabelList.get(1).click();
        Assert.assertTrue(genderInputList.get(0).isSelected());
        for (int i = 1; i < genderLabelList.size(); i++) {
            Assert.assertFalse(genderInputList.get(i).isSelected());
        }

        genderLabelList.get(0).click();
        Assert.assertTrue(genderInputList.get(1).isSelected());

        for (int i = 0; i < genderLabelList.size(); i++) {
            Assert.assertFalse(genderInputList.get(i).isSelected());
            i +=1;
        }
    }

    @Test(priority = 4, description = "TC04 Validate Address InputBox")
    public void validateAddressInput(){
        WebElement addressInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) input"));
        Assert.assertTrue(addressInput.isDisplayed());
        Assert.assertEquals(addressInput.getAttribute("required"), "false");
        WebElement addressLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) label"));
        Assert.assertEquals(addressLabel.getText(), "Address");
        Assert.assertEquals(addressInput.getAttribute("placeholder"), "Enter your address*");//fail because of requirement vs actual
    }

    @Test(priority = 5, description = "TC05 Validate Email InputBox")
    public void validateEmailInput(){
        WebElement emailInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) input"));
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertEquals(emailInput.getAttribute("required"), "true");
        WebElement emailLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) label"));
        Assert.assertEquals(emailLabel.getText(), "Email");// fail because of requirement vs actual
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "Enter your email");
    }

    @Test(priority = 6, description = "TC06 Validate Phone InputBox")
    public void validatePhoneInput(){
        WebElement phoneInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) input"));
        Assert.assertTrue(phoneInput.isDisplayed());
        Assert.assertEquals(phoneInput.getAttribute("required"), "false");
        WebElement phoneLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) label"));
        Assert.assertEquals(phoneLabel.getText(), "Phone");
        Assert.assertEquals(phoneInput.getAttribute("placeholder"), "Enter your phone number");
    }

    @Test(priority = 7, description = "TC07 Validate MessageTextArea")
    public void validateMessageTextArea(){
        WebElement textArea = driver.findElement(By.cssSelector(".textarea"));
        Assert.assertTrue(textArea.isDisplayed());
        Assert.assertEquals(textArea.getAttribute("required"), "false");
        WebElement messageLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(6) label"));
        Assert.assertEquals(textArea.getAttribute("placeholder"), "Type your message here…"); // bug report dots
    }

    @Test(priority = 8, description = "TC08 Validate Consent CheckBox")
    public void validateConsentCheckbox(){
        WebElement checkboxLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(7) label"));
        Assert.assertEquals(checkboxLabel.getText(), "I give my consent to be contacted.");
        WebElement checkboxInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(7) input"));
        Assert.assertEquals(checkboxInput.getAttribute("required"), "true");
        Assert.assertTrue(checkboxInput.isEnabled());
        checkboxInput.click();
        Assert.assertTrue(checkboxInput.isSelected());
        checkboxInput.click();
        Assert.assertFalse(checkboxInput.isSelected());

    }

    @Test(priority = 9, description = "ValidateSubmit button")
    public void validateSubmitButton(){
        WebElement submitBtn = driver.findElement(By.cssSelector(".is-link"));
        Assert.assertTrue(submitBtn.isDisplayed());
        Assert.assertTrue(submitBtn.isEnabled());
        Assert.assertEquals(submitBtn.getText(), "SUBMIT");
    }

    @Test(priority = 10, description = "Validate the Form Submission")
    public void validateFormSubmission(){
        WebElement inputBox = driver.findElement(By.cssSelector("form>div:nth-child(1)>div>input"));
        List<WebElement> genderInputList = driver.findElements(By.cssSelector(".mr-1"));
        WebElement addressInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) input"));
        WebElement emailInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) input"));
        WebElement phoneInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) input"));
        WebElement textArea = driver.findElement(By.cssSelector(".textarea"));
        WebElement checkboxInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(7) input"));
        WebElement submitBtn = driver.findElement(By.cssSelector(".is-link"));

        inputBox.sendKeys("Meerim Bolzhirova");// change requirements to full name
        genderInputList.get(1).click();
        addressInput.sendKeys("2930 West 30th st");
        emailInput.sendKeys("mekulya19@gmail.com");
        phoneInput.sendKeys("347-944-8817");
        textArea.sendKeys("Locators giving me a hard time(((");
        checkboxInput.click();
        submitBtn.submit();

        WebElement submissionMessage = driver.findElement(By.cssSelector(".mt-5"));
        Assert.assertTrue(submissionMessage.isDisplayed());
        Assert.assertEquals(submissionMessage.getText(), "Thanks for submitting!");
    }

}
