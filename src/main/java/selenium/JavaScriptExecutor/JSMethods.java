package selenium.JavaScriptExecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSMethods {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyRights=driver.findElement(By.xpath("//p[contains(text() ,'Copyrights')]"));

        Point location=copyRights.getLocation();
        System.out.println(location.getY());
        System.out.println(location.getX());
        int xCord=location.getX();
        int yCord=location.getY();
        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo("+xCord+","+yCord+")");

        Thread.sleep(2000);
        js.executeScript("history.go(0)"); // refresh.


    }
}
