package com.sbn.pages;

import com.sbn.entity.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.TestConfigReader;

import java.util.List;

public class E3Page extends BasePage {
    public E3Page(WebDriver driver){
        super(driver);
        driver.get(TestConfigReader.getValue("app.url.e3"));
    }

    public boolean validateAllInlineRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='order-table']/tbody/tr"));
        for (WebElement row : rows) {
            row.findElement(By.xpath(".//a[text()='Inline']")).click();
            WebElement iframe = driver.findElement(By.xpath("//td/iframe"));
            Employee mainTableEmployee = getEmployeeFromRow(row);
            driver.switchTo().frame(iframe);
            Employee frameEmployee = getEmployeeFromOutSide(1);
            driver.switchTo().defaultContent();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src,'close.png')]")));
            driver.findElement(By.xpath("//img[contains(@src,'close.png')]")).click();
        }
        return true;
    }

    public boolean validateAllPopups() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='order-table']/tbody/tr"));
        for (WebElement row : rows) {
            row.findElement(By.xpath(".//a[text()='Details']")).click();
            Employee mainTableEmployee = getEmployeeFromRow(row);
            switchToLatestWindows();
            Employee popupEmployee = getEmployeeFromOutSide(2);
            driver.close();
            switchToLatestWindows();
        }
        return true;
    }

    private Employee getEmployeeFromOutSide(int startIndex) {
        Employee employee = new Employee(driver.findElement(By.xpath("//table//tr["+(startIndex++)+"]/td")).getText(),
                driver.findElement(By.xpath("//table//tr["+(startIndex++)+"]/td")).getText(),
                driver.findElement(By.xpath("//table//tr["+(startIndex++)+"]/td")).getText(),
                driver.findElement(By.xpath("//table//tr["+(startIndex++)+"]/td")).getText());
        return employee;
    }

    private Employee getEmployeeFromRow(WebElement row) {
        Employee mainTableEmployee = new Employee(row.findElement(By.xpath("./td[2]")).getText(),
                row.findElement(By.xpath("./td[3]")).getText(),
                row.findElement(By.xpath("./td[4]")).getText(),
                row.findElement(By.xpath("./td[5]")).getText());
        return mainTableEmployee;
    }

    private void switchToLatestWindows() {
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
    }

    public void validateSpecificRowInline(int rowNumber) {

    }
}
