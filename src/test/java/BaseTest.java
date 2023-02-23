import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.TestConfigReader;
import util.TestDriverManager;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    @BeforeMethod
    public void init(){
        driver = TestDriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
