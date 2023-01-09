package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_NoSuchElementException extends TestBase {

    @Test
    public void nseetest(){
        driver.get("https://techproeducation.com/");

        //wrong locator
        driver.findElement(By.id("wrong-id")); //implicitly wait 15 sec but could not find the element:no such element exception
    }
}
