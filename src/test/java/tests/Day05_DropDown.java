package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day05_DropDown {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //        IMPLICIT WAIT
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void dropDownTest(){
        //Select option1 by index from the dropdown
        //1. step:Locate the dropdown
        WebElement dropDown= driver.findElement(By.id("dropdown"));

        //2.step:Create select object
        Select select= new Select(dropDown);

        //3rd step: Select option by index/value/visibleText
        select.selectByIndex(1);
    }



    @Test
    //1.Create method selectByIndexTest and Select Option 1 using index
    public void selectByVisibleTextTest() {

        //2.Create method selectByValueTest Select Option 2 by visible text
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Option 2");
    }
        //3.Create method selectByVisibleTextTest Select Option 1 value by value
      @Test
    public void selectByValue() throws InterruptedException {
          WebElement dropDown = driver.findElement(By.id("dropdown"));
          Select select = new Select(dropDown);
          Thread.sleep(3000);//HARD WAIT. WAITS 3 SECONDS
          select.selectByValue("1");
          Thread.sleep(3000);
          select.selectByValue("2");
          Thread.sleep(3000);
          select.selectByValue("1");
          Thread.sleep(3000);
          select.selectByValue("2");

      }
    //4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
//        getOptions(); returns all of the dropdown options
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions) {
//            getText() returns the TEXT of the web elements as STRING
            System.out.println(eachOption.getText());

        }
//    5. Verify the dropdown has Option 2 text
        boolean isOption2Exist=false;
        for (WebElement eachOption : allOptions){
            if (eachOption.getText().equals("Option 2")){
                isOption2Exist=true;
            }
        }
//        fails if Option 2 is not in the dropdown
//        pass if Option 2 is in the dropdown
        Assert.assertTrue(isOption2Exist);
    }
    //6.Create method printFirstSelectedOptionTest Print first selected option

    @Test
    public void printFirstSelectedOptionTest(){
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select select=new Select(dropdown);
        //printing the selected option
        System.out.println("selected option: "+select.getFirstSelectedOption().getText());
        //selected a different option from the dropdown
        select.selectByIndex(2);
        //printing the selected option
        System.out.println("selected option: "+select.getFirstSelectedOption().getText());


        //7.Find the size of the dropdown,
        // Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        int numberOfOptions=select.getOptions().size();
        int expectedNumberOfOptions=3;

        //Assertion will print "expected is not equal to actual" only if this assertion fails
        Assert.assertEquals("expected is not equal to actual",expectedNumberOfOptions,numberOfOptions);

    }

               @After
               public void tearDown(){
                  driver.quit();
                }
}
/*
1.What is a dropdown?
--Dropdown is a webelement. it has list of options.
2.How do you handle dropdown?What do you do to automate dropdown?
--Dropdowns are created using Select class.So we first locate the dropdown element, then use select class
to interact with dropdown elements.
3.How do you select dropdown elements?
--We actually have 3 options to select a dropdown(index,value,visible text)
 */

