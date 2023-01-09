package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonDropdown {
    /*

1)  Create A Class: AmazonDropdown
    Create A Method dropdownTest
    Go to https://www.amazon.com/
    Find the element of the dropdown element. HINT: By.id("searchDropdownBox")
    Print the first selected option and assert if it equals "All Departments".If it fails,
     then comment that code out and continue rest of the test case.
    Select the 4th option by index (index of 3) and assert if the name is "Amazon Devices".
    (after you select you need to use get first selected option method).
    If it fails, then comment that code out and continue rest of the test case.
    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
    Print the the total number of options in the dropdown
    Assert if 'Appliances' is a drop down option. Print true if "Appliances" is an option. Print false otherwise.
    BONUS: Assert if the dropdown is in Alphabetical Order

    */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }
    // Create A Method dropdownTest
    @Test
    public void dropdownTest() {

//  Find the element of the dropdown element. HINT: By.id("searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);

//  Print the first selected option
        System.out.println("Selected Option : " + select.getFirstSelectedOption().getText());
        String actualData1 = select.getFirstSelectedOption().getText();
//      System.out.println(actualData);

//  Assert if it equals "All Departments".If it fails,then comment that code out and continue rest of the test case
//      Assert.assertEquals("All Departments", actualData);

        if (actualData1.equals("All Departments")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

// Select the 4th option by index (index of 3) and assert if the name is "Amazon Devices".
//    (after you select you need to use get first selected option method).
//  If it fails, then comment that code out and continue rest of the test case.
        select.selectByIndex(3);
        System.out.println("Selected Option : " + select.getFirstSelectedOption().getText());
        String actualData2 = select.getFirstSelectedOption().getText();

        if (actualData2.equals("Amazon Devices")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

// Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.

        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions) {
            System.out.println(eachOption.getText());
        }

// Print the total number of options in the dropdown
        System.out.println("total number of options in the dropdown:" + allOptions.size());

//  Assert if 'Appliances' is a dropdown option. Print true if "Appliances" is an option. Print false otherwise.
//        Assert.assertTrue("False",allOptions.contains("Appliances"));

        if (allOptions.contains("Appliances")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }



// BONUS: Assert if the dropdown is in Alphabetical Order
        ArrayList<String> obtainedList = new ArrayList<>();
        for (WebElement w:allOptions) {
            obtainedList.add(w.getText());
        }
        System.out.println("==============================================");

        ArrayList<String> sortedList = new ArrayList<>();
        for(String s:obtainedList){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
//        Assert.assertTrue(sortedList.equals(obtainedList));

        if(sortedList.equals(obtainedList)){
            System.out.println("This list is in alphabetical order");
        }else{
            System.out.println("This list is not in alphabetical order");
        }
    }
}

