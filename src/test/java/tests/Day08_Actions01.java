package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class Day08_Actions01 extends TestBase {
    /*
        Given
                Go to "https://the-internet.herokuapp.com/context_menu"
        When
                Right-click on the box
        Then
                Verify the alert message is “You selected a context menu”
        And
                Accept the alert
        */
    @Test
    public void rightClickTest() throws InterruptedException {
        //go to link
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Right-click on the box
        //1st step:create "actions" object
        Actions actions=new Actions(driver);

        //2nd step:locate the web element you want to right-click.
        WebElement box=driver.findElement(By.id("hot-spot"));

        //3rd step:Use actions object with proper method
        actions.contextClick(box).perform();

        //Verify the alert message is “You selected a context menu”
        String alertText=driver.switchTo().alert().getText();
        assertEquals("You selected a context menu",alertText);

        //Accept the alert
        driver.switchTo().alert().accept();

    }
}
