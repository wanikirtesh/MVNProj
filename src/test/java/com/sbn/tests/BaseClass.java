package com.sbn.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseClass {
    protected static ExtentReports extent;
    ExtentTest test;
    @BeforeMethod
    public void initMethod(ITestResult testResult){
        System.out.println("\t\t=before method=");
        test = extent.createTest(testResult.getMethod().getDescription());
    }
    @AfterMethod
    public void afterMethod(ITestResult testResult){
        System.out.println("\t\t=after method=");
        if(testResult.getStatus()!=1){
            test.fail(testResult.getThrowable());
        }
    }



    @BeforeClass
    public void beforeCalsss(){
        System.out.println("\t==before class==");
    }

    @AfterClass
    public void afterCalsss(){
        System.out.println("\t==after class==");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("===Before test===");

    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("====Before Suite===");
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("./report/index.html");
        extent.attachReporter(spark);

    }

    @AfterTest
    public void afterTest(){
        System.out.println("===After test===");
    }


    @AfterSuite
    public void afterSuite(){
        System.out.println("====after Suite===");
        extent.flush();
    }


}
