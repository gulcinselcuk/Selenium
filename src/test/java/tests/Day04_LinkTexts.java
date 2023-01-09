package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_LinkTexts {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    /*
    linktext and partialLinkTes
     */
    @Test
    public void LMSPage(){
        driver.get("https://techproeducation.com/");
        //Click on LMS LOGIN
        //LMS LOGIN IS A LINK(OPEN THAT LINK-ASAGI GENISLET)
        //TEXT OF THIS LINK IS "LMS LOGIN"
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //verify lms page is visible
        String expectedURL="https://lms.techproeducation.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED",expectedURL,actualURL);


    }

    @Test
    public void LMSPagePartialLinkText(){
        driver.get("https://techproeducation.com/");
        driver.findElement(By.partialLinkText("LMS LO")).click();
        //ALTERNATIVELY we can locate a core element on LMS page and check if that element is displayed
        WebElement loginElement= driver.findElement(By.linkText("Login/Register"));
        Assert.assertTrue(loginElement.isDisplayed());//isDisplayed() returns TRUE is element on the page, returns false if element is not displayed on the page

        //Assert.assertTrue(driver.findElement(By.linkText("Login/Register")).isDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
