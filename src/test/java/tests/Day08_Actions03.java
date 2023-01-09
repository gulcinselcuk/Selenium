package tests;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions03 extends TestBase {
    /*
    Given
        Go to "https://www.techproeducation.com"
When
        Scroll down with "PAGE_DOWN" key 3 times
And
        Scroll down with "ARROW_DOWN" key
And
        Scroll up with "PAGE_UP" key
And
        Scroll up with "ARROW_UP" key
     */
    @Test
    public void pageUpDownTest() throws InterruptedException {
        //Go to "https://www.techproeducation.com"
        driver.get("https://www.techproeducation.com");
        Thread.sleep(2000);

        //Scroll down with "PAGE_DOWN" key 3 times
        Actions actions=new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //We can also use method chain:
        //build() is recommended to use in method chain to make sure the connection btw methods is strong.
        //perform() is must to use to execute the action.
         actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

        //Scroll down with "ARROW_DOWN" key ==>scrolls down less than PAGE_DOWN.
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        //Scroll up with "PAGE_UP" key
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);

        //Scroll up with "ARROW_UP" key
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);


    }
}
