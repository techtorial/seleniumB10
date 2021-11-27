package selenium.test.etsy;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver();
        // Implicitly wait will wait all the page element that my Driver pointing.
        // It will wait 5 sec till element load is completed.
        // After 5 sec if the element is not available it will throw noSuchElementException
        driver.get(ConfigReader.readProperty("etsyUrl"));
    }

    @AfterMethod
    public void tearDown(ITestResult result){

        if(!result.isSuccess()){
            BrowserUtils.getScreenShot(driver, "etsyscreenshots");
        }
        Driver.tearDown();

    }
}
