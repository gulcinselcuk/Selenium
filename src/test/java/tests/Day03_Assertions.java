package tests;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {
    @Test
    public void assertions(){
        /*
            What is assertion in testing?
            Assertion is done to check if expected result is equal to actual result.
            -expected == actual -> pass
            -expected != actual -> fail
            ------------------
            assertEquals("expected","actual");
            assertTrue(true); -> pass
            assertTrue(false); -> fail
            assertFalse(false); -> pass
            assertFalse(true); -> fail
            --------------------
 */
        if("java".contains("apple")){ //fail
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }




        Assert.assertEquals(5,5);
        Assert.assertEquals("Java","Java");
        Assert.assertEquals("Java".contains("J"),true);
        //----------------------------
        Assert.assertTrue("Java".contains("J"));
        //----------------------------
        Assert.assertFalse("Java".contains("h")); //pass

        //TEST EXECUTION STOPS IF ONE ASSERTION FAILS, THIS IS CALLED HARD ASSERTION

        //TEST EXECUTION CONTINUE EVEN IF TEST VERIFICATION FAILS.VERIFICATION MEANS LIKE IF STATEMENT

        //WHAT IS DIFFERENCE BTW ASSERTION AND VERIFICATION
        // Assertion stops after fails, verification continues even it fails
        //JUnit assertions are hard assertion.If statement is verification.
        //NOTE:TestNG has soft assertion as well. we will learn it.

    }
}
