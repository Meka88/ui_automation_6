package testng_knowledge;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _04_SoftAndHardAssertions {


    @Test
    public void test1(){

        Assert.assertEquals("hello", "world");

        System.out.println("Rest of the test");
    }


    @Test
    public void test2(){
        SoftAssert softAssert = new SoftAssert(); // create object in order to use nonstatic methods
        softAssert.assertEquals("hello", "world");

        System.out.println("Rest of the test");

        softAssert.assertAll(); // will attach all the soft assert failures
    }
}
