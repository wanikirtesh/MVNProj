package com.sbn.pages.travelyari;

import com.sbn.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver)  {
        super(driver);
        driver.get("https://www.travelyaari.com/");
    }

    public SearchResultPage search(String from, String to) {
        driver.findElement(By.id("from-city")).sendKeys(from);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'tc-city-matched')]//li[@title='"+from+"']"))));
        driver.findElement(By.xpath("//div[contains(@class,'tc-city-matched')]//li[@title='"+from+"']"));
        driver.findElement(By.id("to-city")).sendKeys(to);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'tc-city-matched')]//li[@title='"+to+"']"))));
        driver.findElement(By.xpath("//div[contains(@class,'tc-city-matched')]//li[@title='"+to+"']"));
        driver.findElement(By.xpath("//button[text()='Search Bus']")).click();
        return new SearchResultPage(driver,from,to, LocalDate.now());
    }
}
