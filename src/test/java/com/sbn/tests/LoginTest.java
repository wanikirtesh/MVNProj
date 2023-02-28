package com.sbn.tests;

import com.sbn.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import util.TestConfigReader;

public class LoginTest extends BaseTest{

    @Test
    @Parameters({"user","password"})
    public void validateValidLoginCredentials(String user, String password){
        LoginPage loginPage = new LoginPage(driver);
        boolean isLoggedIn = loginPage.doLogin(user,password);
        Assert.assertTrue(isLoggedIn);
    }

    @Test
    public void validateInvalidLoginCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        boolean isLoggedIn = loginPage.doLogin("user","password");
        Assert.assertFalse(isLoggedIn);
    }
}
