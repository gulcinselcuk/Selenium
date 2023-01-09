package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

public abstract class TestBase {

    protected static  WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @After
    public void tearDown() {

            waitFor(3);
            driver.close();

    }


    //Auto Complete reusable method
    //This code is used for selecting and verfying our app auto complete search functionality
    //NOTE: THIS REUSABLE METHOD DESIGNED FOR OUR CURRENT PROJECT. THIS MAY NOT WORK FOR NEW PROJECTS, BUT CAN BE MODIFIED AND USED FOR THAT NEW PROJECT
    //NOTE: YOU WILL SEE THIS KIND OF REUSABLE METHOD THAT IS SPECIFIC TO YOUR OWN PROJECT
    //THE POINT OF REUSABLE METHOD IS : WRITE ONCE USE MULTIPLE TIMES TO SAVE TIME AND SHORT TEST CLASS


    public static void searchAndSelectFromList(String keyword, String textFromList) throws InterruptedException {

        searchAndSelectFromList("uni", "United Kingdom");
        Thread.sleep(2000);  //putting wait to see steps slower

        //Sending a keyword dynamically using Paramater 1
        driver.findElement(By.id("myCountry")).sendKeys(keyword);       //uni
        Thread.sleep(2000);

        //Selecting an option from the list Dynamically using Parameter 2
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='"+ textFromList +"']")).click();  //United Kingdom
        Thread.sleep(2000);

        //Nothing special, just click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();  //click on submit button
        Thread.sleep(2000);

        //Assertion, verifying if result contains my the option that I selected Dynamically using parameter 2
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains(textFromList));
    }


    //take Screenshot Of Entire Page with this reusable method
    public void takeScreenshotOfPage() throws IOException {

        //to create screenshot we have steps
        //1. Take screenshot using getScreenshotAs method and TakeScreenshot API-coming from selenium
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);        //file -->select this one -->java.io.File;


        //2. Creating a PATH with dynamic name for the image
        //Save the screenshot in a path and save with dynamic name. //We can use the current date to use in name
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  //getting the curreent local date and time
        //path is where we save screenshot. Project/Folder(test-output) /Folder  /Name of image .png
        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+"image.png";//Where we save the image
        //This is the project

        //3. Saving the image in the path
        FileUtils.copyFile(image,new File(path));


    }


    //Take screenshot of Specific Element
    public void takeScreenshotOfTheElement(WebElement element) throws IOException {

        //1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);

        //2.create a dynamic path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  //getting the curreent local date and time
        //path is where we save screenshot. Project/Folder(test-output) /Folder  /Name of image .png
        String destFile = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+"logo.png";//Where we save the image

        //3. Saving the image in the path
        FileUtils.copyFile(image,new File(destFile));


    }

    /*   HARD WAIT:
     @param : second        --> parameter
 */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    /*
  JAVASCRIPT EXECUTOR
  @param WebElement
  Accepts a web element and scrolls into that element
  We may need to scroll for capturing the screenshots property.
  We may need to scroll to specific elements with js executer because some elements may not LOAD properly
  unless we scroll to that elements.
   */
    public void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }


    /*
    scroll the page all the down
     */
    public void scrollAllDownByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }


    /*
    scroll the page all the way up
     */
    public void scrollAllUpByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }


    /*click on element
    @param : WebElement
    Normally we use element.click() method in Selenium
    When there is an issue with click()-hidden, different UI ...
    Then we can use javascript click that works better  */

    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }


    /*
    this is same as sendKeys
    @param : WebElement, String
    Types the string in the WebElement

    element.sendKeys("text") to type in an input
    ALTERNATIVELY we can use  js executor to type in an input
    arguments[0].setAttribute('value','admin123');  -> SAME AS element.sendKeys("admin123"), type admin123 in then value

     INTERVIEW :What are the selenium methods that you use to type in an input?
     -sendKeys()
     -with javascript executer we can change the value of the input.
     */
    public void setValueByJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
        //We can change value (input), with this text
    }


    //param: Id of the element
    public void getValueByJS(String idOfElement){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);

//        How you get the value of an input box?
//        We can js executor.
//        How?
//        I can get the element using js executor, and get the value of the element.
//        For example, I can get the element by id, and use value attribute to get the value of in an input
//        I have to do this, cause getText in this case does not return the text in an input

        //sometimes there is default value in input. for to get this value, we can use this method.  -->fe: value="1/2/2023" is default if you dont select a date.
        //We are able to get the default value of the Check-in Check-out box
        //This is one of the limitations of the selenium because normally, we cannot get the value of an attribute with selenium

    }


    //    Changes the changeBackgroundColorByJS of an element. Params: WebElement element, String color. NOT COMMON
    public void changeBackgroundColorByJS(WebElement element, String color){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
    }


    //    NOT COMMON
    public void addBorderWithJS(WebElement element, String borderStyle){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);
    }





    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static WebElement waitForClickability(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }


    //This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }


    //======Fluent Wait====//
    //params: xpath of the element, max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception") //OPTIONAL: Give Message
                .ignoring(NoSuchElementException.class); //OPTIONAL : Ignore Exception

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        return element;
    }


    public static void acceptCookies(String id){

        WebElement acceptCookies = driver.findElement(By.id("\"" + id + "\""));
        if(acceptCookies.isDisplayed()) {
            acceptCookies.click();
        }
    }
}