package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;



public class Day14_StaleElementException extends TestBase {
    @Test
            public void seetetst(){
        driver.get("https://techproeducation.com/");
        WebElement lmsLogin=driver.findElement(By.linkText("LMS LOGIN"));
        //clicking lms login
        lmsLogin.click();
        //going back to homepage
        driver.navigate().back();
        //waitFor(5);
        //clicking lms login again
        //Failed cause lmslogin is no longer fresh.It is old .It is stale.
        lmsLogin.click();

        //SOLUTION:RELOCATE THE ELEMENT
        //driver.findElement(By.linkText("LMS LOGIN")).click();


    }


}
