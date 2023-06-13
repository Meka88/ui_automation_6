package testng_knowledge;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class _03_IgnoringTests {

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("test2");
    }


    @Test(enabled = false)
    public void test3(){
        System.out.println("test3");
    }
}
