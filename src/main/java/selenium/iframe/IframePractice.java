package selenium.iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {

    // navigate to "https://the-internet.herokuapp.com/iframe"
    // delete the text using selenium "Your content goes here."
    // send key "Hello Java!" into the text box

    @Test
    public void test(){
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        WebElement textBox=driver.findElement(By.id("tinymce"));

        textBox.clear();
        textBox.sendKeys("Hello Java!");

        driver.switchTo().parentFrame();
        // parentFrame() goes one parent up in the inner html.

        WebElement title=driver.findElement(By.tagName("h3"));
        String actualTitle=title.getText().trim();
        String expectedTitle="An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
