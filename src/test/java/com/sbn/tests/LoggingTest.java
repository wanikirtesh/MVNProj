package com.sbn.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggingTest {
    Logger LOGGER = LogManager.getLogger();
    @Test
    public void myLoggingTest(){
        LOGGER.trace("This is trace Log");
        LOGGER.debug("This is Debug Log");
        LOGGER.info("This is Info Log");
        LOGGER.warn("This is Warn Log");
        LOGGER.error("This is error Log");
        LOGGER.fatal("This is fatal Log");
    }


}
