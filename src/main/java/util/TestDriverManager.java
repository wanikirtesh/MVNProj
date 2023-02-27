package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TestDriverManager {
    static WebDriver driver;
    public static WebDriver getDriver(){
        String strBrowser = TestConfigReader.getValue("browser");
        return getDriver(strBrowser);
    }

    public static WebDriver getDriver(String strBrowser){
        //String strBrowser = TestConfigReader.getValue("browser");
        switch (strBrowser.toLowerCase()){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Long.parseLong(TestConfigReader.getValue("driver.implicitwait","10"))));
        return driver;
    }

}
