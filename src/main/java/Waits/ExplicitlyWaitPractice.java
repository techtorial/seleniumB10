package Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class ExplicitlyWaitPractice {

    @Test
    public void validateWait(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton=driver.findElement(By.xpath("//button"));
        startButton.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement hello=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));

        Assert.assertEquals(hello.getText(),"Hello World!");
    }
}
