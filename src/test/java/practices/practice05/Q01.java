package practices.practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Q01 extends TestBase {

    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

        //calculate the total amount on the table
        List<WebElement> amounts=driver.findElements(By.xpath("//tbody/tr/td[2]"));

        double sum=0;
        for (WebElement w:amounts){
            sum+=Double.parseDouble(w.getText());
        }
        System.out.println("sum: "+sum);

        //assert the amount
        assertTrue(sum==110.3);
    }
}
