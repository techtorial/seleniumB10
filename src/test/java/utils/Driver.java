package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    // private variable
    private static WebDriver driver;

    // private constructor
    private Driver(){}

    // public method
    public static WebDriver getDriver(){
        String browser=ConfigReader.readProperty("browser");
        if(driver==null){ // check your driver is null or not.
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    //  WebDriverManager.firefoxdriver().setup();
                    //   System.setProperty("webdriver.firefox.marionette","geckodriver");
                    // System.setProperty("webdriver.gecko.driver", "geckodriver");
                    driver=new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

        return driver;
    }

    public static void tearDown(){
        driver.quit();
        driver=null;
    }

}
