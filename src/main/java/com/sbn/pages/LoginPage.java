package com.sbn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.TestConfigReader;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(TestConfigReader.getValue("app.url"));
    }

    public boolean doLogin(String userName, String password){
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        return driver.findElements(By.xpath("//a[@id='logoutLink']")).size()>0;
    }
}
