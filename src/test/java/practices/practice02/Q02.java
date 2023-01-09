package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
    /*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */

    @Test
    public void q02Test() throws InterruptedException {
        //Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //Click on the "Animals and Nature" emoji
        //first we need to switch on iframe
        WebElement iFrame=driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();
        Thread.sleep(2000);

        //Click all the "Animals and Nature"  emoji elements
        //div[@id='nature']/div/img
        List<WebElement> allEmojis= driver.findElements(By.xpath("//div[@id='nature']/div/img"));
//        for(WebElement w:allEmojis){
//            w.click();
//        }

        //Using lambda is recommended
        allEmojis.stream().forEach(t->t.click());

        //Fill the form
        //we need to go outside of the iframe
        driver.switchTo().defaultContent();

        List<WebElement> allInputs=driver.findElements(By.xpath("//input"));
        List<String>allWords=new ArrayList<>(Arrays.asList("This","iFrame","example","looks","very","funny","does","not","it","?","?"));
        for(int i=0;i<allInputs.size();i++){
            allInputs.get(i).sendKeys(allWords.get(i));
        }
        Thread.sleep(2000);

        //Press the apply button
        driver.findElement(By.id("send")).click();

        //Verify "code" element is displayed

        WebElement code= driver.findElement(By.id("code"));
        assertTrue(code.isDisplayed());



    }


}
