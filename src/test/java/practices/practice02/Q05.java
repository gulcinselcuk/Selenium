package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q05 extends TestBase {

    @Test
    public void q05test(){
        // Go to URL : https://demo.automationtesting.in/Static.html
        driver.get("https://demo.automationtesting.in/Static.html");

        // Drag and drop elements.
        Actions actions=new Actions(driver);
        WebElement angular=driver.findElement(By.id("angular"));
        WebElement mongo=driver.findElement(By.id("mongo"));
        WebElement node=driver.findElement(By.id("node"));

        WebElement target=driver.findElement(By.id("droparea"));

        actions.dragAndDrop(angular,target).
                dragAndDrop(mongo,target).
                dragAndDrop(node,target).build().perform();

    }

}
