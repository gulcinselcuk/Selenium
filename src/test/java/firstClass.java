import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstClass {
    public static void main(String[] args) {
        //setting the path for chrome driver
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver");
        //2.create chrome driver
        WebDriver driver=new ChromeDriver();

        //3.write your test cases
        driver.get("https://www.amazon.com");

        driver.quit();

    }
}
