package com.sbn.pages.travelyari;

import com.sbn.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchResultPage extends BasePage {
    private final String from,to;
    private final LocalDate bookingDate;
    public SearchResultPage(WebDriver driver, String from, String to, LocalDate bookingDate) {
        super(driver);
        this.from = from;
        this.to=to;
        this.bookingDate = bookingDate;
    }

    public void validateSearchCriteria() {
        String actualLabel = driver.findElement(By.cssSelector(".modify-txt")).getText();
        String bookingDateLabel = driver.findElement(By.cssSelector(".jurnyDt")).getText();
        Assert.assertEquals(actualLabel,from+" to " + to);
        Assert.assertEquals(bookingDateLabel,bookingDate.format(DateTimeFormatter.ofPattern("eee, d MMM")));
    }
}
