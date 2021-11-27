package selenium.SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.*;

public class SelectMethods {

    @Test
    public void test(){
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");

        WebElement price=driver.findElement(By.id("make-model-max-price"));
        Select select=new Select(price);
        List<WebElement> prices=select.getOptions();
       // Set<String> actualOrder=new LinkedHashSet<>();
        //Set<String> expectedOrder=new TreeSet<>();
        List<String> actual=new ArrayList<>();
        List<String> expected=Arrays.asList("No max price","$2,000","$4,000");

        for(WebElement pr : prices){
            actual.add(BrowserUtils.getText(pr)); // insertion order
        }

        Assert.assertEquals(actual,expected);
    }
}
