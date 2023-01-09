package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//    When user goes to https://the-internet.herokuapp.com/upload
//    When user selects an image from the desktop
//    And click on the upload button
//    Then verify the File Uploaded!  Message displayed

public class Day10_FileUpload extends TestBase {
    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
//        1. locate choose file and click choose a file
//        <input type="file">
        WebElement chooseAFileButton = driver.findElement(By.id("file-upload"));

//        2. select a file from your computer
        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME + "/Desktop/file.txt";

//       String pathOfFile = userHOME + "\\Desktop\\logo.jpeg"; WINDOWS

        //        Sending the path of the file that I want to upload.
//        we can use send keys cause the input type file combination
        chooseAFileButton.sendKeys(pathOfFile);

//        3. then locate and click upload
        driver.findElement(By.id("file-submit")).click();

 //       4.asserting
        boolean isEqual=driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
        assertTrue(isEqual);

    }

    /*
    How do you upload a file with selenium?
    -First selenium has limitation automation of files. But file upload can be done with selenium.
    We locate the chose file button and use send keys function to send the path of the file.
    Then we click upload button to upload the file.
    Path of the file should be dynamic - use System.getProperty("user.home");
     */

    /*
    LIMITATION:
Selenium has limitation automation DESKTOP APPS
For example, we can not find path of files, or verify if file exists on out machines with selenum
Instead we use java File libraries
     */

}
