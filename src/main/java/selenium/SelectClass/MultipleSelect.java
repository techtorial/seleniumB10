package selenium.SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultipleSelect {

    @Test
    public void test(){

        WebDriver driver=new ChromeDriver();
        driver.navigate().to("file:///Users/techtorial/Downloads/Techtorial.html");

        WebElement multiple=driver.findElement(By.className("select"));
        Select select=new Select(multiple);
        select.selectByIndex(0);
        select.selectByVisibleText("Three");
        select.selectByValue("4");

        select.deselectByVisibleText("Three");
        select.deselectByValue("4");

        // getOptions() > List<WebElement>
        // WebDriverManager -> help us to manage the version of the Driver.


    }
}
