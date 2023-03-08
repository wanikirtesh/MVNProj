package com.sbn.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.sbn.util.TestDriverManager;

import java.time.Duration;

public class BaseTest {
    private Logger LOGGER = LogManager.getLogger();
    protected WebDriver driver;
    @BeforeMethod(groups = {"sanity","regression"})
    @Parameters({"browser"})
    public void init(String browser, ITestResult iTestResult){
        LOGGER.info("====== Starting test "+iTestResult.getMethod().getMethodName()+" ======");
        driver = TestDriverManager.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LOGGER.error("This is forced error");
    }

    @AfterMethod(groups = {"sanity","regression"})
    public void tearDown(ITestResult iTestResult){
        driver.close();
        LOGGER.info("====== completing test "+iTestResult.getMethod().getMethodName()+"============");
    }


}
