package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class Day10_ScreenshotsOfEntirePage extends TestBase {

    @Test
    public void takeScreenShotTest() throws IOException, InterruptedException {
        //Given user search for ‘uni’
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        Thread.sleep(1000);

        //TAKE A SCREENSHOT. CREATE A REUSABLE METHOD AND CALL THAT METHOD
        takeScreenshotOfPage();
        //And select United Kingdom
        searchAndSelectFromList("uni","United Kingdom");

        //        When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
//       And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        Thread.sleep(1000);
        takeScreenshotOfPage();
        //Add click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(1000);
        takeScreenshotOfPage();


        //Then verify the result contains united Kingdom
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));


    }
}
