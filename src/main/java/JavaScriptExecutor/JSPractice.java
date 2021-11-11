package JavaScriptExecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class JSPractice {

    @Test
    public void test(){
       
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.techtorialacademy.com/");

        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;

        String title= javascriptExecutor.executeScript("return document.title").toString(); // get title

        System.out.println(title);

        WebElement browseCourse=driver.findElement(By.linkText("Browse Course"));
        javascriptExecutor.executeScript("arguments[0].click()",browseCourse);

        WebElement copyRights=driver.findElement(By.xpath("//p[contains(text() ,'Copyrights')]"));
        BrowserUtils.scrollToView(driver, copyRights);
        // find the student login button on the top of the page
        // and scroll the page to top till studentLogin button is visible.

        WebElement loginButton=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[contains(text(),'Student login')]"));

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",loginButton);

    }
}
