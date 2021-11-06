package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectIntro {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select select=new Select(dropDown);
        String actualFirstSelected=select.getFirstSelectedOption().getText().trim();
        String expectedFirstSelect="Please select an optio";

        Thread.sleep(2000); // my code will pause on this line for 2 sec
        select.selectByValue("1");
        Thread.sleep(2000);
        select.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        select.selectByIndex(1);

        Assert.assertEquals(actualFirstSelected, expectedFirstSelect,"first selected");

    }
}
