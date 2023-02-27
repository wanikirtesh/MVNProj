package com.sbn.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import util.TestConfigReader;

public class LoginTest extends BaseTest{

    @Test
    @Parameters({"user","password","browser"})
    public void validateValidLoginCredentials(String user, String password,String browser){
        System.out.println("Running login in " + browser);
        driver.get(TestConfigReader.getValue("app.url"));
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//a[@id='logoutLink']")).size(),1);

    }

    @Test
    public void validateInvalidLoginCredentials(){
        driver.get(TestConfigReader.getValue("app.url"));
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("adm1n");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='login']")).click();
        Assert.assertNotEquals(driver.findElements(By.xpath("//a[@id='logoutLink']")).size(),1);
    }
}
