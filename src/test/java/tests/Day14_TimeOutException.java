package tests;

import org.junit.Test;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {

    @Test
    public void totest(){

        driver.get("https://techproeducation.com/");
        //Trying to locate the element using Explicit wait
        //we get timeout exception because explicit wait could not handle the issue
       // waitForVisibility(By.id("wrong-id",15);

    }
}
