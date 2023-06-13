package scripts.projects;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;
import scripts.Base;
import utils.DropdownHandler;

public class _03_ProjectTest extends Base {
    @BeforeMethod
    public void setPage(){

        driver.get("https://techglobal-training.com/frontend/project-3");
        project3Page = new Project3Page();
    }

    @Test(priority = 1, description = "TC01: Validate The Default Book Your Trip Form")
    public void validateDefaultBookATripForm(){

        Assert.assertTrue(project3Page.oneWayBtn.isDisplayed());
        Assert.assertTrue(project3Page.oneWayBtn.isEnabled());
        Assert.assertTrue(project3Page.oneWayBtn.isSelected());

        Assert.assertTrue(project3Page.roundTripBtn.isDisplayed());
        Assert.assertTrue(project3Page.roundTripBtn.isEnabled());
        Assert.assertFalse(project3Page.roundTripBtn.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassSelect.isDisplayed());

        Assert.assertTrue(project3Page.fromLabelDropDown.isDisplayed());
        Assert.assertTrue(project3Page.fromSelectDropDown.isDisplayed());

        Assert.assertTrue(project3Page.toLabelDropDown.isDisplayed());
        Assert.assertTrue(project3Page.toSelectDropDown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isEnabled());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertFalse(project3Page.returnDatePicker.isEnabled()); // bug it is enabled

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropDown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersDropDown.getAttribute("value"), "1");

        Assert.assertTrue(project3Page.passengerOneLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerOneDropdown.isDisplayed());
        Assert.assertEquals(project3Page.passengerOneDropdown.getAttribute("value"), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookBtn.isDisplayed());
        Assert.assertTrue(project3Page.bookBtn.isEnabled());
    }

    @Test(priority = 2, description = "TC02: Validate Booking a trip form when round trip is selected")
    public void validateBookingARoundTrip(){

        project3Page.roundTripBtn.click();
        Assert.assertTrue(project3Page.roundTripBtn.isSelected());
        Assert.assertFalse(project3Page.oneWayBtn.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassSelect.isDisplayed());

        Assert.assertTrue(project3Page.fromLabelDropDown.isDisplayed());
        Assert.assertTrue(project3Page.fromSelectDropDown.isDisplayed());

        Assert.assertTrue(project3Page.toLabelDropDown.isDisplayed());
        Assert.assertTrue(project3Page.toSelectDropDown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropDown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersDropDown.getAttribute("value"), "1");

        Assert.assertTrue(project3Page.passengerOneLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerOneDropdown.isDisplayed());
        Assert.assertEquals(project3Page.passengerOneDropdown.getAttribute("value"), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookBtn.isDisplayed());
        Assert.assertTrue(project3Page.bookBtn.isEnabled());
    }

    @Test(priority = 3, description = "TC03: Validate Booking for 1 Passenger one way")
    public void validateBookingForOnePassenger(){

        project3Page.oneWayBtn.click();
        DropdownHandler.selectByVisibleText(project3Page.cabinClassSelect, "Business");
        DropdownHandler.selectByVisibleText(project3Page.fromSelectDropDown, "Illinois");
        DropdownHandler.selectByVisibleText(project3Page.toSelectDropDown, "Florida");
        project3Page.departMonth.sendKeys("6");
        project3Page.departDay.sendKeys("17");
        project3Page.departYear.sendKeys("2023");
        project3Page.departYear.sendKeys(Keys.ESCAPE);

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropDown, "1");
        DropdownHandler.selectByVisibleText(project3Page.passengerOneDropdown, "Senior (65+)");
        project3Page.bookBtn.click();


        Assert.assertTrue(project3Page.bookingResultMessage.isDisplayed());
    }

    @Test(priority = 4, description = "TC04: Validate The Booking For One Passenger and Round trip")
    public void validateRoundTripForOnePassenger(){

        project3Page.roundTripBtn.click();
        DropdownHandler.selectByVisibleText(project3Page.cabinClassSelect, "First");
        DropdownHandler.selectByVisibleText(project3Page.fromSelectDropDown, "California");
        DropdownHandler.selectByVisibleText(project3Page.toSelectDropDown, "Illinois");
        //depart date
        project3Page.departMonth.sendKeys("6");
        project3Page.departDay.sendKeys("18");
        project3Page.departYear.sendKeys("2023");
        //return date
        project3Page.returnMonth.sendKeys("7");
        project3Page.returnDay.sendKeys("18");
        project3Page.returnYear.sendKeys("2023");
        project3Page.returnYear.sendKeys(Keys.ESCAPE);

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropDown, "1");
        DropdownHandler.selectByVisibleText(project3Page.passengerOneDropdown, "Adult (16-64)");
        project3Page.bookBtn.click();

        Assert.assertTrue(project3Page.bookingResultMessage.isDisplayed());
    }

    @Test(priority = 5, description = "TC05: Validate Booking for Two Passengers One way")
    public void validateOneWayForTwoPassengers(){

        project3Page.oneWayBtn.click();
        DropdownHandler.selectByVisibleText(project3Page.cabinClassSelect, "Premium Economy");
        DropdownHandler.selectByVisibleText(project3Page.fromSelectDropDown, "New York");
        DropdownHandler.selectByVisibleText(project3Page.toSelectDropDown, "Texas");
        //depart date
        project3Page.departMonth.sendKeys("6");
        project3Page.departDay.sendKeys("13");
        project3Page.departYear.sendKeys("2023");
        project3Page.departYear.sendKeys(Keys.ESCAPE);

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropDown, "2");
        DropdownHandler.selectByVisibleText(project3Page.passengerOneDropdown, "Adult (16-64)");

        DropdownHandler.selectByVisibleText(project3Page.passengerTwoDropdown, "Child (2-11)");
        project3Page.bookBtn.click();

        Assert.assertTrue(project3Page.bookingResultMessage.isDisplayed());
    }
}
