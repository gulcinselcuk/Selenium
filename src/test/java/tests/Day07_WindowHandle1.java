package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Day07_WindowHandle1 extends TestBase {
    @Test
    public void windowHandleTest(){

//        Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

//        Then user verifies the text : “Opening a new window”
        String window1Text=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);

//        Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet",driver.getTitle());

        //Getting the window 1 handle(unique page id)
        String window1Handle= driver.getWindowHandle();//returns the current window id
        System.out.println(window1Handle);

//        When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();

//        Then user verifies the new window title is “New Window”
        //we do testing in a new window,so we must switch to that window
        //as of now 2 windows open use getWindowHandles() get to both ids
        Set<String> allWindowHandles=driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for(String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)){ //if we are not in win1 (means windows 2)
                driver.switchTo().window(eachHandle); //then switch the window 2
            }
        }


        // at this point driver is switched to windows2
        String window2Handle=driver.getWindowHandle();//window2 id

//        Then user verifies the text:  “New Window”
        String window2Text=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window",window2Text);

//        When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(window1Handle);//switches window 1
        Assert.assertEquals("The Internet", driver.getTitle());

    }
}
