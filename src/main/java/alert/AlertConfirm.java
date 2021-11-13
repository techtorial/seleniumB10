package alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertConfirm {

    @Test
    public void jsConfirmValidation() throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));

        jsConfirm.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());

        WebElement result=driver.findElement(By.id("result"));
        String resultText=result.getText();
        Assert.assertEquals(resultText,"You clicked: Cancel");
    }
}
