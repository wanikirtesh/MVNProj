package com.sbn.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class2 extends BaseClass {


    @Test(description = "Validate User creation functionality")
    public void c2test1(){
        System.out.println("\t\t\tin c2 test 1");
    }

    @Test(description = "Validate User Deletion functionality")
    public void c2test2(){
        System.out.println("\t\t\tin c2 test 2");
    }

}
