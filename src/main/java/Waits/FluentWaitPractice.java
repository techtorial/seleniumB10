package Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitPractice {

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();

        Wait<WebDriver> fluentWait=new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Text on the page")
                .withTimeout(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement message=fluentWait.until(myDriver -> driver.findElement(By.id("message")));


        System.out.println(message.getText());

    }
}
