package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EtsyPractice {

    @Test
    public void test(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.etsy.com/");
        WebElement header=driver.findElement(By.xpath("//h1[contains(text() , 'holidays!')]"));
        String actualText=header.getText();
        String expectedText="Bring on the holidays! Discover meaningful finds.";

        Assert.assertEquals(actualText, expectedText,"Etsy Header");
    }
}
