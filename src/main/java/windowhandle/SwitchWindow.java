package windowhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {

    @Test
    public void test(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        String mainWindowId=driver.getWindowHandle(); // 123
        Set<String> ids=driver.getWindowHandles(); // 123 - 124

        for(String id: ids){
            System.out.println(id);
            if(!id.equals(mainWindowId)){
                driver.switchTo().window(id);
            }
        }


        WebElement newWindow=driver.findElement(By.xpath("//h3[.='New Window']"));
        String actualText= newWindow.getText();
        String expectedText="New Window";
        Assert.assertEquals(actualText, expectedText,"New window validation");

        driver.quit(); // close all the windows.

    }


    @Test
    public void test2(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        String mainWindowId=driver.getWindowHandle();
        Set<String> ids=driver.getWindowHandles();
        // close only second window.
        for(String id:ids){
            if(!id.equals(mainWindowId)){
                driver.switchTo().window(id);
                driver.close(); // close only one window
            }
        }

        driver.switchTo().window(mainWindowId);
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }
}
