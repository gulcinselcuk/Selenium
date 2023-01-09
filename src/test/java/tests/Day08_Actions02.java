package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Day08_Actions02 extends TestBase {
    /*
        Given
                Go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
        When
                Hover over "Hover Div"
        And
                Click on “Can you click me?” link.
        Then
                Verify the text "Action Complete".
        */
    @Test
    public void hoverOverTest(){
        //Go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

        //Hover over "Hover Div"
        Actions actions=new Actions(driver);
        WebElement hoverDiv=driver.findElement(By.id("hoverdivpara"));
        actions.moveToElement(hoverDiv).perform();

        //Click on “Can you click me?” link.
        driver.findElement(By.id("hoverlink")).click();

        //Verify the text "Action Complete".
        String actionCompleteText=driver.findElement(By.xpath("//h1")).getText();
        assertEquals("Action Complete",actionCompleteText);





    }
}
