package selenium.actionspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContextClickPractice {


    @Test
    public void test(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box=driver.findElement(By.id("hot-spot"));

        Actions actions=new Actions(driver);
        actions.contextClick(box).perform();

    }

    @Test
    public void hoverOver(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        // TASK find the xpath form all user names
        List<WebElement> names=driver.findElements(By.xpath("//h5"));
        List<WebElement> pictures=driver.findElements(By.xpath("//div/img"));
        Actions actions=new Actions(driver);
        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");

        for(int i=0;i<names.size();i++){
            actions.moveToElement(pictures.get(i)).perform();
           actualNames.add(BrowserUtils.getText(names.get(i)));
        }

        Assert.assertEquals(actualNames, expectedNames);

    }
}
