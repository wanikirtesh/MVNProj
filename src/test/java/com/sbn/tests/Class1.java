package com.sbn.tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.management.Descriptor;

public class Class1 extends BaseClass{
    @Test(description = "Validate Login functionality for valid user name password ")
    public void c1test1(){
        System.out.println("\t\t\tin c1 test 1");
        test.assignAuthor("Vaibhav Kale");
        test.assignCategory("Sanity");
        Assert.fail();
    }

    @Test(description = "Validate Login functionality for invalid user name pasword")
    public void c1test2(){
        test.assignAuthor("Kirtesh Wani");
        test.assignCategory("Smoke");
        System.out.println("\t\t\tin c1 test 2");
        ExtentTest loggingIn = test.createNode("Logging In");
        loggingIn.info("Login with credentials admin , password" );
        ExtentTest navigatingToScreen = test.createNode("Navigating to screen");


        test.createNode("clicking on Button");

    }

}
