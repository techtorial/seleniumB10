package iframe;

import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class NestedFramePractice {

    @Test
    public void nestedFrameValidation(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(0); // frame-top
        WebElement middleFrame=driver.findElement(By.name("frame-middle"));
        // we should find the webelement of the middle frame
        driver.switchTo().frame(middleFrame); //frame-middle

        WebElement middleText=driver.findElement(By.id("content"));
        String actualText=middleText.getText();
        String expectedText="MIDDLE";
        Assert.assertEquals(actualText, expectedText);

        driver.switchTo().defaultContent(); // it will switch to the main html.
        driver.switchTo().frame("frame-bottom");
        WebElement bottom=driver.findElement(By.tagName("body"));

        Assert.assertEquals(bottom.getText().trim(), "BOTTOM");

    }

    @Test
    public void printRightAndLeft(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // print text from RIGHT and LEFT
        driver.switchTo().frame(0); // frame-top
        WebElement rightFrame=driver.findElement(By.name("frame-right"));
        driver.switchTo().frame(rightFrame);
        WebElement rightText=driver.findElement(By.tagName("body"));
        System.out.println(BrowserUtils.getText(rightText)); // right

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");
        WebElement leftText=driver.findElement(By.tagName("body"));
        System.out.println(BrowserUtils.getText(leftText)); //left


    }
}
