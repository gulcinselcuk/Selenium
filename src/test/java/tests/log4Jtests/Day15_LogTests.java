package tests.log4Jtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_LogTests {
    private static Logger logger= LogManager.getLogger(Day15_LogTests.class.getName());
    @Test
    public void test1(){
        logger.fatal("Fatal Logger !!!");
        logger.error("Error Logger !!!");
        logger.warn("Warning Logger !!!");
        logger.debug("Debug Logger !!!");
        logger.info("Info Logger !!!");

    }
}
