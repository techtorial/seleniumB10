package selenium.SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class CarsSelect {

    @Test
    public void testCars() throws InterruptedException {
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://www.cars.com/");

        WebElement newUsed=driver.findElement(By.id("make-model-search-stocktype"));
        WebElement make=driver.findElement(By.id("makes"));
        WebElement model=driver.findElement(By.id("models"));
        WebElement searchButton=driver.findElement(By.xpath("//div[@id='by-make-tab']//button"));

        BrowserUtils.selectBy(newUsed,"New cars","text");
        BrowserUtils.selectBy(make, "porsche","value");
        BrowserUtils.selectBy(model, "4", "index");

        searchButton.click();

        Thread.sleep(1000);
        WebElement header=driver.findElement(By.xpath("//h1"));
        String actual=BrowserUtils.getText(header);
        String expected="New Porsche 911 for sale";
        Assert.assertEquals(actual,expected);

    }

}
