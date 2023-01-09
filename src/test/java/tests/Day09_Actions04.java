package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day09_Actions04 extends TestBase {
    /*
        Given
                Go to "https://jqueryui.com/droppable/"
        When
                Drag the element "Drag me to my target" to "Drop here" element and drop it.
        */
    @Test
    public void dragAndDropTest() throws InterruptedException {
        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //since the element in iframe we need to switch to iframe first
        driver.switchTo().frame(0);

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.create actions object
        Actions actions=new Actions(driver);

        //2.locate source and target web element
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));

        //3.use dragAndDrop() method with web elements
        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();
        Thread.sleep(2000);


        /*
        If you can not find the element
        1.check the locator
        2.wait or synchronization issue
        3.Iframe issue
         */


    }

    @Test
    public void clickAndHold() throws InterruptedException {
        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //since the element in iframe we need to switch to iframe first
        driver.switchTo().frame(0);

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.create actions object
        Actions actions = new Actions(driver);

        //2.locate source and target web element
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        //3.use dragAndDrop() method with web elements
        Thread.sleep(2000);
        actions.clickAndHold(source).moveToElement(target).build().perform();
        Thread.sleep(2000);

    }
    @Test
    public void dragAndDropByTest() throws InterruptedException {
        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Since the elements are in  an iFrame we need to switch to iFrame first
        driver.switchTo().frame(0);//This will switch driver to iFrame

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1. Create Actions object
        Actions actions = new Actions(driver);

        //2. Locate source and target web elements
        WebElement source = driver.findElement(By.id("draggable"));

        //3. Use dragAndDropBy() method with web elements.
        Thread.sleep(2000);
        actions.dragAndDropBy(source,170,26).perform();
        Thread.sleep(2000);

    }
    @Test
    public void moveByOffsetTest() throws InterruptedException {
        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Since the elements are in  an iFrame we need to switch to iFrame first
        driver.switchTo().frame(0);//This will switch driver to iFrame

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1. Create Actions object
        Actions actions = new Actions(driver);

        //2. Locate source and target web elements
        WebElement source = driver.findElement(By.id("draggable"));

        //3. Use moveByOffset() method with web elements.
        Thread.sleep(2000);
        actions.clickAndHold(source).moveByOffset(160,40).perform();
    }







}
