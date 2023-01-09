package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day07_IFrame extends TestBase {
    @Test
    public void iFrameTest() throws InterruptedException {
//        Create a class: IFrame
//        Create a method: iframeTest
//        Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

//        Verify the Bolded text contains “Editor”
        //header is not in the iframe so do not
        String header=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(header.contains("Editor"));

        //NOTE:textbook is in the iframe so we have to switch to the frame
        //there are 3 ways to switch to an iframe:
        driver.switchTo().frame(0);//1.index
//        driver.switchTo().frame("mce_0_ifr");//2.id or name of frame .preferred one
//        driver.switchTo().frame(driver.findElement(By.xpath("mce_0_ifr")));//3.webelement of frame

//        Locate the text box
        WebElement box= driver.findElement(By.xpath("//p"));

//        Delete the text in the text box
        Thread.sleep(2000);
        box.clear();//clear() is used to delete
        Thread.sleep(2000);

//        Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");
        Thread.sleep(2000);


        //so far driver is in the iframe but Elemental Selenium text is outside of the frame
        //getting out of the frame
        driver.switchTo().parentFrame();
        //alternatively we can use defaultContent()

//        Verify the text Elemental Selenium text is displayed on the page
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());


    }
    /*
        What might be the reason for your test case to fail?
            -There may be wait problem. The page may be very slow. Internet maybe not fast enough.
                +put some more wait. We can use explicit wait in the selenium
            -Locator might be incorrect
                +double check locator and fix
            -Data issue. Typo in our expected values
                +If there is any documentation issue, we can talk to BA to fix the document then we can use correct expected values
            -Maybe there is an iframe on the page
                +we first need to switch to frame
            -Maybe there is an alert on the page
                +handle alert by accepting or dismissing
            -It maybe a real bug caused by the latest codes.
                +we discuss the issue with team then raise a bug ticket if needed.

     */
}
