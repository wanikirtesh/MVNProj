import com.sbn.entity.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestConfigReader;

import java.util.List;

public class E3Test extends BaseTest {


    @Test
    public void validateInlineData(){
        driver.get(TestConfigReader.getValue("app.url.e3"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='order-table']/tbody/tr"));
        for (WebElement row : rows) {
            row.findElement(By.xpath(".//a[text()='Inline']")).click();
            WebElement iframe = driver.findElement(By.xpath("//td/iframe"));
            Employee mainTableEmployee = new Employee(row.findElement(By.xpath("./td[2]")).getText(),
                    row.findElement(By.xpath("./td[3]")).getText(),
                    row.findElement(By.xpath("./td[4]")).getText(),
                    row.findElement(By.xpath("./td[5]")).getText());
            driver.switchTo().frame(iframe);
            Employee frameEmployee = new Employee(driver.findElement(By.xpath("//table//tr[1]/td")).getText(),
                    driver.findElement(By.xpath("//table//tr[2]/td")).getText(),
                    driver.findElement(By.xpath("//table//tr[3]/td")).getText(),
                    driver.findElement(By.xpath("//table//tr[4]/td")).getText());
            driver.switchTo().defaultContent();
            Assert.assertEquals(frameEmployee,mainTableEmployee);
        }
    }



}
