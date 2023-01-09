package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q01 extends TestBase {
    /*
    Given
         Go to url : https://phptravels.com/demo/
    When
         Fill the form
    And
         Click on 'SUBMIT'
    Then
         Assert that the form has been sent
     */

    @Test
    public void q01Test() throws InterruptedException {
        //Go to url : https://phptravels.com/demo/
        driver.get("https://phptravels.com/demo/");

        //Fill the form
        driver.findElement(By.name("first_name")).sendKeys("Gulcin");
        driver.findElement(By.name("last_name")).sendKeys("Selcuk");
        driver.findElement(By.name("business_name")).sendKeys("GTU");
        driver.findElement(By.name("email")).sendKeys("gs@gmail.com");

        //HANDLE THE "+" OPERATION THEN SEND THE RESULT TO RESULT INPUT
        int numb1= Integer.parseInt(driver.findElement(By.id("numb1")).getText());
        int numb2= Integer.parseInt(driver.findElement(By.id("numb2")).getText());

        String result= numb2+numb1+"";
        driver.findElement(By.id("number")).sendKeys(result);

        //Click on 'SUBMIT'
        driver.findElement(By.id("demo")).click();

        Thread.sleep(5000);

        //accept the alert
        driver.switchTo().alert().accept();

        //Assert that the form has been sent
        WebElement thankYou=driver.findElement(By.xpath("//strong[.=' Thank you!']"));
        boolean thankYouIsDisplayed=thankYou.isDisplayed();
        assertTrue(thankYouIsDisplayed);

        //or
        String textOfElement=thankYou.getText();
        System.out.println(textOfElement);
        assertTrue(textOfElement.contains("Thank you!"));










    }

}
