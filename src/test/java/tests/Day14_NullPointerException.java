package tests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day14_NullPointerException{

    //    DECLARED BUT NEVER INSTANTIALTED
    WebDriver driver;
    Faker faker=new Faker();

    @Test
    public void npetest(){
        driver.get("https://techproeducation.com/");
    }

    @Test
    public void npetest1(){
        System.out.println(faker.name().fullName()); //null pointer exception
    }
}
