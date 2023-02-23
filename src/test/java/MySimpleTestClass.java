import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import util.TestConfigReader;
import util.TestDriverManager;

import java.time.Duration;

public class MySimpleTestClass {

    WebDriver driver;
    @BeforeMethod
    public void init(){
        driver = TestDriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestConfigReader.getValue("app.url"));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void validateValidLoginCredentials(){
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='login']")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//a[@id='logoutLink']")).size(),1);

    }

    @Test
    public void validateInvalidLoginCredentials(){
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("adm1n");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='login']")).click();
        Assert.assertNotEquals(driver.findElements(By.xpath("//a[@id='logoutLink']")).size(),1);
    }
}
