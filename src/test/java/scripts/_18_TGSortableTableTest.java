package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;
import utils.Waiter;
import java.util.ArrayList;
import java.util.List;

public class _18_TGSortableTableTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-18")).click();
    }

    @Test
    public void validateSortAscendByQuantity(){
        WebElement ascByQuantity = driver.findElement(By.id("quantity_asc"));
        ascByQuantity.click();

        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(1);
        List<Integer> quantityColumnByIntegers = new ArrayList<>();
        for(WebElement e : quantityColumnElements){
            quantityColumnByIntegers.add(Integer.parseInt(e.getText()));
        }
        Waiter.pause(3);
        for (int i = 1; i < quantityColumnByIntegers.size(); i++) {
            Assert.assertTrue(quantityColumnByIntegers.get(i) >= quantityColumnByIntegers.get(i-1));
        }
    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Sortable Tables" card
     * Click on the Quantity sort button to toggle descending order
     * Verify that the Quantity column of the table is sorted in descending order
     */

    @Test
    public void validateSortDescendByQuantity(){
        WebElement descByQuantity = driver.findElement(By.id("quantity_desc"));
        descByQuantity.click();

        List<WebElement> columnOneElements = TableHandler.getTableColumn(1);
        List<Integer> descIntegers = new ArrayList<>();
        for(WebElement element : columnOneElements){
            descIntegers.add(Integer.parseInt(element.getText()));
        }
        Waiter.pause(2);
        for (int i = 0; i < descIntegers.size()-1; i++) {
            Assert.assertTrue(descIntegers.get(i+1) <= descIntegers.get(i));
        }
    }
    /**
     * TEST CASE 3
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Sortable Tables" card
     * Click on the Price sort button to toggle Ascending Order
     * Verify that the Price column of the table is sorted in ascending order
     */

    @Test
    public void validateAscendingPriceColumn(){
        WebElement ascPriceBtn = driver.findElement(By.id("price_asc"));
        ascPriceBtn.click();

        List<WebElement> ascPriceColumn = TableHandler.getTableColumn(3);
        List<Integer> ascPriceInteger = new ArrayList<>();
        for(WebElement element : ascPriceColumn){
            ascPriceInteger.add(Integer.parseInt(element.getText()));
        }

        for (int i = 1; i < ascPriceInteger.size(); i++) {
            Assert.assertTrue(ascPriceInteger.get(i) >= ascPriceInteger.get(i-1));
        }
    }
    /**
     * TEST CASE 4
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Sortable Tables" card
     * Click on the Price Sort button to toggle descending order
     * Verify that the Price column of the table is sorted in descending order
     */

    @Test
    public void validateDescendPrice(){
        WebElement descPriceBtn = driver.findElement(By.id("price_desc"));
        descPriceBtn.click();

        List<WebElement> descPriceColumn = TableHandler.getTableColumn(3);
        List<Integer> descPriceInteger = new ArrayList<>();
        for(WebElement element : descPriceColumn){
            descPriceInteger.add(Integer.parseInt(element.getText()));
        }
        Waiter.pause(2);
        for (int i = 0; i < descPriceInteger.size()-1; i++) {
            Assert.assertTrue(descPriceInteger.get(i+1) <= descPriceInteger.get(i));
        }
    }
}
