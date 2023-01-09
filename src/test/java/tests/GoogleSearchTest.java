package tests;

import com.github.javafaker.Bool;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchTest {
    /*
Create a new class : GoogleSearchTest
Create Test method and complete the following task.
When user goes to https://www.google.com/
Search for "porcelain teapot"
And print how many related results displayed on Google
*/
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("porcelain teapot");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@value='Google Search']")).click();

        String result=driver.findElement(By.id("result-stats")).getText();
        System.out.println(result);

    }

    //Then create 3 different test methods using the following names. And Go to google. 
    //titleTest =>Verify if google title = “Google” 
    @Test
    public void titleTest(){
        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    //imageTest => Verify if google image displays or not 
    @Test
    public void imageTest(){
        boolean isExist=driver.findElement(By.id("hplogo")).isDisplayed();
        Assert.assertEquals(isExist,true);

    }

    //gmailLinkTest => Verify if the Gmail link is displayed or not
    @Test
    public void gmailLinkTest(){
        boolean isExist=driver.findElement(By.linkText("Gmail")).isDisplayed();
        Assert.assertEquals(isExist,true);

    }

    //Close the browser after each test
    @After
    public void tearDown(){
        driver.quit();
    }
}



