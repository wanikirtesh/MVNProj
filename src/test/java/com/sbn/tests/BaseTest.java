package com.sbn.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import util.TestConfigReader;
import util.TestDriverManager;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    @BeforeMethod
    @Parameters({"browser"})
    public void init(String browser){
        driver = TestDriverManager.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
